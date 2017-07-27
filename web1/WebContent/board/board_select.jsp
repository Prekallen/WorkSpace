<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.BoardInfo"%>
<script src="/js/Ajax.js"></script>
<script>
function goBoard(bINum, param2){
	location.href ="<%=rootPath%>/board/board_view.jsp?binum=" + bINum;
}
function doSearch(){
	var searchTarget = document.getElementById("searchTarget").value;
	var searchStr = document.getElementById("searchStr").value;
	location.href ="<%=rootPath%>/board/board_select.jsp?searchTarget=" + searchTarget + "&searchStr=" + searchStr;
}
</script>
<body>
<%
BoardInfo bi = new BoardInfo();
String searchTarget = request.getParameter("searchTarget");
String searchStr = request.getParameter("searchStr");
String bINum = request.getParameter("bINum");
String bITitle = request.getParameter("bITitle");
String bIContent = request.getParameter("bIContent");
String bIPwd = request.getParameter("bIPwd");
String creUsr = request.getParameter("creUsr");
String creDat = request.getParameter("creDat");
String result = "";
		
	Connection con = null;
	PreparedStatement ps = null;
	String tableStr="<table border='1'>";
	try{
		con = DBConn.getCon();
		String sql = "select binum, bititle, bicontent, bipwd, creusr, credat from board_info where 1=1";

		if(searchTarget!=null){
			if(searchTarget.equals("bititle")){
				sql += " and bititle like ?";
			}else if(searchTarget.equals("bicontent")){
				sql += " and bicontent like ?";
			}else if(searchTarget.equals("creusr")){
				sql += " and creusr like ?";
			}else if(searchTarget.equals("bicontitle")){
				sql += " and bicontent like ? or bititle like ?";
			}
		}
		ps = con.prepareStatement(sql);
		if(searchTarget!=null){
			ps.setString(1, "%"+searchStr+"%");
			if(searchTarget.equals("bicontitle")){
				ps.setString(2, "%"+searchStr+"%");
			}
		}
		ResultSet rs = ps.executeQuery();
		tableStr +="<tr align='center'>";
		tableStr +="<th bgclor='yellow'>번호</td>";
		tableStr +="<th width='100' bgclor='yellow'>제목</td>";
		tableStr +="<th width='80' bgclor='yellow'>작성자</td>";
		tableStr +="<th bgclor='yellow'>작성일자</td>";
		tableStr +="</tr>";
		boolean existData = false;
		while(rs.next()){
			existData=true;
			tableStr +="<tr>";
			tableStr +="<td>" + rs.getString("binum") + "</td>";
			tableStr +="<td><a href='#javascrip' onclick='goBoard(" + rs.getInt("binum") + ")'><input type='button' style='width:100%;background-color:yellow;color: red;' value='" + rs.getString("bititle") + "'/></a></td>";
			tableStr +="<td>" + rs.getString("creusr") + "</td>";
			tableStr +="<td>" + rs.getString("credat") + "</td>";
			tableStr +="</tr>";
			}
		if(!existData){
			tableStr += "<tr>";
			tableStr += "<td colspan='4' align='center'>데이터가 아무것도 없다!!!</td>";
			tableStr += "</tr>";
		}else{
			tableStr += "<tr>";
			tableStr += "<td colspan='4' align='center'>";
			tableStr += "<select name='searchTarget' id='searchTarget'>";
			tableStr += "<option value='bititle'>제목</option>";
			tableStr += "<option value='creusr'>작성자</option>";
			tableStr += "<option value='bicontent'>내용</option>";
			tableStr += "<option value='bicontitle'>제목 + 내용</option>";
			tableStr += "</select> ";
			tableStr += " <input type='text' name='searchStr' id='searchStr'/> ";
			tableStr += " <input type='button' value='검색' onclick='doSearch()'/>";
			tableStr += "</td>";
			tableStr += "</tr>";
		}
		tableStr += "</table>";
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