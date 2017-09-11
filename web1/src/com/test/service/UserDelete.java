package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.test.common.DBConn;
import com.test.servlet.UserServlet;

public class UserDelete {


	public boolean deleteUser(String usernum){
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con= DBConn.getCon();
			String sql = "delete from user_info where usernum = ?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, usernum);
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
