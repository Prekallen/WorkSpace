package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.test.common.DBConn;
import com.test.dto.BoardInfo;

public class BoardUpdate {
	public boolean boardUpdate(BoardInfo bI){
		Connection con = null;
		PreparedStatement ps =null;		
		try{
			con = DBConn.getCon();
			String sql = "update board set bititle=?, bicontent=?, creusr=?, credat=now() where binum =?;";
			ps = con.prepareStatement(sql);
			ps.setString(1, bI.getBITitle());
			ps.setString(2, bI.getBIContent());
			ps.setString(3, bI.getCreUsr());
			ps.setInt(4, bI.getBINum());
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
