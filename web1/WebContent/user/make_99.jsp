<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>99</title>
</head>
<body>

<%
String id = (String) session.getAttribute("id");
if(id!=null){
	out.println(id + "님 환영해요~");
}
out.println("<font size='10' color='red'>돈을 받아야 프로지!!!<p/></font>");
String guCnt = request.getParameter("gucnt");
String result="";
if(guCnt!=(null)){
	result +=(guCnt + "X" + guCnt + "단을 생성할게요<br/>");
	int maxNum= Integer.parseInt(guCnt);

	result+="<table border='1'>";
	for(int i=1; i<=maxNum; i++){
		result+= "<tr>";
		for(int j=1; j<=maxNum; j++){
			result+= "<td>" + i + "X" + j + "=" + i*j + "</td>";
		}
		result+= "</tr>";
	}
	result+="</table>";
}else{
	result="";
}

out.print(result);
%>

<form action="/user/make_99.jsp">
	구구단 생성 갯수 : <input type="text" name="gucnt" /></br>
	<input type="submit" value="CREATE"/>
</form>
</body>
</html>