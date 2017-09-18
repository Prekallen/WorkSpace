package com.iot1.sql.user.controller;

import java.util.List;

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
	
	@RequestMapping(value= "/user/main", method=RequestMethod.GET)
	public @ResponseBody String init( ModelMap model, HttpSession hs) {
		UserInfo user = (UserInfo)hs.getAttribute("user");
		if(user!=null){
			model.addAttribute("userName", user.getUserName());
			return "/user/main";
		}else{
		return "redirect : user/login";
		}
		
	}
	
	
	@RequestMapping(value="/user/login", method=RequestMethod.POST)
	public @ResponseBody ModelMap login(HttpSession hs, @RequestBody UserInfo user, ModelMap model){
		UserInfo rUser = us.login(user);
		if(rUser!=null){
			hs.setAttribute("user", rUser);
			model.put("msg", "Log In Success.");
			model.put("url", "user/main");
		}else{
			model.put("msg", "계정 정보를 확인해주세요.");
			model.put("url", "user/login");
		}
		return model;
	}
	
	@RequestMapping(value="/user/list", method=RequestMethod.POST)
	public @ResponseBody List<UserInfo> getUserList(HttpSession hs, UserInfo user, ModelMap hm){
		return us.selectUserList(user);
	}
	
	@RequestMapping(value="/user/user_list", method=RequestMethod.GET)
	public String list(HttpSession hs, UserInfo user, ModelMap hm){
		return "/user/user_list";
	}
	
	@RequestMapping(value="/user/update", method=RequestMethod.POST)
	public @ResponseBody int svaeUserList(HttpSession hs, @RequestBody UserInfo user, ModelMap hm){
		return us.updatetUser(user);
	}
	@RequestMapping(value="/user/delete", method=RequestMethod.POST)
	public @ResponseBody int deleteUserList(HttpSession hs, @RequestBody UserInfo user, ModelMap hm){
		return us.deleteUser(user);
	}
	@RequestMapping(value="/user/create", method=RequestMethod.POST)
	public @ResponseBody List<UserInfo> saveUserList(HttpSession hs, @RequestBody UserInfo[] userList, ModelMap hm){
		int rCnt = us.insertUserList(userList);
		return us.selectUserList(null);
	}
	@RequestMapping(value="/user/logout", method=RequestMethod.POST)
	public ModelMap logout(ModelMap model, HttpSession hs){
		hs.invalidate();
		return model;
	}
}
