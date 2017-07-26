<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.BoardInfo"%>
<script src="/js/Ajax.js"></script>
<script>


</script>
<body>
<%
BoardInfo bi = new BoardInfo();
String bINum = request.getParameter("bINum");
String bITitle = request.getParameter("bITitle");
String bIContent = request.getParameter("bIContent");
String bIPwd = request.getParameter("bIPwd");
String creUsr = request.getParameter("creUsr");
String creDat = request.getParameter("creDat");
String result = "";

	
		
	Connection con = null;
	PreparedStatement ps = null;
	String tableStr="<table border='1' bgcolor='yellow'>";
	try{
		con = DBConn.getCon();
		String sql = "select binum, bititle, bicontent, bipwd, creusr, credat from board_info";
		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		tableStr +="<tr align='center'><font color='red'>";
		tableStr +="<td>번호</td>";
		tableStr +="<td>제목</td>";
		tableStr +="<td>내용</td>";
		tableStr +="<td>비밀번호</td>";
		tableStr +="<td>작성자</td>";
		tableStr +="<td>작성일자</td>";
		tableStr +="</font></tr>";
		while(rs.next()){
			tableStr +="<tr>";
			tableStr +="<td><input type='text' value='" + rs.getString("binum") + "' disabled/></td>";
			tableStr +="<td><input type='text' id='bititle' name='bititle' value='" + rs.getString("bititle") + "'/></td>";
			tableStr +="<td><input type='text' id='bicontent' name='bicontent' value='" + rs.getString("bicontent") + "'/></td>";
			tableStr +="<td><input type='password' id='bipwd' name='bipwd' value='"+ rs.getString("bipwd") + "'/></td>";
			tableStr +="<td><input type='text' id='cresur' name='creusr' value='" + rs.getString("creusr") + "'/></td>";
			tableStr +="<td><input type='text' id='credat' name='credat' value='" + rs.getString("credat") + "'/></td>";
			tableStr +="</tr>";
			}
		
	}catch (Exception e){
		e.printStackTrace();
	}finally{
		if(ps!=null){
			ps.close();
			ps=null;
		}
		DBConn.closeCon();
	}
	%>	
	
	<input type='button' value='로그인 페이지 돌아가기' onclick='bSelect("main")'/>
	<input type='button' value='수정하기' onclick='bUpdate()'/>
	<input type='button' value='게시물 작성' onclick='bSelect("insert")'/>
	<input type="hidden"name="command" id="command" value="SELECT"/>

<div id=bd_div></div>
</body>
<script>
var tableStr = "<%=tableStr%>";;
document.getElementById("bd_div").innerHTML="";
var nameStr = "command";
var lengthStr = "100";
var typeStr = "s"
var params = "?";
params += nameStr + "=" + document.getElementById("command").value + "&";
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
</html>