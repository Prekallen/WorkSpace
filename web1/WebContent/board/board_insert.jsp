<%@ include file="/common/header.jsp"%>
<%@ include file="/common/footer.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script src="/js/Ajax.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">




	
	<form method="get" action="<%=rootPath%>/board/boardinfo_insert.jsp">
		<div class="container">
			<div class="starter-template">
				<table class='table table-bordered table-hover' align="center" style="width:60%;">
					<tr>
						<th style="text-align: center;">제목</th>
						<td><input type="text" style="width: 100%;" id="bititle" name="bititle" /></td>
					</tr>
					<tr>
						<th style="text-align: center;">비밀번호</th>
						<td><input type="password" style="width: 100%;" id="bipwd" name="bipwd" /></td>
					</tr>
					<tr>
						<th style="text-align: center;">작성자</th>
						<td><input type="text" style="width: 100%;" id="creusr" name="creusr" value="<%=(String) session.getAttribute("username")%>" /></td>
					</tr>
					<tr>
						<th style="text-align: center;">내용</th>
						<td><textarea  name="bicontent" id="bicontent" style="resize:none;width: 100%;height:200px;" ></textarea></td>
					</tr>
					<tr>
						<td colspan="3" align="center"><input type="submit" style="width: 35%;" value="올리기" /></td>
					</tr>
				</table>
				<input type="hidden" name="command" id="command" value="INSERT" />
				<p />

				<input type="button" value="메인으로 가기" onclick="bSelect('main')" />
			</div>
		</div>
	</form>

