package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.DBConn2;

public class CommentDAO2 {
	Connection con;
	
	public List<Map> selectB(){
		List<Map>bList = new ArrayList<Map>();
		try{
			con=DBConn2.getCon();
			String sql="select num,title,content,writer,reg_date from board;";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Map hm = new HashMap();
				hm.put("num", rs.getInt("num"));
				hm.put("title", rs.getString("title"));
				hm.put("content", rs.getString("content"));
				hm.put("writer", rs.getInt("writer"));
				hm.put("reg_date", rs.getString("reg_date"));
				bList.add(hm);
			}
				DBConn2.closeCon();
				
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}return bList;
	}

	public List<Map> selectC(){
		List<Map>cList = new ArrayList<Map>();
		try{
			con=DBConn2.getCon();
			String sql="select ci.* from comment_info as ci, board as b where ci.b_num=b.num where board_num=?;";
			System.out.println("게시물 번호를 넣어주세요.>");
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Map hm = new HashMap();
				hm.put("num", rs.getInt("num"));
				hm.put("content", rs.getString("content"));
				hm.put("reg_date", rs.getString("reg_date"));
				hm.put("ui_num",rs.getInt("ui_num"));
				cList.add(hm);

			}
				DBConn2.closeCon();
				
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}return cList;
	}
	public static void main(String[] args){
		CommentDAO2 cdao = new CommentDAO2();
		List<Map>lmB = cdao.selectB();
		List<Map>lmC = cdao.selectC();
		for(Map m : lmB){
			System.out.println(m);
			for(Map n : lmC){
				System.out.println(n);
			}
		}
	}
}
