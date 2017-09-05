package com.iot1.sql.user.controller;

import java.util.List;

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
	public String login(){
		return "/user/login";
	}
	
	@RequestMapping(value="/user/login", method=RequestMethod.POST)
	public @ResponseBody ModelMap login(HttpSession hs, @RequestBody UserInfo user, ModelMap hm){
		UserInfo rUser = us.login(user);
		if(rUser!=null){
			hs.setAttribute("user", rUser);
			hm.put("msg", "Log In Success.");
			hm.put("url", "user/main");
		}else{
			hm.put("msg", "계정 정보를 확인해주세요.");
			hm.put("url", "user/login");
		}
		return hm;
	}
	
	@RequestMapping(value="/user/list", method=RequestMethod.POST)
	public @ResponseBody List<UserInfo> getUserList(HttpSession hs, UserInfo user, ModelMap hm){
		return us.selectUserList(user);
	}
	
	@RequestMapping(value="/user/user_list", method=RequestMethod.GET)
	public String list(HttpSession hs, UserInfo user, ModelMap hm){
		return "/user/user_list";
	}
}
