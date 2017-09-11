<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.UserInfo"%>
<div class="container" style="width:70%">
		<table id="table" data-height="460" class="table table-bordered table-hover">
		<thead>		
			<tr> 
				<th colspan = "7" class="text-center"><h5 class="form-signin-heading">회사 상세 페이지</h5></th>
			</tr>
			<tr>
				<td >회사번호</td>
				<td >회사명</td>
				<td >회사설명</td>
				<td >회사주소</td>
				<td >회사전화번호</td>
				<td >회사등록일</td>
				<td >회사등록시간</td>
			</tr>
			</thead>
			<tbody>
				<tr>
					<td ><%=request.getParameter("viNum") %></td>
					<td ><%=request.getParameter("viName") %></td>
					<td ><%=request.getParameter("viDesc") %></td>
					<td ><%=request.getParameter("viAddress") %></td>
					<td ><%=request.getParameter("viPhone") %></td>
					<td ><%=request.getParameter("viCreDat") %></td>
					<td ><%=request.getParameter("viCreTim") %></td>
				</tr>
			</tbody>
		</table>			
		<button id="deleteBtn" class="btn btn-md-2 btn-primary" 	style="width:100px" type="button">삭제</button>
		<button  id="updateBtn" class="btn btn-md-2 btn-primary "  style="width:100px"  type="button">수정</button>
		<button id="returnList" class="btn btn-md-2 btn-primary "  style="width:100px"	type="button">리스트 이동</button>
	</div>
	<!-- /container -->
<script>
$("#returnList").click(function(){
	location.href = "/vendor/vendor_list.jsp";
})
$("#deleteBtn").click(function(){
	var viNum = <%=request.getParameter("viNum") %>;
	var isDelete = confirm("해당회사를 삭제 하시겠습니까?");
	if(isDelete){
			var params = "command=delete&viNum=" + viNum;
		$.ajax({
				type	: "POST"
			,	url		: "/list.vendor"
			,	dataType : "text"
			,	data 	: params
			,	success : function(result){
				alert(result);
				location.href="/vendor/vendor_list.jsp";
			}
			,	error : function(xhr, status, e){
					alert("에러 : " + e);	
			}
			,	complete : function(){
			}
		});
	}
})
$("#updateBtn").click(function(){
	var viNum = <%=request.getParameter("viNum") %>;
	location.href = "/vendor/vendor_update.jsp?viNum=" + viNum + "&viName=" + '<%=request.getParameter("viName") %>'
		+ "&viDesc=" + '<%=request.getParameter("viDesc") %>' + "&viAddress=" +'<%=request.getParameter("viAddress") %>' 
		+ "&viPhone=" + '<%=request.getParameter("viPhone") %>';
		
})
</script>
<%@ include file="/common/footer.jsp"%>