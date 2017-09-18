<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/style.jsp" %>
<%
String userId = (String) session.getAttribute("userId");
if(userId!=null&&!userId.equals("")){
	String userName = (String) session.getAttribute("userName");
}
%>
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" id="main" style="cursor:pointer;">WHAT</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a id="board" style="cursor:pointer;">게시판가기</a></li>
            <li><a id="userList" style="cursor:pointer;">유저정보가기</a></li>
            <li><a id="querySQL" style="cursor:pointer;">QUERY</a></li>
            <li id="logInOut"></li>
          </ul>
          
        </div><!--/.nav-collapse -->
      </div>
</nav>
<script>
if(<%=userId%>!=null){
	$("#logInOut").html("<a id='logOut' style='cursor:pointer;'>로그아웃</a>");
}else{
	$("#logInOut").html("<a id='logIn' style='cursor:pointer;'>로그인</a>");
}
$("#main").click(function(){
	if(<%=userId%>!=null){
		pageMove("user/main");
	}else{
		pageMove("user/login");
	}
})
$("#board").click(function(){
	if(<%=userId%>!=null){
		pageMove("goods/goods_list")
	}else{
		pageMove("user/login");
	}
})
$("#userList").click(function(){
	if(<%=userId%>!=null){
		pageMove("grid/api");
	}else{
		pageMove("user/login");
	}
})
$("#querySQL").click(function(){
	if(<%=userId%>!=null){
		pageMove("db/iot_sql");
	}else{
		pageMove("user/login");
	}
})
$("#logOut").click(function(){
	pageMove("user/logout");
})
$("#logIn").click(function(){
	pageMove("user/login")
})

</script>
<br><br><p/><br>