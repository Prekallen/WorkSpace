package com.iot1.sql.user.dao;

import java.util.List;
import java.util.Map;

import com.iot1.sql.user.dao.dto.UserInfo;

public interface UserDAO {
	UserInfo selectUser(UserInfo user);
	List<UserInfo> selectUserList (UserInfo user);
	UserInfo insertUser(UserInfo user);
	UserInfo updateUser(UserInfo user);
	UserInfo deleteUser(UserInfo user);
}
