<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.UserInfo"%>

<%
	userId = request.getParameter("userid");
	userName = request.getParameter("username");
	age = Integer.parseInt(request.getParameter("age"));
	address = request.getParameter("address");
	hp1 = request.getParameter("hp1");
	hp2 = request.getParameter("hp2");
	hp3 = request.getParameter("hp3");
	String userPwd = request.getParameter("userpwd");
	
	String sql = "insert into user_info(userid, username, age, address, hp1, hp2, hp3,userpwd)";
	sql += "value(?,?,?,?,?,?,?,?);";
	
	Connection con = null;
	PreparedStatement ps = null;
	String result = "아이디 중복";
	int resultNum=0;
	
	
	try {
		con = DBConn.getCon();
		ps=con.prepareStatement(sql);
		ps.setString(1, userId);
		ps.setString(2, userName);
		ps.setInt(3, age);
		ps.setString(4, address);
		ps.setInt(5, Integer.parseInt(hp1));
		ps.setInt(6, Integer.parseInt(hp2));
		ps.setInt(7, Integer.parseInt(hp3));
		ps.setString(8, userPwd);
		
		resultNum = ps.executeUpdate();
		if (resultNum == 1) {
			result="회원가입 됨!";
			con.commit();
		}

	} catch (Exception e) {
		System.out.println(e);
	} finally {
		if (ps != null) {
			ps.close();
			ps = null;
		}
		DBConn.closeCon();
	}
%>		

<script>
alert("<%=result%>");
if("<%=resultNum%>"==1){
	location.href= "<%=rootPath%>/login.jsp";
}else{
	history.back();
}
</script>
<%@ include file="/common/footer.jsp"%>