package com.iot.sp.test;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.sp.user.service.UserService;
import com.iot.sp.user.service.UserServiceImpl;

@Controller
@RequestMapping("/test")
public class TestController {
	private static UserService us = new UserServiceImpl();
	@RequestMapping("/t")
	public String list(HttpServletRequest request, ModelMap model, @RequestParam(value="exam") String exam){
		model.put("test","Good");
		model.put("exam", exam);
		return "test";
	}
	
	@RequestMapping(value="/test1", method=RequestMethod.POST)
	public @ResponseBody ModelMap postTest(ModelMap map, @RequestBody Map hm){
		map.put("test", "test");
		return map;
	}
	@RequestMapping(value="/test1", method=RequestMethod.GET)
	public @ResponseBody ModelMap GetTest(ModelMap map,@RequestParam(value="exam") String exam){
		map.put("test", exam);
		return map;
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
