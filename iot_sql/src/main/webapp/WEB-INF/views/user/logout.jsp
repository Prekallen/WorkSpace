<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/top_menu.jsp"%>
<title>LogOut</title>
<body>
<div style="padding-top:150px"></div>
<h1 style="text-align:center">감사합니다.</h1>
<h5 style="text-align:center"> 자동으로 페이지 이동 합니다.</h5>
</body>
<script>
$(document).ready(function(){
	pageMove("user/login");
})
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>