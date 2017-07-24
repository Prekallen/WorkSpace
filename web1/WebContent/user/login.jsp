<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.UserInfo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자네 프로인가?</title>
</head>
<script>

	function logout() {
		location.href = "/user/userinfo.jsp";
	}
	function bSelect(){
		document.getElementById("bd_div").innerHTML="";
		var nameStr = "command";
		var lengthStr = "100";
		var typeStr = "s"
		var params = "?";
		var au = new AjaxUtil(params);
		au.changeCallBack(function() {
					if (au.xhr.readyState == 4) {
						if (au.xhr.status == 200) {
							var result = decodeURIComponent(au.xhr.responseText);
							var rows = result.split("(-:");
							var tdEnables = rows[1].split(")-:");
							var tableStr = "<table border='1'>";
							for (var i = 0; i < rows.length; i++) {
								if (i == 1) {
									continue;
								}
								tableStr += "<tr>";
								var columns = rows[i].split(")-:");
								var userNum;
								for (var j = 0; j < columns.length; j++) {
									if (j == 0) {
										userNum = columns[j];
									}
									if (i == 0) {
										tableStr += "<td>" + columns[j]
												+ "</td>"
									} else {
										if (tdEnables[j] == "en") {
											tableStr += "<td><input type='text' id= 'r"+userNum+j+"' value='" + columns[j] + "'/></td>"
										} else {
											tableStr += "<td>" + columns[j]
													+ "</td>"
										}
									}
								}
								if (i == 0) {
									tableStr += "<td>삭제</td>";
									tableStr += "<td>수정</td>";
								} else {
									tableStr += "<td><input type='button' value='삭제' onclick='doDelete("
											+ userNum + ")'/></td>";
									tableStr += "<td><input type='button' value='수정' onclick='doUpdate("
											+ userNum + ")'/></td>";
								}
								tableStr += "</tr>";
							}
							if (rows.length == 1) {
								tableStr += "<tr><td colspan='3'>검색목록이 없음</td></tr>"
							}
							tableStr += "</table>";
							document.getElementById("bd_div").innerHTML += tableStr;

						} else {
							document.getElementById("bd_div").innerHTML += xhr.responseText;
						}
					}
				});
		au.send();
	}
	}
</script>
<body>
	<%
		String userId = (String) session.getAttribute("userid");
	
		if (userId != null) {
			String userName = (String) session.getAttribute("username");
			int age = (int) session.getAttribute("age");
			String address = (String) session.getAttribute("address");
			String hp1 = (String) session.getAttribute("hp1");
			String hp2 = (String) session.getAttribute("hp2");
			String hp3 = (String) session.getAttribute("hp3");
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
			out.println("<input type='button' value='로그아웃' onclick='logout()'/><p/>");
			out.println("<input type='button' value='게시판보기' onclick='bSelect()/><br/>");
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