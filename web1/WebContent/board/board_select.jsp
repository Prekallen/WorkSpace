<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.BoardInfo"%>
<script src="/js/Ajax.js"></script>
<script>
var tableStr = "<%=tableStr%>";;
document.getElementById("bd_div").innerHTML="";
var nameStr = "command";
var lengthStr = "100";
var typeStr = "s"
var params = "?";
params += nameStr + "=" + "SELECT" + "&";
var au = new AjaxUtil(params);
au.changeCallBack(function() {
			if (au.xhr.readyState == 4) {
				if (au.xhr.status == 200) {
					var result = decodeURIComponent(au.xhr.responseText);

					document.getElementById("bd_div").innerHTML += tableStr;

				} else {
					document.getElementById("bd_div").innerHTML += au.xhr.responseText;
				}
			}
		});
au.send();

</script>
<body>
<%
BoardInfo bi = new BoardInfo();
String bINum = request.getParameter("binum");
String bITitle = request.getParameter("bititle");
String bIContent = request.getParameter("bicontent");
String bIPwd = request.getParameter("bIPwd");
String creUsr = request.getParameter("BITitle");
String creDat = request.getParameter("credat");
String result = "";

	
		
	Connection con = null;
	PreparedStatement ps = null;
	try{
		con = DBConn.getCon();
		String sql = "select binum, bititle, bicontent, bipwd, creusr, credat from board_info";
		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		String tableStr="<table border='1'>";
		tableStr +="<tr>";
		tableStr +="<td>번호</td>";
		tableStr +="<td>제목</td>";
		tableStr +="<td>내용</td>";
		tableStr +="<td>비밀번호</td>";
		tableStr +="<td>작성자</td>";
		tableStr +="<td>작성일자</td>";
		tableStr +="</tr>";
		while(rs.next()){
			tableStr +="<tr>";
			tableStr +="<td>" + rs.getString("binum") + "</td>";
			tableStr +="<td>" + rs.getString("bititle") + "</td>";
			tableStr +="<td>" + rs.getString("bicontent") + "</td>";
			tableStr +="<td>"+ rs.getString("bipwd") + "</td>";
			tableStr +="<td>" + rs.getString("creusr") + "</td>";
			tableStr +="<td>" + rs.getString("credat") + "</td>";
			tableStr +="</tr>";
			}
		
	}catch (Exception e){
		e.printStackTrace();
	}finally{
		DBConn.closeCon();
		ps.close();
	}
	%>	
	
	<input type='button' value='로그인 페이지 돌아가기' onclick='bSelect("main")'/>
	<input type='button' value='수정하기' onclick='bUpdate()'/>
	<input type="hidden"name="command" id="command" value="SELECT"/>

<div id=bd_div></div>
</body>
<script>
</script>
</html>