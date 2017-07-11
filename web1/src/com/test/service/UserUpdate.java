package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import com.test.common.DBConn;

public class UserUpdate {
	public boolean updateUser(HashMap<String,String> hm){
		Connection con = null;
		PreparedStatement ps =null;		
		try{
			con = DBConn.getCon();
			String sql = "update user_info set id=?,name=?, class_num=?, age=? where num =?;";
			ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("id"));
			ps.setString(2, hm.get("name"));
			ps.setString(3, hm.get("class_num"));
			ps.setString(4, hm.get("age"));
			ps.setString(5, hm.get("num"));
			int result = ps.executeUpdate();
			if(result ==1){
				con.commit();
				return true;
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
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
