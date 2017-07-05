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
			String sql = "select num,id,name,age,class_num from user_info ";
			if(hm.get("name")!=null){		
				sql += "where name like ?;";
			}
			con=DBConn.getCon();
			ps=con.prepareStatement(sql);
			if(hm.get("name")!=null){
				ps.setString(1, "name");
			}
			ResultSet rs = ps.executeQuery();
			List lm = new ArrayList();
			while(rs.next()){
				Map hm1 = new HashMap();
				hm1.put("name", rs.getString("name"));
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
