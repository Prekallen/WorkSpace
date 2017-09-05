package com.iot1.sql.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot1.sql.user.dao.UserDAO;
import com.iot1.sql.user.dao.dto.UserInfo;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired UserDAO userDAO;
	
	@Override
	public UserInfo logIn(UserInfo pUser) {
		UserInfo user = userDAO.selectUser(pUser);
		if(user!=null && user.getUserPwd().equals(pUser.getUserPwd())){
			return user;
		}
		return null;
	}

	@Override
	public List<UserInfo> selectUserList(UserInfo pUser) {
		return userDAO.selectUserList(pUser);
	}

	@Override
	public UserInfo insertUser(UserInfo user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo updateUser(UserInfo user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo deleteUser(UserInfo user) {
		// TODO Auto-generated method stub
		return null;
	}

}
