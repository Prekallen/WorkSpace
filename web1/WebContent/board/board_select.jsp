<%@ include file="/common/header.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.BoardInfo"%>
<script src="/js/Ajax.js"></script>
<body>

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


<div class="container">
	<div class="starter-template">
 <%
	String searchTarget = request.getParameter("searchTarget");
	String searchStr = request.getParameter("searchStr");
	Connection con = null;
	PreparedStatement ps = null;
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
		String tableStr="<table class='table table-bordered table-hover' align='center' style='width:60%;'>";
		tableStr += "<tr>";
		tableStr += "<th style='text-align:center;'>번호</th>";
		tableStr += "<th style='text-align:center;'>제목</th>";
		tableStr += "<th style='text-align:center;'>작성자</th>";
		tableStr += "<th style='text-align:center;'>작성일자</th>";
		tableStr += "</tr>";
		boolean existData = false;
		while(rs.next()){
			existData = true;
			tableStr += "<tr>";
			tableStr += "<td>"+rs.getInt("binum") + "</td>";
			tableStr += "<td><a href='#javascript' onclick='goBoard(" + rs.getInt("binum") + ")'>"+rs.getString("bititle") + "</a></td>";
			tableStr += "<td>"+rs.getString("creusr") + "</td>";
			tableStr += "<td>"+rs.getString("credat") + "</td>";
			tableStr += "</tr>";
		}
		if(!existData){
			tableStr += "<tr>";
			tableStr += "<td colspan='6' align='center'>데이터가 아무것도 없다!!!</td>";
			tableStr += "</tr>";
		}else{
			tableStr += "<tr>";
			tableStr += "<td colspan='6' align='center'>";
			tableStr += "<select style='height:25px;' name='searchTarget' id='searchTarget'>";
			tableStr += "<option value='bititle'>제목</option>";
			tableStr += "<option value='creusr'>작성자</option>";
			tableStr += "<option value='bicontent'>내용</option>";
			tableStr += "<option value='bicontitle'>제목 + 내용</option>";
			tableStr += "</select> ";
			tableStr += " <input type='text' name='searchStr' id='searchStr'/> ";
			tableStr += " <a href='#' class='btn btn-default' onclick='doSearch()'>검색</a>";
			tableStr += "</td>";
			tableStr += "</tr>";
		}
		tableStr += "</table>";
		out.println(tableStr);
	}catch(Exception e){
		System.out.println(e);
	}finally{
		if(ps!=null){
			ps.close();
			ps = null;
		}
		DBConn.closeCon();
	}
	%>
	<input type='button' value='메인으로 가기' onclick='bSelect("main")'/>
	<input type='button' value='게시물 작성' onclick='bSelect("insert")'/>
	<input type="hidden"name="command" id="command" value="SELECT"/>
	<div id=bd_div></div>
	</div>
	</div>
<%@ include file="/common/footer.jsp"%>