package com.iot1.sql.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot1.sql.user.dao.UserDAO;
import com.iot1.sql.user.dao.dto.UserInfo;
import com.iot1.sql.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO ud;
	
	@Override
	public UserInfo login(UserInfo user) {
		UserInfo rUser = ud.selectUser(user);
		if(rUser!=null && rUser.getUserPwd().equals(user.getUserPwd())){
			return rUser;
		}
		return null;
	}

	@Override
	public UserInfo selectUser(UserInfo user) {
		return ud.selectUser(user);
	}

	@Override
	public List<UserInfo> selectUserList(UserInfo user) {
		return ud.selectUserList(user);
	}

	@Override
	public int insertUser(UserInfo user) {
		return ud.insertUser(user);
	}

	@Override
	public int updatetUser(UserInfo user) {
		return ud.updateUser(user);
	}

	@Override
	public int deleteUser(UserInfo user) {
		return ud.deletetUser(user);
	}

	@Override
	public int insertUserList(UserInfo[] userList)  {
		int rCnt = 0;
		for(UserInfo user : userList){
			rCnt += ud.insertUser(user);
		}
		return rCnt;
	}

}
