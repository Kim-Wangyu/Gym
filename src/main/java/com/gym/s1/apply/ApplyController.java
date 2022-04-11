package com.gym.s1.apply;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gym.s1.member.MemberDTO;
import com.gym.s1.member.MembershipDTO;
import com.gym.s1.member.TrainerDTO;

@Controller
@RequestMapping(value="/apply/*")
public class ApplyController {
	@Autowired
	private ApplyService applyService;
	
	@GetMapping("buy")
	public String buy()throws Exception{
		return "./apply/buy";
	}
	//강사가 시간 추가
	@PostMapping("addApply")
	public ModelAndView addApply(ApplyDTO applyDTO , String[] addDay , String[] addTime , HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		TrainerDTO trainerDTO = (TrainerDTO)session.getAttribute("trainer");
		for(int i = 0; i<addDay.length; i++) {
			applyDTO= new ApplyDTO();
			// day 집어넣기
			String a = addDay[i];
			a=a.replace("년","-");
			a=a.replace("월","-");
			a=a.replace("일","");
			Date day = Date.valueOf(a);
			applyDTO.setDay(day);
			applyDTO.setTime(addTime[i]);
			applyDTO.setTraNum(trainerDTO.getTraNum());
			applyService.addApply(applyDTO);
		}
		mv.setViewName("./apply/calendar");
		return mv;
	}
	
	@GetMapping("addApply")
	public String add()throws Exception{
		return "./apply/add";
	}
	//회원이 수강신청
	@PostMapping("apply")
	public ModelAndView apply(HttpSession session,ApplyDTO applyDTO,Long memberNum,Date day)throws Exception{
		ModelAndView mv = new ModelAndView();
		boolean trainerCheck = true;
		boolean countCheck = true;
		boolean applyDay = true;
		String message ="";
		//login된 회원정보 가져오기
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		//login된 회원의 membership찾기
		MembershipDTO membershipDTO = new MembershipDTO();
		membershipDTO.setMemberNum(memberDTO.getMemberNum());
		membershipDTO = applyService.findMembershipNum(membershipDTO);
		TrainerDTO trainerDTO = new TrainerDTO();
		trainerDTO.setMemberNum(memberNum);
		trainerDTO = applyService.findTraNum(trainerDTO);
		applyDTO.setTraNum(trainerDTO.getTraNum());
		List<ApplyDTO> ar = applyService.findApplyNum(applyDTO);//day, time, trinum이 들어가야함
		ar.get(0).setMembershipNum(membershipDTO.getMembershipNum());//여러개면 가장 첫번째꺼
		//count 0이상일때 
		if(membershipDTO.getCount()==null||membershipDTO.getCount()<1) {
			countCheck=false;
			message="회원권이 부족합니다.";
		}
		//회원권 강사와 신청한 강사가 같을때
		if(membershipDTO.getTraNum()!=applyDTO.getTraNum()) {
			trainerCheck=false;
			message="강사를 확인하세요";
		}
		//신청날짜가 현재날짜보다 이전일때
		if(trainerCheck&&countCheck&&applyDay) {
			int result = applyService.apply(ar.get(0));
			if(result==1) {
				Long recount = membershipDTO.getCount()-1;
				membershipDTO.setCount(recount);
				applyService.countUpdate(membershipDTO);
				message="신청이 정상적으로 완료되었습니다.";
				
			}
			
		}
		mv.addObject("path","./calendar");
		mv.addObject("message",message);
		mv.setViewName("./apply/result");
		return mv;
	}
	//신청페이지 이동
	@GetMapping("calendar")
	public ModelAndView calendar()throws Exception{
		ModelAndView mv = new ModelAndView();
//		List<ApplyDTO> ar = applyService.applyList();
//		List<MemberDTO> ar2 = applyService.trainerName();
//		mv.addObject("list",ar);
//		mv.addObject("trainerName",ar2);
		mv.setViewName("./apply/calendar");
		return mv;
	}
	
