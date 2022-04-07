package com.gym.s1.etc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/etc/**")
public class EtcController {
	
	@GetMapping("intro")
	public ModelAndView intro()throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("./etc/intro");
		return mv;
	}
	
	@GetMapping("greeting")
	public ModelAndView greeting()throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("./etc/greeting");
		return mv;
	}
	
	@GetMapping("map")
	public ModelAndView map()throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("./etc/map");
		return mv;
	}

}
