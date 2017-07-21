package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import com.test.common.DBConn;
import com.test.dto.UserInfo;

public class UserUpdate {
	public boolean updateUser(UserInfo ui){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn.getCon();
			String sql = "update user_info set userid=?,username=?,age=?,address=? where usernum=?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, ui.getUserId());
			ps.setString(2, ui.getUserName());
			ps.setInt(3, ui.getAge());
			ps.setString(4, ui.getAddress());
			ps.setInt(5, ui.getUserNum());
			int result = ps.executeUpdate();
			if(result==1){
				con.commit();
				return true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DBConn.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
