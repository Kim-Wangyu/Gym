package com.gym.s1.board.exercise;

import java.net.http.HttpRequest;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gym.s1.board.BoardDTO;

@Controller
@RequestMapping(value="/exercise/*")
public class ExerciseController {
	
	@Autowired
	private ExerciseService exerciseService;
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public ModelAndView list(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = exerciseService.list();
		mv.addObject("list",ar);
		mv.setViewName("/exercise/list");
		return mv;
	}
	
	@RequestMapping(value="add",method = RequestMethod.GET)
	public String add()throws Exception{
		return "/exercise/add";
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String add(BoardDTO boardDTO)throws Exception{
		int result = exerciseService.add(boardDTO);
		return "redirect:./list";
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public ModelAndView detail(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();

		boardDTO = exerciseService.detail(boardDTO);
		mv.addObject("dto",boardDTO);
		mv.setViewName("/exercise/detail");
		return mv;
	}
	
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public String delete(BoardDTO boardDTO)throws Exception{
		int result = exerciseService.delete(boardDTO);
		return "redirect:./list";
	}
	
	@RequestMapping(value="update",method = RequestMethod.GET)
	public String update(Model model, BoardDTO boardDTO)throws Exception{
		boardDTO = exerciseService.detail(boardDTO);
		model.addAttribute("dto",boardDTO);
		return "/exercise/update";
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public ModelAndView update(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = exerciseService.update(boardDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
}
