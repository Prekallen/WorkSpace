<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/common/header.jsp" %>
<%	
String userId = (String) session.getAttribute("userId");
if(userId!=null){
	String userName = (String) session.getAttribute("userName");
}
%>

<div class="container" style="padding-top:50px;">
	<h4 class="form-signin-heading" >${userName} 님 환영합니다.</h4>
	<h1 style="text-align:center;padding-top:50px;">메인화면</h1>	
</div>
<%@ include file = "/WEB-INF/views/common/footer.jsp" %>