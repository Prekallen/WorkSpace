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
	private static final int HashMap = 0;
	Scanner scan = new Scanner(System.in);
	String state;
	HashMap<String,String>hm = new HashMap<String,String>();
	Sql2(){
		System.out.println("유저 정보를 입력 하시겠습니까? 클래스 정보를 입력 하시겠습니까?");
		state = scan.nextLine();
		for(int i=0; i<1; i++){
			if(state.equals("유저")){
				System.out.println("id를 입력해 주세요.>");
				hm.put("id", scan.nextLine());
				System.out.println("pwd를 입력해 주세요.>");
				hm.put("pwd", scan.nextLine());
				System.out.println("이름을 입력해 주세요.>");
				hm.put("name", scan.nextLine());
				System.out.println("나이를 입력해 주세요.>");
				hm.put("age", scan.nextLine());
				System.out.println("Class_num를 입력해주세요.>");
				hm.put("class_num",scan.nextLine());
			}else if(state.equals("클래스")){
				System.out.println("클래스 이름을 입력해 주세요.>");
				hm.put("class_name",scan.nextLine());	
			}else{
				System.out.println("입력하실 정보의 위치를 다시 입력해주세요.>");
				i--;
			}
		}
	}
	public List<HashMap> doSelect(String sql){

		List<HashMap> userlist = new ArrayList<HashMap>();
		try{
			Connection con = DBConn2.getCon();
			PreparedStatement prestmt = con.prepareStatement(sql);

			if(state.equals("유저")){
				prestmt.setString(1, hm.get("id"));
				prestmt.setString(2, hm.get("pwd"));
				prestmt.setString(3, hm.get("name"));
				prestmt.setInt(4, Integer.parseInt(hm.get("age")));
				prestmt.setInt(5, Integer.parseInt(hm.get("class_num")));
			}else{
				prestmt.setString(1, hm.get("class_name"));	
			}
			ResultSet rs = prestmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
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
		Sql2 s2 = new Sql2();
		String sql = "";

		if(s2.state.equals("유저")){
			List<HashMap> userList = s2.doSelect(sql);
			sql = "insert into user_info (id,pwd,name ,age,class_num) values(?,?,?,?,?)";
			userList = s2.doSelect(sql);
			 
			
		}else{
			List<HashMap> userList = s2.doSelect(sql);
			sql = "insert into class_info(class_name) values(?)";
			userList = s2.doSelect(sql);
			 
			}
		
	}
}