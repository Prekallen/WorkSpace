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

public class UserLogin {
	public String loginUser(HashMap<String,String>hm) {
		Connection con =null;
		PreparedStatement ps =null;
		try {
			con=DBConn.getCon();
			String sql = "select userid, userpwd from user_info where userid=?;";
			ps=con.prepareStatement(sql);
			ps.setString(1, hm.get("userid"));
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String userpwd = rs.getString("userpwd");
				
					return checkPwd(userpwd,hm.get("userpwd"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}try{
				ps.close();
				DBConn.closeCon();
		}catch(Exception e){
			e.printStackTrace();
		}
		return "아이디 확인 필요";
	}
	public String checkPwd(String pwd1, String pwd2){
		if(pwd1.equals(pwd2)){
			return "로그인";
		}
		return "비밀번호 확인하세요.";
	}
}
