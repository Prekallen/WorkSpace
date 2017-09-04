package com.iot1.sql.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
			map.put("url", "/user/login");
			map.put("msg", "계정 정보를 확인해 주세요.");
		}else{
			hs.setAttribute("user", user);
			map.put("url", "/main");
			map.put("msg", "Success");
		}
		return map;
	}
	
}
