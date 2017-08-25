<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%
String userId = (String) session.getAttribute("userid");
if(userId!=null){
	String userName = (String) session.getAttribute("userName");
}
%>

<div class="container">
	<form class="form-signin" >
		<button id="userListBtn" class="btn btn-lg btn-primary " type="button">LIST</button>
		<button id="logOutBtn" class="btn btn-lg btn-primary " type="button">Log Out</button>
	</form>
	<h5 class="form-signin-heading" >${userId} 님 환영합니다.</h5>
	<h1 style="text-align:center">메인화면</h1>	
</div>
<script>
$("#logOutBtn").click(function(){
	alert("Log Out");
	location.href="${pageContext.request.contextPath}/user/logout";
})
$("#userListBtn").click(function(){
	
})
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>