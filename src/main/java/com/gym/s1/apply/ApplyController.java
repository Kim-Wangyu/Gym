package com.gym.s1.apply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	@PostMapping("add")
	public ModelAndView add(ApplyDTO applyDTO,String[] day1)throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println(day1);
		System.out.println(applyDTO.getTime());
		mv.setViewName("./apply/calendar");
		return mv;
	}
	
	@GetMapping("add")
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
