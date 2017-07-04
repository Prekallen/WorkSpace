package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.sun.javafx.collections.MappingChange.Map;

import common.DBConn2;

public class TestDAO {
	Scanner scan = new Scanner(System.in);
	
	public boolean insertTest() {
		try{
			String writer = "4";
			Connection con = DBConn2.getCon();
			String sql = "select * from user_info where num=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, writer);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				sql = "INSERT INTO TEST(TITLE, CONTENT, WRITER, REG_DATE)";
				sql += " values(?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, "게시물4");
				ps.setString(2, "내용4");
				ps.setString(3, writer);
				Date d = new Date();
				SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				ps.setString(4,sdt.format(d));
				int result = ps.executeUpdate();
				if(result==1){
					return true;
				}
			}else{
				System.out.println(writer + "번호를 가진 사람이 유저인포테이블에 없어요 자시가!!");
			}
			DBConn2.closeCon();
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
