package com.iot.sp.user.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.sp.user.dto.UserInfo;
import com.iot.sp.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService us; 
	
	@RequestMapping("/main")
	public String init(HttpServletRequest request, ModelMap model, HttpSession hs) {
		String userId = (String)hs.getAttribute("userId");
		if(userId!=null){
			model.addAttribute("userId", userId);
			return "/user/main";
		}else{
		return "/user/login";
		}
		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public  ModelMap logIn(HttpServletRequest request, @RequestBody UserInfo pUser, ModelMap model, HttpSession hs){
		UserInfo user = us.getUser(pUser);
		if(user==null){
			model.put("data", "F");
			model.put("url", "/user/login");
			model.put("msg", "Fail");
		}else{
			hs.setAttribute("userId", user.getUserId());
			model.put("data", "S");
			model.put("url", "/user/main");
			model.put("msg", "Success");
		}
		return model;
	}
	@RequestMapping("/logout")
	public String logOut(HttpServletRequest request, ModelMap model, HttpSession hs){
		hs.invalidate();
		return "/user/login";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public @ResponseBody ModelMap getUserList(HttpServletRequest resquest,@RequestBody Map hm, ModelMap model, HttpSession hs){
		List<UserInfo> userList = us.getUserList(hm);
		model.put("userList", userList);
		return model;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String moveList(HttpServletRequest resquest){
		return "/user/list";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String moveInsert(HttpServletRequest resquest){
		return "/user/insert";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public @ResponseBody ModelMap userInsert(HttpServletRequest resquest,@RequestBody UserInfo user, ModelMap model, HttpSession hs){
		UserInfo userInsert = us.userInsert(user);
		model.put("userInsert", userInsert);
		return model;
	}
	
}
