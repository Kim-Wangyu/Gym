package com.gym.s1.etc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/etc/**")
public class EtcController {
	
	@GetMapping("sangHwa")
	public ModelAndView sangHwa()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("./etc/sangHwa");
		return mv;
	}
	
	@GetMapping("siYeong")
	public ModelAndView siYeong()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("./etc/siYeong");
		return mv;
	}
	
	@GetMapping("rain")
	public ModelAndView rain()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("./etc/rain");
		return mv;
	}
	
	@GetMapping("jongKuk")
	public ModelAndView jongKuk()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("./etc/jongKuk");
		return mv;
	}
	
	@GetMapping("trainers")
	public ModelAndView trainers()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("./etc/trainers");
		return mv;
	}
	
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
	@GetMapping("faq")
	public ModelAndView faq() throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("./etc/faq");
		return mv;
	}

}
