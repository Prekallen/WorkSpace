package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import com.test.common.DBConn;
import com.test.dto.BoardInfo;

public class BoardService {

	public boolean BoardInsert(BoardInfo bI){
		Connection con = null;
		PreparedStatement ps =null;		
		try{
			con = DBConn.getCon();
			String sql = "insert into board(bititle,bicontent,bipwd,creusr,credat)";
			sql +=" values(?,?,?,?,now());";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, bI.getBITitle());
			ps.setString(2, bI.getBIContent());
			ps.setString(2, bI.getBIPwd());
			ps.setString(4, bI.getCreUsr());
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
