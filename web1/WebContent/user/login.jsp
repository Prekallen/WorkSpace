<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.UserInfo"%>
<script>
	var setObj;
	var loopCnt=0;
	function startTimer() {
		setObj = setInterval(function() {
			if (loopCnt == 3) {
				clearInterval(setObj);
				} else {
				loopCnt++;
				alert("Hello~");
			}
		}, 1000);

	}
	function stopTimer() {
		clearInterval(setObj);
	}
	function bSelect() {

	}
	function logout() {
		location.href = "/user/userinfo.jsp";
	}
	function bSelect() {
		document.getElementById("bd_div").innerHTML = "";
		var nameStr = "command";
		var lengthStr = "100";
		var typeStr = "s"
		var params = "?";
		var au = new AjaxUtil(params);
		au
				.changeCallBack(function() {
					if (au.xhr.readyState == 4) {
						if (au.xhr.status == 200) {
							var result = decodeURIComponent(au.xhr.responseText);

							document.getElementById("bd_div").innerHTML += tableStr;

						} else {
							document.getElementById("bd_div").innerHTML += xhr.responseText;
						}
					}
				});
		au.send();
	}
</script>
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
			out.println("<input type='button' value='게시판보기' onclick='bSelect(\"board\")'/>");
			out.println("<input type='button' value='타이머' onclick='startTimer()'/>");
			out.println("<input type='button' value='멈춤이' onclick='stopTimer()'/>");
			out.println("<div id='bd_div'></div>");

		} else {
	%>
	<form action="/user/userinfo.jsp">
		ID : <input type="text" name="id" /><br /> PWD : <input
			type="password" name="pwd" /><br /> <input type="submit"
			value="Log In" />

	</form>
	<%
		}
	%>
</body>

</html>