package com.gym.s1.member;

import java.net.http.HttpRequest;
import java.util.List;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gym.s1.board.BoardDTO;
import com.gym.s1.board.qna.QnaDTO;
import com.gym.s1.util.Pager;

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
	public ModelAndView join(MemberDTO memberDTO,MultipartFile file)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result =  memberService.join(memberDTO,file);
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
	
	@GetMapping("list")
	public ModelAndView list(ModelAndView mv,HttpSession session,Pager pager) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		
		if(memberDTO==null||memberDTO.getGrade()==0||memberDTO.getGrade()==1) {	
			mv.setViewName("redirect:../");	
		}else if(memberDTO.getGrade()==2) {
			List<MemberDTO> ar=memberService.list(pager);
			mv.addObject("list",ar);
			mv.setViewName("member/list");
		}
		return mv;
	}
	
	@GetMapping("detail")
	public ModelAndView detail(MemberDTO memberDTO,TrainerDTO trainerDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		memberDTO = memberService.detail(memberDTO);
		mv.addObject("member",memberDTO);
		mv.setViewName("member/detail");
		trainerDTO= memberService.trainerDetail(trainerDTO);
		mv.addObject("trainer",trainerDTO);
		return mv;
	}
	
	@GetMapping("upgrade")
	public ModelAndView upgrade(MemberDTO memberDTO,TrainerDTO trainerDTO, ModelAndView mv) throws Exception{
		memberDTO= memberService.detail(memberDTO);
		mv.addObject("dto",memberDTO);
		mv.setViewName("member/upgrade");
		trainerDTO= memberService.trainerDetail(trainerDTO);
		mv.addObject("trainer",trainerDTO);
		
		return mv;
	}
	@PostMapping("upgrade")
	public String upgrade(MemberDTO memberDTO, TrainerDTO trainerDTO) throws Exception{
		int result =memberService.upgrade(memberDTO);
		int result2=memberService.trainerAdd(trainerDTO);
		return "redirect:./list";
	}

	@PostMapping("trainerUpdate")
	public String trainerUpdate(TrainerDTO trainerDTO) throws Exception{
		int result =memberService.trainerUpdate(trainerDTO);
		
		return "redirect:./list";
	}
	@GetMapping("buy")
	public ModelAndView select(TrainerDTO trainerDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<TrainerDTO> ar = memberService.select(trainerDTO);
		mv.addObject("list",ar);
		mv.setViewName("member/buy");		
		
		return mv;
	}
	
	@PostMapping("buy")
	public String buyAdd(MembershipDTO membershipDTO)throws Exception{
		
//		String []a = traNum_price.split("-");
//		
//		Long traNumber=Long.parseLong(a[0]);
//		membershipDTO.setTraNum(traNumber);
	
		int result = memberService.buyAdd(membershipDTO);
		
		return "redirect:./mypage";
	}

	
}
