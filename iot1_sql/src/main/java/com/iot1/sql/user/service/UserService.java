package com.iot1.sql.user.service;

import java.util.List;
import java.util.Map;

import com.iot1.sql.user.dao.dto.UserInfo;

public interface UserService {
	public UserInfo logIn(UserInfo pUser);
	public List<UserInfo> selectUserList(UserInfo pUser);
	public UserInfo insertUser(UserInfo pUser);
	public UserInfo updateUser(UserInfo pUser);
	public UserInfo deleteUser(UserInfo pUser);
}
