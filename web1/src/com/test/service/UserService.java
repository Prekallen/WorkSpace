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
			String sql = "insert into user_info(id,pwd,name,class_num,age)";
			sql +=" values(?,?,?,?,?);";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("id"));
			ps.setString(2, hm.get("pwd"));
			ps.setString(3, hm.get("name"));
			ps.setString(4, hm.get("class_num"));
			ps.setString(5, hm.get("age"));
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
