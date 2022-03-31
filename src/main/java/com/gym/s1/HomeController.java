package com.gym.s1;


import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gym.s1.board.BoardDTO;
import com.gym.s1.board.exercise.ExerciseService;
import com.gym.s1.board.notice.NoticeService;
import com.gym.s1.board.qna.QnaService;
import com.gym.s1.util.Pager;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private ExerciseService exerciseService;
	
	@Autowired
	private QnaService qnaService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public ModelAndView homeNotice(Pager pager)throws Exception{

		List<BoardDTO> ar = noticeService.list2(pager);
		List<BoardDTO> ar1 = exerciseService.list2(pager);
		List<BoardDTO> ar2 = qnaService.list2(pager);
		ModelAndView mv = new ModelAndView();

		
		mv.addObject("list",ar);
		mv.addObject("list1",ar1);
		mv.addObject("list2",ar2);
		mv.setViewName("home");

		return mv;
	}
	
	

	
}
