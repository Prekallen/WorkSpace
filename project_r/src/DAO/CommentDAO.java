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

public class CommentDAO {

	Connection con;
	CommentDAO() throws ClassNotFoundException, SQLException{
		con = DBConn2.getCon();
	}
	public List<Map> getCommentList(int boardNum) throws SQLException{
		String sql = "select ci.num, ci.content, ci.reg_date, ci.ui_num, ci.b_num, ui.name";
		sql += " from comment_info ci, user_info ui,board b where ci.b_num=b.num and ci.ui_num=ui.num and ci.b_num=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, boardNum);
		
		ResultSet rs = ps.executeQuery();
		ArrayList commentList = new ArrayList();
		while(rs.next()){
			HashMap hm = new HashMap();
			hm.put("num", rs.getString("num"));
			hm.put("content", rs.getString("content"));
			hm.put("reg_Date", rs.getString("reg_Date"));
			hm.put("ui_num", rs.getString("ui.name"));
			commentList.add(hm);
		}
		rs.close();
		rs = null;
		ps.close();
		ps = null;
		return commentList;
	}
	public void closeCon(){
		try{
			DBConn2.closeCon();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		try {
			CommentDAO cdao = new CommentDAO();
			List<Map> commentList = cdao.getCommentList(Integer.parseInt("3"));
			for(Map m : commentList){
				System.out.println(m);
						}
			DBConn2.closeCon();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		
	}
}