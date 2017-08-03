<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.test.common.DBConn" %>
<%@ page import="java.sql.*" %>
<%
Gson g = new Gson();
HashMap<String,String> hm = g.fromJson(request.getReader(), HashMap.class);
String op = "";
if(hm!=null){
	op = hm.get("op");
}
PreparedStatement ps=null;
Connection con=null;
ArrayList<Map<String, String>> calList = new ArrayList<Map<String, String>>();
try{
	con = DBConn.getCon();
	String sql = "select calnum,num1,op,num2,result from cal where 1=1";
	if(op!=null && !op.equals("")){
		sql += " and op = ?";
	}
	ps = con.prepareStatement(sql);
	if(op!=null && !op.equals("")){
		ps.setString(1,op);
	}
	ResultSet rs = ps.executeQuery();
	
	while(rs.next()){
		HashMap<String,String> sB = new HashMap<String,String>();
		sB.put("calnum", rs.getString("calnum"));
		sB.put("num1",rs.getString("num1"));
		sB.put("op",rs.getString("op"));
		sB.put("num2",rs.getString("num2"));
		sB.put("result",rs.getString("result"));
		calList.add(sB);
	}
	
}catch(Exception e){
	out.println(e);
}finally{
	ps.close();
	DBConn.closeCon();
}

String json= g.toJson(calList);
out.print(json);

%>