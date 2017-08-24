package com.iot.sp.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model){
		
		return "test/list";
	}
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model){
		
		return "test/write";
	}
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model){
		
		return "test/modify";
	}
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model){
		
		return "test/delete";
	}
	@RequestMapping("/2")
	public String trans(HttpServletRequest request, @RequestParam(value="test") String test, Model model){
		test = request.getParameter("test");
		String trans = request.getParameter("trans");
		System.out.println(test + " / " + trans);
		model.addAttribute("test",test);
		model.addAttribute("trans",trans);
		return "test";
	}
}
