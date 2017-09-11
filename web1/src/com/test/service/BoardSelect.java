package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.common.DBConn;
import com.test.dto.BoardInfo;

public class BoardSelect {

	public List<BoardInfo>boardSelect(BoardInfo bI) {
		Connection con =null;
		PreparedStatement ps =null;
		try {
			String sql = "select binum,bititle,bicontent,creusr,credat from board_info;";
			con=DBConn.getCon();
			ps=con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List lm = new ArrayList();
			while(rs.next()){
				BoardInfo bI2 = new BoardInfo();
				bI2.setBINum(Integer.parseInt(rs.getString("binum")));
				bI2.setBITitle(rs.getString("bititle"));
				bI2.setBIContent(rs.getString("bicontent"));
				bI2.setCreUsr(rs.getString("creusr"));
				bI2.setCreDat(rs.getString("credat"));
				lm.add(bI2);
			}
			return lm;

		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				DBConn.closeCon();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return null;
	}
}
