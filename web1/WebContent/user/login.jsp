<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.UserInfo"%>

<link rel="stylesheet" href="<%=rootPath %>/ui/signin.css">
<body>
<jsp:include page="/common/top.jsp" flush="false">
	<jsp:param value="<%=login %>" name="login"></jsp:param>
</jsp:include>
	
	 
	     <div class="container">

      <form class="form-signin" action="<%=rootPath %>/user/userinfo.jsp" >
        <h2 class="form-signin-heading">Log in</h2>
        <label for="inputId" >ID</label>
        <input type="text" id="id" name="id" class="form-control" placeholder="ID" required autofocus>
        <label for="inputPassword">Password</label>
        <input type="password" id="pwd" name="pwd" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button id="btn2" class="btn btn-lg btn-primary btn-block" type="button">Log in</button>
       
      </form>

    </div> <!-- /container -->
<script>

$("button").click(function(){
	location.href="<%=rootPath %>/user/userinfo.jsp"
});

</script>	
</body>
</html>