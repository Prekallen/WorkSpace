<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn" %>
<%@ page import="com.test.dto.BoardInfo" %>
<body>
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
<table border="1">
<tr>
<th>번호</th><td> <%=binum %></td>
</tr>
<tr>
<th>제목</th><td><input type="text" id="title" name="title" value="<%=bititle %>"/></td>
</tr>
<tr>
<th>내용</th><td><textarea id="content" name="content" style="resize:none"><%=bicontent %></textarea></td>
</tr>
<tr>
<th>작성자</th><td><input type="text" id="creusr" name="cresur" value="<%=creusr %>"/></td>
</tr>
<tr>
<th>작성시간</th><td><%=credat %></td>
</tr>
<tr>
<th>비밀번호</th><td><input type="password" id="pwd" name="pwd"/></td>
</tr>
</table>
<input type="button" value="수정" onclick="updateBoard()" /><input type="button" value="삭제" onclick="deleteBoard()"/><p/>
<input type='button' value='게시판으로 돌아가기' onclick='bSelect("board")'/>
</body>
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
</html>