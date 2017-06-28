package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Sql {
	Scanner scan = new Scanner(System.in);
	public List<String> getUserIDLists(String name) {
		//String reult"";
		List<String> userlist = new ArrayList<String>();
		try{
			Connection con = DBConn2.getCon();
			String sql = "select id,pwd,name from user";
			if(!name.equals("")){
				sql += " where name='"+name+"'";
			}
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

	public boolean insertUser(){
		try{
			Connection con = DBConn2.getCon();
			HashMap<String,String>hm = new HashMap<String,String>();
			System.out.println("id를 입력해 주세요.>");
			hm.put("id", scan.nextLine());
			System.out.println("pwd를 입력해 주세요.>");
			hm.put("pwd", scan.nextLine());
			System.out.println("이름을 입력해 주세요.>");
			hm.put("name", scan.nextLine());
			System.out.println("나이를 입력해 주세요.>");
			hm.put("age", scan.nextLine());
			String sql = "insert into user (id,pwd,name ,age)values('";
			sql += hm.get("id")+"','";
			sql += hm.get("pwd") +"','";
			sql += hm.get("name")+ "','";
			sql += Integer.parseInt(hm.get("age"))+"')";
			PreparedStatement prestmt = con.prepareStatement(sql);
			int result = prestmt.executeUpdate();
			DBConn2.closeCon();
			if(result ==1){
				return true;
			}
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteUser(){
		try {
			Connection con = DBConn2.getCon();
			System.out.println("지울 값을 입력하시오.>");
			int str = Integer.parseInt(scan.nextLine());
			String sql = "delete from user where num='" + str + "'";
			PreparedStatement prestmt = con.prepareStatement(sql);
			int result = prestmt.executeUpdate();
			DBConn2.closeCon();
			if(result>0){
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean UpdateUser(){
		try {
			Connection con = DBConn2.getCon();
			System.out.println("변경될 이름을 입력하시오.>");
			String str = scan.nextLine();
			String sql = "update user set name='" + str;
			System.out.println("변경할 이름을 입력하시오.>");
			str = scan.nextLine();
			sql += "' where name = '" + str + "'";
			PreparedStatement prestmt = con.prepareStatement(sql);
			int result = prestmt.executeUpdate();
			DBConn2.closeCon();
			if(result>0){
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[]args){
		Sql sql = new Sql();
		
		List<String> userlist =  sql.getUserIDLists("");
		System.out.println(userlist);
		
		boolean isIns = sql.insertUser();
		if(isIns){
			System.out.println("테이블이 잘 삽입됬네요..");
		}
		
		boolean isDel = sql.deleteUser();
		if(isDel){
			System.out.println("테이블에 잘 삭제가 됬네요!!");
		}
		boolean isUp = sql.UpdateUser();
		if(isUp){
			System.out.println("블루길동 ㄱㄱ!!");
		}
		
		for(int i = 0; i<userlist.size();i++){
			System.out.println(userlist.get(i));
		}
	}
}