package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.test.common.DBConn;
import com.test.servlet.UserServlet;

public class UserDelete {

	UserServlet us = new UserServlet();
	public boolean deleteUser(String user_num){
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con= DBConn.getCon();
			String sql = "delete from user_info where num = ?";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, Integer.parseInt(user_num));
			int result = ps.executeUpdate();
			if(result>0){
				con.commit();
				return true;
			}
		}catch(ClassNotFoundException | SQLException e){
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
