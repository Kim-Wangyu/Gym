package com.gym.s1.member;

import java.net.http.HttpRequest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gym.s1.board.BoardDTO;
import com.gym.s1.board.qna.QnaDTO;

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
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@GetMapping("login")
	public String login()throws Exception{
		return "./member/login";
	}
	
	@PostMapping("login")
	public String login(MemberDTO memberDTO, HttpSession session, String remember, HttpServletResponse response,Model model)throws Exception{
		memberDTO = memberService.login(memberDTO);
		String path = "../";
		String message = "";
		if(memberDTO!=null) {
			message="로그인성공";
			if(remember!=null&&remember.equals("1")) {
				Cookie cookie = new Cookie("rememberid", memberDTO.getId());
				response.addCookie(cookie);
				cookie.setMaxAge(-1);
			}
		}else {
			message="로그인실패";
			path= "./login";
		}
		session.setAttribute("member", memberDTO);
		model.addAttribute("message", message);
		model.addAttribute("path", path);
		return "common/result";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session)throws Exception{
		session.invalidate();
		return "redirect:../";
	}
	
	@GetMapping("mypage")
	public String mypage()throws Exception{
		return "./member/mypage";
	}	
	
	@GetMapping("update")
	public String update(MemberDTO memberDTO, ModelAndView mv) throws Exception{
		return "./member/update";
	}
	@PostMapping("update")
	public String update(MemberDTO memberDTO,HttpSession session) throws Exception{
		int result =memberService.update(memberDTO);
		if(result ==1) {
			session.setAttribute("member", memberDTO);
		}
		return "./member/mypage";
	}
	@GetMapping("pwupdate")
	public String pwupdate(MemberDTO memberDTO, ModelAndView mv) throws Exception{
		return "./member/pwupdate";
	}
	@PostMapping("pwupdate")
	public String pwupdate(MemberDTO memberDTO) throws Exception{
		int result =memberService.pwupdate(memberDTO);

		return "./member/mypage";
	}
	
	
}
