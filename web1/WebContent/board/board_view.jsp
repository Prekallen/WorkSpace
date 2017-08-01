<%@ include file="/common/header.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn" %>
<%@ page import="com.test.dto.BoardInfo" %>

<div class="container">
	<div class="starter-template">
<%
	int pBinum = Integer.parseInt(request.getParameter("binum"));
	Connection con = null;
	PreparedStatement ps = null;
	int binum = 0;
	String bititle = "";
	String bicontent = "";
	String bipwd = "";
	String creusr = "";
	String credat = "";
	try{
		con = DBConn.getCon();
		String sql = "select binum, bititle, bicontent, bipwd, creusr, credat from board_info where binum=?";
		ps = con.prepareStatement(sql);
		ps.setInt(1,pBinum);
		ResultSet rs = ps.executeQuery();
		rs.last();
		int rowCnt = rs.getRow();
		if(rowCnt==0){
%>
			<script>
				alert("<%=pBinum%>번 게시물은 없습니다.");
				history.back();
			</script>
<%
		}
		rs.beforeFirst();
		while(rs.next()){
			binum = rs.getInt("binum");
			bititle = rs.getString("bititle");
			bicontent = rs.getString("bicontent");
			creusr = rs.getString("creusr");
			credat = rs.getString("credat");
		}
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

			<table class='table table-bordered table-hover' style="width:60%; align:center;">
				<tr>
					<th style="text-align: center;">번호</th>
					<td><%=binum%></td>
				</tr>
				<tr>
					<th style="text-align: center;">제목</th>
					<td><input type="text" style="width: 100%;" id="title" name="title" value="<%=bititle%>" /></td>
				</tr>
				<tr>
					<th style="text-align: center;">내용</th>
					<td><textarea id="content" name="content" style="resize: none; width:100%;height:200px;"><%=bicontent%></textarea></td>
				</tr>
				<tr>
					<th style="text-align: center;">작성자</th>
					<td><input type="text" style="width: 100%;" id="creusr" name="cresur" value="<%=creusr%>" /></td>
				</tr>
				<tr>
					<th style="text-align: center;">작성시간</th>
					<td><%=credat%></td>
				</tr>
				<tr>
					<th style="text-align: center;">비밀번호</th>
					<td><input type="password" style="width: 100%;" id="pwd" name="pwd" /></td>
				</tr>
				<tr>
				<td colspan="2"><input type="button" style="width: 30%;" value="수정" onclick="updateBoard()" />
				<input type="button" style="width: 30%;"value="삭제" onclick="deleteBoard()" /></td>
			</table>

			</div>
		</div>

<script>
function deleteBoard(){
	var bipwd= document.getElementById("pwd").value;
	location.href="<%=rootPath%>/board/board_delete.jsp?binum=<%=binum%>&bipwd=" + bipwd;
}
function updateBoard(){
	var bipwd= document.getElementById("pwd").value;
	var bititle= document.getElementById("title").value;
	var bicontent= document.getElementById("content").value;
	var creusr= document.getElementById("creusr").value;
	location.href="<%=rootPath%>/board/board_update.jsp?binum=<%=binum%>&bipwd=" + bipwd + "&bititle=" + bititle + "&bicontent=" + bicontent + "&creusr=" + creusr;
	
}
</script>
<%@ include file="/common/footer.jsp"%>