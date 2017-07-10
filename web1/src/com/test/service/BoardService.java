package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import com.test.common.DBConn;

public class BoardService {

	public boolean BoardInsert(HashMap<String,String> hm){
		Connection con = null;
		PreparedStatement ps =null;		
		try{
			con = DBConn.getCon();
			String sql = "insert into board(title,content,writer,reg_date)";
			sql +=" values(?,?,?,now());";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("title"));
			ps.setString(2, hm.get("content"));
			ps.setInt(3, Integer.parseInt(hm.get("writer")));
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
