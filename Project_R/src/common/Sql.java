package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Sql {
	public List<String> getUserIDLists(String name) {
		//String reult"";
		List<String> userlist = new ArrayList<String>();
		try{
			Connection con = DBConn2.getCon();
			String sql = "select id,pwd,name from test where name='"+name+"'";
			PreparedStatement prestmt = con.prepareStatement(sql);
			ResultSet rs = prestmt.executeQuery();
			while (rs.next()){
				userlist.add(rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3));
			}
			DBConn2.closeCon();
			return userlist;
		}catch(SQLException | ClassNotFoundException e){
		  e.printStackTrace();
		}
		return null;
	}
	public static void main(String[]args){
		Sql sql = new Sql();
		List<String> userlist = sql.getUserIDLists("John");
		System.out.println(userlist);
	}
}
