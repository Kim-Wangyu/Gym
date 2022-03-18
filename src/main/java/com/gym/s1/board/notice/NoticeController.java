package com.gym.s1.board.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gym.s1.board.BoardDTO;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String board() {
		return "notice";
	}

	
	@RequestMapping(value = "add",method = RequestMethod.GET)
	public ModelAndView add() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("board/add");
		return mv;
	}
	
	
	@RequestMapping(value = "add",method = RequestMethod.POST)
	public ModelAndView add(BoardDTO boardDTO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		int result = noticeService.add(boardDTO); 
		mv.setViewName("redirect:./add");
		return mv;
	}
	

	
	
}

