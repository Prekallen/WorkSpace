<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
<title>IOT MAIN</title>
</head>
<body>
<jsp:include page="/common/top.jsp" flush="false">
	<jsp:param value="<%=login %>" name="login"></jsp:param>
</jsp:include>
    <div class="container">
      <div class="starter-template">
        <h1>메인 화면</h1>
        <p class="lead">Be WELCOME You</p>
      </div>
    </div>
</body> 
</html>