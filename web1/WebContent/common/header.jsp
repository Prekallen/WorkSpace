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
	Date toDate = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	String toDateStr = sdf.format(toDate);
%>
<script>
	
</script>