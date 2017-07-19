package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import com.test.common.DBConn;

public class UserService {

	public boolean insertUser(HashMap<String,String> hm){
		Connection con = null;
		PreparedStatement ps =null;		
		try{
			con = DBConn.getCon();
			String sql = "insert into user_info(userid,userpwd,username,address,age,hp1,hp2,hp3)";
			sql +=" values(?,?,?,?,?,?,?,?);";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("userid"));
			ps.setString(2, hm.get("userpwd"));
			ps.setString(3, hm.get("username"));
			ps.setString(4, hm.get("address"));
			ps.setString(5, hm.get("age"));
			ps.setString(6, hm.get("hp1"));
			ps.setString(7, hm.get("hp2"));
			ps.setString(8, hm.get("hp3"));
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
