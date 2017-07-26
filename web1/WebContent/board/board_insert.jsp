<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script src="/js/Ajax.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="<%=rootPath%>/board/boardinfo_insert.jsp">

		제목<br />
		<input type="text" id="bititle" name="bititle" /><p />
		비밀번호<br /> 
		<input type="password" id="bipwd" name="bipwd" /><p />
		작성자<br /> 
		<input type="text" id="creusr" name="creusr" value="<%=(String) session.getAttribute("userid")%>"  /><p />
		내용<br />
		<textarea name="bicontent" id="bicontent"></textarea><br />
		<input type="hidden" name="command" id="command" value="INSERT" />
		<p />
		<input type="submit" value="게시" /><br />
		<input type="button" value="로그인 페이지 돌아가기" onclick="bSelect('main')" />
		<input type="button" value="게시판" onclick="bSelect('board')" />
	</form>
</html>