<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.test.common.DBConn" %>
<%@ page import="java.sql.*" %>
<%
	Gson g = new Gson();
	HashMap<String, String> hm = g.fromJson(request.getReader(), HashMap.class);
	PreparedStatement ps = null;
	Connection con = null;
	List<HashMap> tableList = new ArrayList<HashMap>();
	try{
		con=DBConn.getCon();
		String sql = "select vinum,viname";
				sql+=	" from vendor_info";
	
		ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			HashMap<String,String> tableM = new HashMap<String,String>();
			tableM.put("vinum", rs.getString("vinum"));
			tableM.put("viname", rs.getString("viname"));
			
			tableList.add(tableM);
		}	
	}catch (Exception e){
		out.print(e);
	}finally{
		ps.close();
		DBConn.closeCon();
	}
	String json = g.toJson(tableList);
	
	out.print(json);
%>