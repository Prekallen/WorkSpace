<%@ include file="/common/header.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.UserInfo"%>

<%
	String bITitle = request.getParameter("bititle");
	String bIContent = request.getParameter("bicontent");
	String bIPwd = request.getParameter("bipwd");
	String creUsr = request.getParameter("creusr");
	
	String sql = "insert into board_info(bititle, bicontent, bipwd, creusr, credat)";
	sql += "value(?,?,?,?,now());";
	
	Connection con = null;
	PreparedStatement ps = null;
	String result = "저장이 안됨";
	int resultNum=0;
	
	
	try {
		con = DBConn.getCon();
		ps=con.prepareStatement(sql);
		ps.setString(1, bITitle);
		ps.setString(2, bIContent);
		ps.setString(3, bIPwd);
		ps.setString(4, creUsr);
		resultNum = ps.executeUpdate();
		if (resultNum == 1) {
			result="저장 됨";
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
	location.href= "<%=rootPath%>/board/board_select.jsp";
}else{
	history.back();
}
</script>
<%@ include file="/common/footer.jsp"%>