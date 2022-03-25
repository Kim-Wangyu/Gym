package com.gym.s1.board.notice.reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/noticeReply/**")
public class NoticeReplyController {
	
	@Autowired
	private NoticeReplyService noticeReplyService;
	
	@PostMapping("add")
	public ModelAndView add(NoticeReplyDTO noticeReplyDTO)throws Exception{
		System.out.println("ADDDD");
		ModelAndView mv = new ModelAndView();
		int result = noticeReplyService.add(noticeReplyDTO);
		mv.addObject("result",result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	@GetMapping("list")
	public ModelAndView list(NoticeReplyDTO noticeReplyDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		List<NoticeReplyDTO> ar = noticeReplyService.list(noticeReplyDTO);
		
		mv.addObject("noticeReply", ar);
		mv.setViewName("common/noticeReply");
		return mv;
		
	}

}
