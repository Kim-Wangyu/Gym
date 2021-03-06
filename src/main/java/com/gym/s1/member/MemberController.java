package com.gym.s1.member;

import java.net.http.HttpRequest;
import java.sql.Date;
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

import com.gym.s1.apply.ApplyService;
import com.gym.s1.board.BoardDTO;
import com.gym.s1.board.qna.QnaDTO;
import com.gym.s1.util.Pager;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private ApplyService applyService;

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
		TrainerDTO trainerDTO = new TrainerDTO();
		if(memberDTO!=null) {
			message="로그인 성공";
			if(remember!=null&&remember.equals("1")) {
				Cookie cookie = new Cookie("rememberid", memberDTO.getId());
				response.addCookie(cookie);
				cookie.setMaxAge(-1);
			}
			
			if(memberDTO.getGrade().equals(1L)) {
				trainerDTO.setMemberNum(memberDTO.getMemberNum());
				trainerDTO = memberService.trainerDetail(trainerDTO);
			
				
			}
		}
		else {
			message="로그인 실패";
			path= "./login";
		}
		session.setAttribute("trainer", trainerDTO);
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
	public ModelAndView mypage(MembershipDTO membershipDTO,HttpSession session)throws Exception{
		MemberDTO memberDTO=(MemberDTO)session.getAttribute("member");
		membershipDTO.setMemberNum(memberDTO.getMemberNum());
		membershipDTO = memberService.mypage(membershipDTO);
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("membership",membershipDTO);
		mv.setViewName("./member/mypage");
		return mv;
	}	
	
	@GetMapping("update")
	public String update(MemberDTO memberDTO, ModelAndView mv) throws Exception{
		return "./member/update";
	}
	@PostMapping("update")
	public String update(MemberDTO memberDTO,HttpSession session) throws Exception{
		int result =memberService.update(memberDTO);
		if(result ==1) {
			 
		MemberDTO memberDTO2= (MemberDTO) session.getAttribute("member");
		memberDTO2.setName(memberDTO.getName());
		memberDTO2.setPhone(memberDTO.getPhone());
		session.setAttribute("member", memberDTO2);
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
		MembershipDTO membershipDTO = new MembershipDTO();
		memberDTO = memberService.detail(memberDTO);
		membershipDTO.setMemberNum(memberDTO.getMemberNum());
		membershipDTO = applyService.findMembershipNum(membershipDTO);
		mv.addObject("membership",membershipDTO);
		mv.addObject("members",memberDTO);
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
	public String upgrade(MemberDTO memberDTO, TrainerDTO trainerDTO,Long grade) throws Exception{
		if(grade.equals(0L)) {
			int result =memberService.upgrade(memberDTO);//멤버테이블 업그레이드
			int result2 = memberService.deleteTrainer(trainerDTO);//트레이너테이블 삭제
		}else if(grade.equals(1L)) {
			int result =memberService.upgrade(memberDTO);//멤버테이블 업그레이드
			int result2=memberService.trainerAdd(trainerDTO);//트레이너테이블에 추가
		}
	
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
	public ModelAndView buyAdd(MembershipDTO membershipDTO,String start, String finish,Long traNum,Long count)throws Exception{
		ModelAndView mv = new ModelAndView();
		if(traNum==null) {
			membershipDTO.setTraNum(0L);
		}
		if(count==null) {
			membershipDTO.setCount(0L);
		}
		start=start.replace("년","-");
		start=start.replace("월","-");
		start=start.replace("일","");
		finish=finish.replace("년","-");
		finish=finish.replace("월","-");
		finish=finish.replace("일","");
		Date startDate = Date.valueOf(start); 
		Date finishDate = Date.valueOf(finish);
		membershipDTO.setStartDate(startDate);
		membershipDTO.setFinishDate(finishDate);
		
		int result = memberService.buyAdd(membershipDTO);
		String message = "구매 완료";
		if(result !=1) {
			message = "구매 실패";
		}
		mv.addObject("path","./mypage");
		mv.addObject("message",message);
		mv.setViewName("/common/result");
		
		return mv;
	}

	
}
