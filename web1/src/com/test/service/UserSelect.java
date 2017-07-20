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

public class UserSelect {

	public List<Map>selectUser(HashMap<String,String>hm) {
		Connection con =null;
		PreparedStatement ps =null;
		try {
			String sql = "select usernum,userid,username,age,address from user_info ";
			if(hm.get("username")!=null){		
				sql += "where username like ?;";
			}
			con=DBConn.getCon();
			ps=con.prepareStatement(sql);
			if(hm.get("username")!=null){
				ps.setString(1, hm.get("username"));
			}
			ResultSet rs = ps.executeQuery();
			List lm = new ArrayList();
			while(rs.next()){
				Map hm1 = new HashMap();
				hm1.put("usernum", rs.getString("usernum"));
				hm1.put("userid", rs.getString("userid"));
				hm1.put("username", rs.getString("username"));
				hm1.put("age", rs.getString("age"));
				hm1.put("address", rs.getString("address"));
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
