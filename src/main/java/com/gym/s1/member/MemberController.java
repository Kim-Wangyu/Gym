package com.gym.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("join")
	public String Join()throws Exception{
		return "./member/join";
	}
	
	@PostMapping("join")
	public ModelAndView join(MemberDTO memberDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result =  memberService.join(memberDTO);
		mv.addObject("result",result);
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@GetMapping("login")
	public String login()throws Exception{
		return "./member/login";
	}
	
	@PostMapping("login")
	public ModelAndView login(MemberDTO memberDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		memberDTO = memberService.login(memberDTO);
		mv.addObject("member",memberDTO);
		mv.setViewName("redirect:/");
		System.out.println(memberDTO.getName());
		return mv;
	}
	
}
