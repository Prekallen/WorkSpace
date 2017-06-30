package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.sun.javafx.collections.MappingChange.Map;

import common.DBConn2;

public class TestDAO {
	Scanner scan = new Scanner(System.in);
	
	public boolean insertTest() {
		try{
			Connection con = DBConn2.getCon();
			HashMap<String,String>hm = new HashMap<String,String>();
			System.out.println("title을 넣어주세요.>");
			hm.put("title", scan.nextLine());
			System.out.println("content를 넣어주세요.>");
			hm.put("content", scan.nextLine());
			System.out.println("writer를 넣어주세요.>");
			hm.put("writer", scan.nextLine());
			String sql = "insert into test (title,content,writer,reg_date) values(?,?,?,now())";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("title"));
			ps.setString(2, hm.get("content"));
			ps.setString(3, hm.get("writer"));
			int result = ps.executeUpdate();
			DBConn2.closeCon();
			if(result==1){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateTest(){
		try{
			Connection con = DBConn2.getCon();
			HashMap<String,String>hm = new HashMap<String,String>();
			System.out.println("바꾸실 내용을 써주세요.>");
			hm.put("content1", scan.nextLine());
			System.out.println("바뀔 내용울 넣어주세요.>");
			hm.put("content2", scan.nextLine());
			String sql = "update test set title = ? where title = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("content2"));
			ps.setString(2, hm.get("content1"));
			int result = ps.executeUpdate();
			DBConn2.closeCon();
			if(result>0){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	

	public boolean deleteTest(){
		try {
			Connection con = DBConn2.getCon();
			System.out.println("지울 값을 입력하시오.>");
			int str = Integer.parseInt(scan.nextLine());
			String sql = "delete from user where num=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, str);
			int result = ps.executeUpdate();
			DBConn2.closeCon();
			if(result>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args){
		TestDAO tdao = new TestDAO();
		if(tdao.insertTest()){
			System.out.println("테스트에 잘 입력 되었습니다.");
		};
		if(tdao.updateTest()){
			System.out.println("테스트의 내용이 잘 수정 되었습니다.");
		}
		if(tdao.deleteTest()){
			System.out.println("테스트의 내용이 잘 삭제 되었습니다.");
		}
	}
}
