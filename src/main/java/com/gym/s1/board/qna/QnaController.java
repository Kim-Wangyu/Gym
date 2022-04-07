package com.gym.s1.board.qna;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gym.s1.board.BoardDTO;
import com.gym.s1.board.BoardFileDTO;
import com.gym.s1.util.Pager;

@Controller
@RequestMapping(value = "/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String board() {
		return "qna";
	}
	
	@PostMapping("fileDelete")
	public ModelAndView fileDelete(BoardFileDTO boardFileDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.fileDelete(boardFileDTO);
		mv.addObject("result",result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String add()throws Exception{
		return "/qna/add";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public ModelAndView add(BoardDTO boardDTO,MultipartFile[] files) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.add(boardDTO,files);
		
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public ModelAndView list(ModelAndView mv, Pager pager) throws Exception {
		List<BoardDTO> ar = qnaService.list(pager);
		mv.addObject("list", ar);
		mv.setViewName("qna/list");
		return mv;
	}

	@RequestMapping(value="detail", method=RequestMethod.GET)
	public ModelAndView detail(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = qnaService.detail(boardDTO);
		mv.addObject("dto",boardDTO);
		mv.setViewName("qna/detail");
		return mv;
	}
	
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public String delete(BoardDTO boardDTO)throws Exception{
		int result= qnaService.delete(boardDTO);
		
		return "redirect:./list";
	}
	
	@RequestMapping(value="update",method=RequestMethod.GET)
	public ModelAndView update(QnaDTO qnaDTO, ModelAndView mv) throws Exception{

		BoardDTO boardDTO=  qnaService.detail(qnaDTO);
		mv.addObject("dto",boardDTO);
		mv.setViewName("qna/update");
		return mv;
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(QnaDTO qnaDTO,MultipartFile[] files) throws Exception{
		int result = qnaService.update(qnaDTO,files);
		return "redirect:./list";
	}
	
	
}
