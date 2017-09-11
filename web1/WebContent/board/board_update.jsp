<%@ include file="/common/header.jsp"%>
<%@ include file="/common/footer.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.UserInfo"%>
<script src="/js/Ajax.js"></script>

<%
	int bINum=Integer.parseInt(request.getParameter("binum"));
	String bIPwd=request.getParameter("bipwd");
	String bITitle=request.getParameter("bititle");
	String bIContent=request.getParameter("bicontent");
	String creUsr=request.getParameter("creusr");
	String creDat=toDateStr;
		
	
	String sql = "update board_info set bititle=?, bicontent=?, creusr=?, credat=?";
	sql += "where binum=? and bipwd=?;";
	
	Connection con = null;
	PreparedStatement ps = null;
	String result = "수정 안됨";
	int resultNum=0;
	try {
		con = DBConn.getCon();
		ps=con.prepareStatement(sql);
		ps.setString(1, bITitle);
		ps.setString(2, bIContent);
		ps.setString(3, creUsr);
		ps.setString(4, creDat);
		ps.setInt(5, bINum);
		ps.setString(6, bIPwd);
		resultNum = ps.executeUpdate();
		if(resultNum==1){
			result = "수정 됨.";
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
if(<%=resultNum%> == 1){
	location.href= "<%=rootPath%>/board/board_select.jsp";
}else{
	history.back();
}
</script>