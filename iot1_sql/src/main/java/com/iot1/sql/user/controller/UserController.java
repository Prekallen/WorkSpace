package com.iot1.sql.user.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot1.sql.user.dao.dto.UserInfo;
import com.iot1.sql.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired 
	private UserService us;

	@RequestMapping(value="/user/login", method=RequestMethod.GET)
	public String logIn(){
		return "user/login";
	}
	@RequestMapping(value="/user/login", method=RequestMethod.POST)
	public @ResponseBody ModelMap login(@RequestBody UserInfo pUser, ModelMap map, HttpSession hs){
		UserInfo user = us.logIn(pUser);
		if(user==null){
			map.put("url", "user/login");
			map.put("msg", "계정 정보를 확인해 주세요.");
		}else{
			hs.setAttribute("user", user);
			map.put("url", "user/main");
			map.put("msg", "Success");
		}
		return map;
	}
	
	@RequestMapping(value = "user/main", method=RequestMethod.POST)
	public String init(HttpServletRequest request, ModelMap model, HttpSession hs) {
		UserInfo user = (UserInfo)hs.getAttribute("user");
		if(user!=null){
			model.addAttribute("userName", user.getUserName());
			return "user/main";
		}else{
			return "user/login";
		}
		
	}
	
	@RequestMapping(value="user/logout", method=RequestMethod.GET)
	public String logOut(HttpSession hs){
		hs.invalidate();
		return "redirect:"+"/user/login";
	}
	
	@RequestMapping(value="/user/user_list", method=RequestMethod.GET)
	public String list(HttpSession hs){
		hs.invalidate();
		return "/user/user_list";
	}
	
	@RequestMapping(value="/user/user_list", method=RequestMethod.POST)
	public @ResponseBody ModelMap getUserList(HttpServletRequest resquest,@RequestBody UserInfo pUser, ModelMap model, HttpSession hs){
		List<UserInfo> userList = us.selectUserList(pUser);
		model.put("userList", userList);
		return model;
	}
	
}
