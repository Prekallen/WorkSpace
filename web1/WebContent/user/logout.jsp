<%@ include file = "/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session.invalidate();
%>
<script>
alert("로그아웃 됨!");
location.href="<%=rootPath%>/main.jsp"
</script>
<%@ include file="/common/footer.jsp"%>