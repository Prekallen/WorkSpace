package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import com.test.common.DBConn;
import com.test.dto.UserInfo;

public class UserService {

	public boolean insertUser(UserInfo ui){
		Connection con = null;
		PreparedStatement ps =null;		
		try{
			con = DBConn.getCon();
			String sql = "insert into user_info(userid,userpwd,username,address,age,hp1,hp2,hp3)";
			sql +=" values(?,?,?,?,?,?,?,?);";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, ui.getUserId());
			ps.setString(2, ui.getUserPwd());
			ps.setString(3, ui.getUserName());
			ps.setString(4, ui.getAddress());
			ps.setInt(5, ui.getAge());
			ps.setString(6, ui.getHp1());
			ps.setString(7, ui.getHp2());
			ps.setString(8, ui.getHp3());
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
