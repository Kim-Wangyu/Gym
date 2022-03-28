package com.gym.s1.board.exercise.exerciseReply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/exerciseReply/*")
public class ExerciseReplyController {
	@Autowired
	private ExerciseReplyService exerciseReplyService;
	
	
	@PostMapping("update")
	public ModelAndView update(ExerciseReplyDTO exerciseReplyDTO)throws Exception{
		ModelAndView mv =new ModelAndView();
		int result=exerciseReplyService.update(exerciseReplyDTO);
		mv.addObject("result",result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	@PostMapping("delete")
	public ModelAndView delete(ExerciseReplyDTO exerciseReplyDTO)throws Exception{
		ModelAndView mv =new ModelAndView();
		int result = exerciseReplyService.delete(exerciseReplyDTO);
		mv.addObject("result",result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	@GetMapping("list")
	public ModelAndView list(ExerciseReplyDTO exerciseReplyDTO)throws Exception{
		ModelAndView mv =new ModelAndView();
		List<ExerciseReplyDTO> al = exerciseReplyService.list(exerciseReplyDTO);
		mv.addObject("list",al);
		mv.setViewName("common/exerciseReply");
		return mv;
	}
	
	@PostMapping("add")
	public ModelAndView add(ExerciseReplyDTO exerciseReplyDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = exerciseReplyService.add(exerciseReplyDTO);
		mv.addObject("result",result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
}
