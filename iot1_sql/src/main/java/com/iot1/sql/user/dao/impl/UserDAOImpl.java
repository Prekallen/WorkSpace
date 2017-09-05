package com.iot1.sql.user.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.iot1.sql.user.dao.UserDAO;
import com.iot1.sql.user.dao.dto.UserInfo;
@Service
public class UserDAOImpl extends SqlSessionDaoSupport implements UserDAO{

	@Override
	public UserInfo selectUser(UserInfo user) {
		return this.getSqlSession().selectOne("userinfo.SELECT_USER",user);
	}

	@Override
	public List<UserInfo> selectUserList(UserInfo user) {
		return this.getSqlSession().selectList("userinfo.SELECT_USERLIST",user);
	}

	@Override
	public int insertUser(UserInfo user) {
		return this.getSqlSession().insert("userinfo.INSERT_USER", user);
	}

	@Override
	public int updateUser(UserInfo user) {
		return this.getSqlSession().update("userinfo.UPDATE_USER", user);
	}

	@Override
	public int deleteUser(UserInfo user) {
		return this.getSqlSession().delete("userinfo.DELETE_USER", user);
	}

}
