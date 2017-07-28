<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.UserInfo"%>
<script>
	var setObj;
	var loopCnt=0;
	
	function logout() {
		location.href = <%=rootPath%>"/user/userinfo.jsp";
	}
	
	function signin(){
		location.href = <%=rootPath%>"/user/sign_in.jsp";
	}
		
</script>
<link rel="stylesheet" href="<%=rootPath %>/ui/signin.css">
<body>
	<%
		if (login) {
			out.println("What time is it now! ==>  " + toDateStr + "<p/>");
			out.println(userId + "님 꼬몬~");
			out.println("<br/>");
			out.println(userId + "님 의 정보");
			out.println("<br/>");
			out.println("성명 : " + userName);
			out.println("<br/>");
			out.println("나이 : " + age);
			out.println("<br/>");
			out.println("주소 : " + address);
			out.println("<br/>");
			out.println("전화번호 : " + hp1 + hp2 + hp3);
			out.println("<p/>");
			out.println("<input type='button' value='로그아웃' onclick='logout()'/>");
			out.println("<input type='button' value='게시판' onclick='bSelect(\"board\")'/>");
			out.println("<div id='bd_div'></div>");

		} else {
	%>
	
	    <div class="container">

      <form class="form-signin" action="<%=rootPath %>/user/userinfo.jsp">
        <h2 class="form-signin-heading">Log In</h2>
        <label for="inputEmail" class="sr-only">ID</label>
        <input type="text" name="id" class="form-control" placeholder="ID" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="pwd"class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
		<input type="button" id="signin" name="signin" value="Sign In" onclick="signin()"/>
	</form>
	 </div> <!-- /container -->
	<%
		}
	%>
</body>

</html>