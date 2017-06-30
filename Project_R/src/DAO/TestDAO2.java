package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.DBConn2;

public class TestDAO2 {
	public List<Map> selectTest(){
		List<Map> test = new ArrayList<Map>();
		try{
		Connection con = DBConn2.getCon();
		String sql = "select t.*,ui.id,ui.name from user_info as ui, test as t where ui.num=t.writer;";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Map hm = new HashMap();
			hm.put("num",rs.getString("num"));
			hm.put("title",rs.getString("title"));
			hm.put("content",rs.getString("content"));
			hm.put("writer",rs.getString("writer"));
			hm.put("id",rs.getString("id"));
			hm.put("name",rs.getString("name"));
			test.add(hm);
		}
		DBConn2.closeCon();
		return test;	
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
	public static void main(String[]args){
		TestDAO2 tdao2 = new TestDAO2();
		List<Map> lm= tdao2.selectTest();
		for(Map m : lm){
			System.out.println(m);
		}
	}
}
