<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.test.common.DBConn" %>
<%@ page import="java.sql.*" %>
<%
	Gson g = new Gson();
	HashMap<String, String> hm = g.fromJson(request.getReader(), HashMap.class);
	String num = "";
	if (hm != null) {
		num = hm.get(num);
	}
	PreparedStatement ps = null;
	Connection con = null;
	List<HashMap> tableList = new ArrayList<HashMap>();
	try{
		con=DBConn.getCon();
		String sql = "select tnum,ttitle,twriter,tcontent from json_table where 1=1";
		if(num!=null&&!num.equals("")){
			sql += "and tnum=?";
		}
		ps = con.prepareStatement(sql);
		if(num!=null&&!num.equals("")){
			ps.setInt(1,Integer.parseInt(num));
		}
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			HashMap<String,String> tableM = new HashMap<String,String>();
			tableM.put("tnum", rs.getString("tnum"));
			tableM.put("ttitle", rs.getString("ttitle"));
			tableM.put("twriter", rs.getString("twriter"));
			tableM.put("tcontent", rs.getString("tcontent"));
			tableList.add(tableM);
		}
	}catch (Exception e){
		out.print(e);
	}finally{
		ps.close();
		DBConn.closeCon();
	}
	String json = g.toJson(tableList);
	System.out.println(json);
	out.print(json);
%>
