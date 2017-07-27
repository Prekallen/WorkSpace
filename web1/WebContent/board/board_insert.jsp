<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script src="/js/Ajax.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="<%=rootPath%>/board/boardinfo_insert.jsp">
		<table border="1">
		<tr>
		<th>제목</th>
		<td><input type="text" id="bititle" name="bititle" /></td>
		</tr>
		<tr>
		<th>비밀번호</th>
		<td><input type="password" id="bipwd" name="bipwd" /></td>
		</tr>
		<tr>
		<th>작성자</th>
		<td><input type="text" id="creusr" name="creusr" value="<%=(String) session.getAttribute("username")%>"  /></td>
		</tr>
		<tr>
		<th>내용</th>
		<td><textarea name="bicontent" id="bicontent" style="resize:none;"></textarea></td>
		</tr>
		<tr>
		<td colspan="3" align="center"><input type="submit"  style="width: 100%;" value="올리기" /></td>
		</tr>
		</table>
		<input type="hidden" name="command" id="command" value="INSERT" />
		<p />
		
		<input type="button" value="로그인 페이지 돌아가기" onclick="bSelect('main')" />
		<input type="button" value="게시판" onclick="bSelect('board')" />
	</form>
</html>