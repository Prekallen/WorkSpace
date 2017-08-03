<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.test.common.DBConn" %>
<%@ page import="java.sql.*" %>
<%
Gson g = new Gson();
HashMap<String,String> hm = g.fromJson(request.getReader(),HashMap.class);
String sN="";
if(hm!=null){
	sN = hm.get("sN");
}
PreparedStatement ps =null;
Connection con = null;
List<HashMap> list = new ArrayList<HashMap>();
try{
		con = DBConn.getCon();
		String sql = "select jtnum,jttest from json_test";
		if(sN!=null&&!sN.equals("")){
			sql+= "where jtnum=?";
		}
		ps=con.prepareStatement(sql);
		if(sN!=null && !sN.equals("")){
			ps.setInt(1,Integer.parseInt(sN));
		}
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			HashMap jhm = new HashMap();
			jhm.put("jTNum",rs.getInt("jtnum"));
			jhm.put("jTTest",rs.getString("jttest"));
			list.add(jhm);
		}
	}catch(Exception e){
	System.out.println(e);
	}finally{
		ps.close();
		DBConn.closeCon();
	}
String json = g.toJson(list);
out.print(json);
System.out.println(json);
%>