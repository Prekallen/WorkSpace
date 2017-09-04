package com.iot1.sql.user.service;

import java.util.List;
import java.util.Map;

import com.iot1.sql.user.dao.dto.UserInfo;

public interface UserService {
	public UserInfo logIn(UserInfo pUser);
	public List<UserInfo> selectUserList(Map hm);
	public UserInfo insertUser(UserInfo user);
	public UserInfo updateUser(UserInfo user);
	public UserInfo deleteUser(UserInfo user);
}
