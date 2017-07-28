<%@ include file = "/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn" %>
<%@ page import="com.test.dto.UserInfo" %>
<script src="/js/Ajax.js"></script>
<%

%>
<body>
<form method="get" action="<%=rootPath %>/user/do_sign_in.jsp">
	<div width="100%" id="bd_div">
		<table border="1" cellspacing="0" cellpadding="0" width="400"
			align="center">
			<tr>
				<td colspan="2"><p align="center">= 회원 가입 =</p></td>
			</tr>
			<tr align="center">
				<td>아이디</td>
				<td><input type="text" name="userid" id="userid" maxlength="30" /></td>
			</tr>
			<tr align="center">
				<td>비밀번호</td>
				<td><input type="password" name="userpwd" id="userpwd"
					maxlength="100" /></td>
			</tr>
			<tr align="center">
				<td>이름</td>
				<td><input type="text" name="username" id="username"
					maxlength="100" /></td>
			</tr>
			<tr align="center">
				<td>주소</td>
				<td><input type="text" name="address" id="address" size="35" /></td>
			</tr>
			<tr align="center">
				<td>나이</td>
				<td><input type="text" name="age" id="age" size="5"
					maxlength="3" /></td>
			</tr>
			<tr align="center">
				<td>휴대전화</td>
				<td><input type="text" name="hp1" id="hp1" size="4" />-<input
					type="text" name="hp2" id="hp2" size="4" />-<input type="text"
					name="hp3" id="hp3" size="4" /></td>
			</tr>
			<tr align="center">
				<td colspan="2" align="center"><input type="submit"
					value="회원가입"  /></td>
			</tr>
		</table>
	</div>
	<input type="hidden" name="command" id="command" value="SIGNIN" />
</form>
</body>
</html>