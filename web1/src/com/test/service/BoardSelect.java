package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.common.DBConn;

public class BoardSelect {

	public List<Map>boardSelect(HashMap<String,String>hm) {
		Connection con =null;
		PreparedStatement ps =null;
		try {
			String sql = "select num,title,content,writer,reg_date from board ;";
			con=DBConn.getCon();
			ps=con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List lm = new ArrayList();
			while(rs.next()){
				Map hm1 = new HashMap();
				hm1.put("num", rs.getString("num"));
				hm1.put("tilte", rs.getString("title"));
				hm1.put("content", rs.getString("content"));
				hm1.put("writer", rs.getString("writer"));
				hm1.put("reg_date", rs.getString("reg_date"));
				lm.add(hm1);
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
