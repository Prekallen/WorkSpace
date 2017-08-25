<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
    
    
<div class="container">
	<form class="form-signin" >
		<button id="userMainBtn" class="btn btn-lg btn-primary " type="button">MAIN</button>
		<button id="logOutBtn" class="btn btn-lg btn-primary " type="button">Log Out</button>
	</form>
	<h5 class="form-signin-heading" >${userId} 님 환영합니다.</h5>
	<h3 style="text-align:center"></h3>	
</div>
<script>
//$("#logOutBtn").click(function(){
//	alert("Log Out");
//	location.href="${pageContext.request.contextPath}/user/logout";
//})
//$("#userMainBtn").click(function(){
//	location.href="${pageContext.request.contextPath}/user/main";
//})
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>