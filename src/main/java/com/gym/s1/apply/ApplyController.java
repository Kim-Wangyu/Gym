package com.gym.s1.apply;

import java.sql.Date;

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

@Controller
@RequestMapping(value="/apply/*")
public class ApplyController {
	@Autowired
	private ApplyService applyService;
	
	@GetMapping("buy")
	public String buy()throws Exception{
		return "./apply/buy";
	}
	
	@PostMapping("addApply")
	public ModelAndView addApply(ApplyDTO applyDTO , String[] addDay , String[] addTime , HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		Long membernum = memberDTO.getMemberNum();
		for(int i = 0; i<addDay.length; i++) {
			applyDTO= new ApplyDTO();
			// day 집어넣기
			String a = addDay[i];
			a=a.replace("년","-");
			a=a.replace("월","-");
			a=a.replace("일","");
			Date day = Date.valueOf(a);
			applyDTO.setDay(day);
			
			//time집어넣기
			
//			String b = addTime[i].substring(0, 2);
//			if(b.equals("9:")) {
//				time = 1L;
//			}else if(b.equals("10")) {
//				time = 2L;
//			}else if(b.equals("11")) {
//				time = 3L;
//			}else if(b.equals("12")) {
//				time = 4L;
//			}else if(b.equals("13")) {
//				time = 5L;
//			}
//			else if(b.equals("14")) {
//				time = 6L;
//			}
//			else if(b.equals("15")) {
//				time = 7L;
//			}else if(b.equals("16")) {
//				time = 8L;
//			}else if(b.equals("17")){
//				time = 9L;
//			}else {
//				time= 10L;
//			}
			applyDTO.setTime(addTime[i]);
			applyDTO.setMemberNum(membernum);
			applyService.addApply(applyDTO);
		}
		mv.setViewName("./apply/calendar");
		return mv;
	}
	
	@GetMapping("addApply")
	public String add()throws Exception{
		return "./apply/add";
	}
	
	@PostMapping("calendar")
	public String apply(HttpSession session,HttpServletRequest request)throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		String a = request.getParameter("exercise");
		String b = request.getParameter("time");
		return "redirect:./calendar";
	}
	
	@GetMapping("calendar")
	public ModelAndView calendar()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("./apply/calendar");
		return mv;
	}
	
}