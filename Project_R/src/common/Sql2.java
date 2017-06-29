package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Sql2 {

	public List<String> getUserIDLists() {
		//String reult"";
		List<String> userlist = new ArrayList<String>();
		try{
			Connection con = DBConn2.getCon();
			String sql = "select ui.num, ui.name, ui.id, ui.pwd, ui.age, ci.class_name, ci.class_num from user_info as ui, class_info as ci";
			sql += " where ci.class_num=ui.class_num";

			PreparedStatement prestmt = con.prepareStatement(sql);
			ResultSet rs = prestmt.executeQuery();
			while (rs.next()){
				userlist.add(rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getString(4) + "," + rs.getString(5) + "," + rs.getString(6) + "," + rs.getString(7));
			}
			DBConn2.closeCon();
			return userlist;
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
		return null;
	}
	public List<HashMap> doSelect(String sql){
		List<HashMap> userlist = new ArrayList<HashMap>();
		try{
			Connection con = DBConn2.getCon();
			PreparedStatement prestmt = con.prepareStatement(sql);
			ResultSet rs = prestmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println(rsmd.getColumnName(1));
			System.out.println(rsmd.getColumnCount());
			while (rs.next()){
				HashMap hm = new HashMap();
				int colCount = rsmd.getColumnCount();
				for(int i =1; i<=colCount;i++){
					String colName = rsmd.getColumnName(i);
					hm.put(colName,rs.getString(colName));
				}
				userlist.add(hm);
			}
			DBConn2.closeCon();
			return userlist;
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[]args){
		Sql2 sql = new Sql2();
		List<String> userList = sql.getUserIDLists();
		for(int i=0; i<userList.size();i++){
		System.out.println(userList.get(i));
		}
		String order ="select ui.num, ui.name, ui.id, ui.pwd, ui.age, ci.class_name, ci.class_num from user_info as ui, class_info as ci";
		order += " where ci.class_num=ui.class_num";
		List<HashMap> uL = sql.doSelect(order);
		System.out.println("-유저인포&클래스인포-");
		for(int i=0; i<userList.size();i++){
		System.out.println(userList.get(i));
		}
	}
}