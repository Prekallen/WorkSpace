<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>예뻐해주세요.</title>
</head>
<%!
public void printStr(String str){
	System.out.println("WoW");
}
%>
<%
	String userId = (String) session.getAttribute("userid");
	String userName = "";
	int age = 0;
	String address = "";
	String hp1 = "";
	String hp2 = "";
	String hp3 = "";
	
	boolean login = false;
	if (userId != null) {
		userName = (String) session.getAttribute("username");
		age = (int) session.getAttribute("age");
		address = (String) session.getAttribute("address");
		hp1 = (String) session.getAttribute("hp1");
		hp2 = (String) session.getAttribute("hp2");
		hp3 = (String) session.getAttribute("hp3");
		login = true;
	}
	String rootPath = request.getContextPath();
	Date toDate = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	String toDateStr = sdf.format(toDate);
	String init = request.getParameter("init");
	String defaultUrl = "";
	if(init==null&&!login){
			defaultUrl = rootPath + "/user/login.jsp?init=1";
			response.sendRedirect(defaultUrl);	
	}
%>

<script src="<%=rootPath%>/js/jquery-3.2.1.js">

</script>
<script>
var rootPath ="<%=rootPath%>";

function bSelect(pageId) {
	var url="";
	if(pageId=="board"){
		url= rootPath + "/board/board_select.jsp"
		location.href = url;
	}else if(pageId=="main"){
		location.href = rootPath + "/";
	}else if(pageId=="insert"){
		url=rootPath +"/board/board_insert.jsp"
		location.href = url;
	}else{
	location.href= url;
	}
}
</script>