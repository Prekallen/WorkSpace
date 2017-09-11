package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.common.DBConn;
import com.test.dto.UserInfo;

public class UserSelect {

	public List<UserInfo> selectUser(UserInfo ui) {
		Connection con =null;
		PreparedStatement ps =null;
		try {
			String sql = "select usernum,userid,username,age,address from user_info ";
			if(ui.getUserName()!=null){		
				sql += "where username like ?;";
			}
			con=DBConn.getCon();
			ps=con.prepareStatement(sql);
			if(ui.getUserName()!=null){
				ps.setString(1, ui.getUserName());
			}
			ResultSet rs = ps.executeQuery();
			List lm = new ArrayList();
			while(rs.next()){
				UserInfo uil = new UserInfo();
				uil.setUserNum(rs.getInt("usernum"));
				uil.setUserId(rs.getString("userid"));
				uil.setUserName(rs.getString("username"));
				uil.setAge(rs.getInt("age"));
				uil.setAddress(rs.getString("address"));
				lm.add(uil);
			}
			return lm;

		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				DBConn.closeCon();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return null;
	}
}
