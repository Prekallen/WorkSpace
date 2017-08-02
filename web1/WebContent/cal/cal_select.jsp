<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.test.common.DBConn" %>
<%@ page import="java.sql.*" %>
<%
Gson g = new Gson();
List<HashMap> board = new ArrayList<HashMap>();
PreparedStatement ps=null;
Connection con=null;
try{
	con = DBConn.getCon();
	String sql = "select calnum,num1,op,num2,result from cal where 1=1;";
	ps = con.prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	HashMap<String,String> sB = new HashMap<String,String>();
	
	while(rs.next()){
		sB.put("calnum", rs.getInt("calnum")+"");
		sB.put("num1",rs.getInt("num1")+"");
		sB.put("op",rs.getString("op"));
		sB.put("num2",rs.getInt("num2")+"");
		sB.put("result",rs.getInt("result")+"");
		board.add(sB);
	}
	
}catch(Exception e){
	out.println(e);
}finally{
	ps.close();
	DBConn.closeCon();
}

String json= g.toJson(board);
out.print(json);
System.out.print(json);
%>