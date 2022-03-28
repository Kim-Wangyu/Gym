package com.gym.s1.board.qna.qnaReply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/qnaReply/**")
public class QnaReplyController {
	
	@Autowired
	private QnaReplyService qnaReplyService;
	
	@PostMapping("add")
	public ModelAndView add(QnaReplyDTO qnaReplyDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaReplyService.add(qnaReplyDTO);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
	@GetMapping("list")
	public ModelAndView list(QnaReplyDTO qnaReplyDTO)throws Exception{
		ModelAndView mv= new ModelAndView();
		List<QnaReplyDTO> ar = qnaReplyService.list(qnaReplyDTO);
		mv.addObject("qnaReply",ar);
		mv.setViewName("common/qnaReply");
		return mv;
	}
	@PostMapping("delete")
	public ModelAndView delete(QnaReplyDTO qnaReplyDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaReplyService.delete(qnaReplyDTO);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	 @PostMapping("update") 
	 public ModelAndView update(QnaReplyDTO qnaReplyDTO)throws Exception{
		 ModelAndView mv=new ModelAndView();
		 int result = qnaReplyService.update(qnaReplyDTO);
		 mv.addObject("result",result);
		 mv.setViewName("common/ajaxResult");
		 
		 return mv;
	}
	 
}
