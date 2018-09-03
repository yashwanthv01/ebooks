package com.yashebooks.ebooksfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value = {"/","/index","/home"})
	public ModelAndView index(){
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting"," This is spring MVC ! welcome !!");
		return mv;
	}

	@RequestMapping(value={"/test"})
	public ModelAndView test(@RequestParam(value="greeting",required=false) String greeting){
		if(greeting == null)
			greeting= "hello welcome to our page !!";
		ModelAndView testingMv = new ModelAndView("page");
		testingMv.addObject("greeting", greeting); // this is the greeting given by 
		return testingMv;
		
	}
	
	@RequestMapping("/testingPath/{greeting}")
	public ModelAndView testingForPathVariable(@PathVariable("greeting") String greeting){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("pathGreeting", greeting);
		return mv;
	}
}
