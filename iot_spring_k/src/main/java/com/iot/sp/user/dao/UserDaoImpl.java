package com.iot.sp.user.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.iot.sp.user.dto.UserInfo;

@Service
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{
	
	@Override
	public UserInfo selectUser(UserInfo user) {
		return this.getSqlSession().selectOne("userinfo.SELECT_USER2",user);
	}
	@Override
	public List<UserInfo> selectUserList(Map hm){
		if(hm.get("userName")!=null){
			hm.put("userName", "%" + hm.get("userName") + "%");
		}
		return this.getSqlSession().selectList("userinfo.SELECT_USERLIST", hm);
	}
	@Override
	public UserInfo insertUser(UserInfo user) {
		
		return this.getSqlSession().selectOne("userinfo.INSERT_USER", user);
	}
}
