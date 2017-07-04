package DAO;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.DBConn2;

public class BoardDAO {
	Connection con;
	public void setConnection() throws ClassNotFoundException, SQLException{
		con=DBConn2.getCon();
	}

	public boolean insertBoard() {
		String sql = "insert into board (title,content,writer,reg_date) values('게시판제목3', '게시판내용3', '5', now())";
		try{
			Statement st = con.createStatement();
			int result = st.executeUpdate(sql);
			if(result==1){
				con.commit();
				st.close();			//반드시 종료해줘야 함! 메모리 초기화!!
				st=null;
				return true;
			}
		}catch(SQLException e){
			try{
				con.rollback();
			}catch(SQLException e1){
				e1.printStackTrace();
			}e.printStackTrace();
		}
		return false;
	}

	public boolean updateBoard(){
		String sql = "update board set title='으하하하하' where num='31'";
		try{
			Statement st = con.createStatement();
			int result = st.executeUpdate(sql);
			if(result==1){
				con.commit();
				st.close();
				st=null;
				return true;
			}
		}catch(SQLException e){
			try{
				con.rollback();
			}catch(SQLException e1){
				e1.printStackTrace();
			}e.printStackTrace();
		}
		return false;
	}

	public boolean deleteBoard(){
		String sql = "delete from board where num>'29'";
		try{
			Statement st = con.createStatement();
			int result = st.executeUpdate(sql);
			if(result>=1){
				con.commit();
				st.close();
				st=null;
				return true;
			}
		}catch(SQLException e){
			try{
				con.rollback();
			}catch(SQLException e1){
				e1.printStackTrace();
			}e.printStackTrace();
		}
		return false;
	}


	public List<Map> selectBoard() throws SQLException{


		String sql = "select num,title,content,writer,reg_date from board";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		List<Map> sb = new ArrayList<Map>();
		while(rs.next()){
			Map hm = new HashMap();
			hm.put("num", rs.getString("num"));
			hm.put("tilte", rs.getString("title"));
			hm.put("content", rs.getString("content"));
			hm.put("writer", rs.getString("writer"));
			hm.put("reg_date", rs.getString("reg_date"));
			sb.add(hm);
		}
		rs.close();
		rs=null;
		st.close();
		st=null;

		return sb;
	}


	public static void main(String[]args){
		BoardDAO bdao = new BoardDAO();
		try {
			bdao.setConnection();
			List<Map> boardList = bdao.selectBoard();
			CommentDAO dao = new CommentDAO();
			for(Map m : boardList){
				System.out.println(m);
				List<Map> commentList = dao.getCommentList(Integer.parseInt((String)m.get("num")));
				for(Map m2 : commentList){
					System.out.println(m2);
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}