	@PostMapping("clickDay")
	public ModelAndView clickDay(String cday)throws Exception{
		ModelAndView mv = new ModelAndView();
		ApplyDTO applyDTO = new ApplyDTO();
		cday=cday.replace("년","-");
		cday=cday.replace("월","-");
		cday=cday.replace("일","");
		Date day = Date.valueOf(cday);
		applyDTO.setDay(day);
		List<ApplyDTO> ar = applyService.applyList(applyDTO);
		List<MemberDTO> ar2 = new ArrayList<MemberDTO>();
		//이름 중복제거
 		for(int i=0; i<ar.size();i++) {
			TrainerDTO trainerDTO = new TrainerDTO();
			trainerDTO.setTraNum(ar.get(i).getTraNum());
			MemberDTO memberDTO = applyService.trainerName(trainerDTO); 
			boolean a = true;
			for(int j = 0 ; j<ar2.size() ;j++) {//a b a
				if(memberDTO.getName().equals(ar2.get(j).getName())) {
					a = false;
					break;
					}
				}
			if(a) {
				ar2.add(memberDTO);
				}			
			}
 		mv.addObject("list",ar);
		mv.addObject("traName",ar2);

		if(ar.size()==0) {
			mv.setViewName("apply/empty");
		}else {
			mv.setViewName("apply/clickDay");
		}
		return mv;
 		}

	@GetMapping("getTime")
	public ModelAndView getTime(ApplyDTO applyDTO,Long memberNum)throws Exception{
		ModelAndView mv = new ModelAndView();
		TrainerDTO trainerDTO = new TrainerDTO();
		trainerDTO.setMemberNum(memberNum);
		trainerDTO = applyService.findTraNum(trainerDTO);
		applyDTO.setTraNum(trainerDTO.getTraNum());
		List<ApplyDTO> ar=applyService.timeList(applyDTO);
		mv.addObject("time",ar);
		mv.setViewName("apply/getTime");
		return mv;
	}
	
	@GetMapping("myApply")
	public ModelAndView myApply(MemberDTO memberDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		MembershipDTO membershipDTO = new MembershipDTO();
		membershipDTO.setMemberNum(memberDTO.getMemberNum());
		membershipDTO = applyService.findMembershipNum(membershipDTO);
		ApplyDTO applyDTO = new ApplyDTO();
		applyDTO.setMembershipNum(membershipDTO.getMembershipNum());
		List<ApplyDTO> ar = applyService.myApplyList(applyDTO);
		List<MemberDTO> ar2 = new ArrayList<MemberDTO>();
		for(int i = 0 ; i < ar.size();i++) {
			TrainerDTO trainerDTO = new TrainerDTO();
			trainerDTO.setTraNum(ar.get(i).getTraNum());
			MemberDTO memberDTO2 = applyService.trainerName(trainerDTO);
			ar2.add(memberDTO2);
		}
		mv.addObject("list",ar);
		mv.addObject("list2",ar2);
		if(ar.size()==0) {
			mv.setViewName("apply/empty2");
		}else {
			mv.setViewName("apply/myApply");
		}
		
		return mv;
	}
	
	@PostMapping("delApply")
	public ModelAndView delApply(ApplyDTO applyDTO,HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = applyService.applyDelete(applyDTO);
		mv.setViewName("apply/empty2");
		return mv;
	}
	@GetMapping("myStudy")
	public ModelAndView myStudy(TrainerDTO trainerDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		ApplyDTO applyDTO = new ApplyDTO();
		applyDTO.setTraNum(trainerDTO.getTraNum());
		List<ApplyDTO> ar = applyService.myStudyList(applyDTO);
		List<MemberDTO> ar2 = new ArrayList<MemberDTO>();
		for(int i = 0 ; i < ar.size();i++) {
			//membershipnum으로 membership에서 전체정보가져오기(membernum)
			//membernum으로 member전체정보 가져오기(name)
			MembershipDTO membershipDTO = new MembershipDTO();
			MemberDTO memberDTO2= new MemberDTO();
			if(ar.get(i).getMembershipNum()!=null) {
			membershipDTO.setMembershipNum(ar.get(i).getMembershipNum());
			membershipDTO = applyService.findMemberNum(membershipDTO);
			memberDTO2.setMemberNum(membershipDTO.getMemberNum());
			memberDTO2 = applyService.findMemberName(memberDTO2);
			}else {
				memberDTO2.setName("-");
			}
			ar2.add(memberDTO2);
		}
		mv.addObject("list",ar);
		mv.addObject("list2",ar2);
		if(ar.size()==0) {
			mv.setViewName("apply/empty2");
		}else {
			mv.setViewName("apply/myStudy");
		}
		
		return mv;
	}
	@PostMapping("delStudy")
	public ModelAndView delStudy(ApplyDTO applyDTO,HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = applyService.studyDelete(applyDTO);
		mv.setViewName("apply/empty2");
		return mv;
	}
}