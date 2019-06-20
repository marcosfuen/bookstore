package cu.cmg.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@RequestMapping(value = { "/", "/index" })
	public String index(){
		return "/admin/index";
		
	}
	/*
	@RequestMapping(value = "/index")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "Hello Reader!");
		mv.setViewName("/admin/index");
		
		return mv;

		//return "/admin/index";
		
	}
	*/

}
