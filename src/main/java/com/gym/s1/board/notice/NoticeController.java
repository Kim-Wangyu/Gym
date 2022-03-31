package com.gym.s1.board.notice;

import java.io.Reader;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gym.s1.board.BoardDTO;
import com.gym.s1.util.Pager;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String board() {
		return "notice";
	}
	

	
	@RequestMapping(value = "update",method = RequestMethod.GET)
	public ModelAndView update(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO= noticeService.detail(boardDTO);
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/update");
		return mv;
	}
	
	@RequestMapping(value = "update",method = RequestMethod.POST)
	public ModelAndView update(BoardDTO boardDTO,ModelAndView mv)throws Exception{
		int result=noticeService.update(boardDTO);
		mv.setViewName("redirect:./list");
		
		return mv;
	}
	
	@RequestMapping(value = "delete",method = RequestMethod.POST)
	public ModelAndView delete(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.delete(boardDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	@RequestMapping(value = "detail",method = RequestMethod.GET)
	public ModelAndView detail(BoardDTO boardDTO/*HttpServletRequest request*/)throws Exception{
//		String a = Request.getParameter("num");
//		Long num = Long.parseLong(a);
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setNum(num);
		ModelAndView mv = new ModelAndView();
		BoardDTO boardDTO2 =new BoardDTO();
		boardDTO2 = noticeService.detail(boardDTO);
		mv.addObject("dto",boardDTO2);
		mv.setViewName("board/detail");
		return mv;
		
		
	}
	
	
	
	
	@RequestMapping(value = "list",method = RequestMethod.GET)
	public ModelAndView list(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = noticeService.list(pager);		
		mv.addObject("list",ar);
		mv.setViewName("board/list");
		return mv;
		
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
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	

	
	
}

