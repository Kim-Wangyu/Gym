package com.gym.s1.apply;

import java.sql.Date;
import java.util.ArrayList;
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
	public String apply(HttpSession session,ApplyDTO applyDTO,Long memberNum)throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		MembershipDTO membershipDTO = new MembershipDTO();
		membershipDTO.setMemberNum(memberDTO.getMemberNum());
		membershipDTO = applyService.findMembershipNum(membershipDTO);
		TrainerDTO trainerDTO = new TrainerDTO();
		trainerDTO.setMemberNum(memberNum);
		trainerDTO = applyService.findTraNum(trainerDTO);
		applyDTO.setTraNum(trainerDTO.getTraNum());
		List<ApplyDTO> ar = applyService.findApplyNum(applyDTO);
		ar.get(0).setMembershipNum(membershipDTO.getMembershipNum());
		int result = applyService.apply(ar.get(0));
		return "redirect:./calendar";
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

}