package com.gym.s1.board.exercise;

import java.net.http.HttpRequest;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gym.s1.board.BoardDTO;
import com.gym.s1.util.Pager;

@Controller
@RequestMapping(value="/exercise/*")
public class ExerciseController {
	
	@Autowired
	private ExerciseService exerciseService;
	
	@ModelAttribute("board")
	public String board() {
		return "exercise";
	}
	
	@PostMapping("fileDelete")
	public ModelAndView fileDelete(ExerciseFileDTO exerciseFileDTO)throws Exception{
		ModelAndView mv=new ModelAndView();
		int result =exerciseService.fileDelete(exerciseFileDTO);
		mv.addObject("result",result);
		mv.setViewName("/common/ajaxResult");
		return mv;
	}
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public ModelAndView list(BoardDTO boardDTO,Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = exerciseService.list(pager);
		mv.addObject("pager",pager);
		mv.addObject("list",ar);
		mv.setViewName("/exercise/list");
		return mv;
	}
	
	@RequestMapping(value="add",method = RequestMethod.GET)
	public String add()throws Exception{
		return "/exercise/add";
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String add(BoardDTO boardDTO,MultipartFile [] files)throws Exception{
		int result = exerciseService.add(boardDTO,files);
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
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
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
	public ModelAndView update(BoardDTO boardDTO,MultipartFile [] files)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = exerciseService.update(boardDTO,files);
	
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	
}
