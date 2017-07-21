package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.test.common.DBConn;
import com.test.servlet.UserServlet;

public class BoardDelete {

	
	public boolean boardDelete(String bINum){
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con= DBConn.getCon();
			String sql = "delete from board_info where binum = ?";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, Integer.parseInt(bINum));
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
