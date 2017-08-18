<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.UserInfo"%>
<div class="container" style="width:60%">
		<table id="table" data-height="460" class="table table-bordered table-hover">
		<thead>		
			<tr> 
				<th colspan = "5" class="text-center"><h5 class="form-signin-heading">수정 페이지</h5></th>
			</tr>
			<tr>
				<td style="text-align:center">회사번호</td>
				<td style="text-align:center">회사명</td>
				<td style="text-align:center">회사설명</td>
				<td style="text-align:center">회사주소</td>
				<td style="text-align:center">회사전화번호</td>
				
			<tr>
				<td ><input id="viNum" disabled value= "<%=request.getParameter("viNum") %>"/></td>
				<td ><input id="viName" value="<%=request.getParameter("viName") %>"/></td>
				<td ><input id="viDesc" value="<%=request.getParameter("viDesc") %>"/></td>
				<td ><input id="viAddress" value="<%=request.getParameter("viAddress") %>"/></td>
				<td ><input id="viPhone" value="<%=request.getParameter("viPhone") %>"/></td>
			</tr>
		</table>
		<button  id="updateVendor" class="btn btn-md-2 btn-primary "  style="width:100px" type="button">수정</button>
		<button  id="returnVendor" class="btn btn-md-2 btn-primary "  style="width:100px" type="button">이전 페이지</button>
		<button id="returnList" class="btn btn-md-2 btn-primary "  style="width:100px"  type="button">리스트 이동</button>
		
	</div>
<!-- /container -->
<script>
$(document).ready(function(){
	$("#viName").on("click", function(){
		$(this).select();
	});
	$("#viDesc").on("click", function(){
		$(this).select();
	});
	$("#viAddress").on("click", function(){
		$(this).select();
	});
	$("#viPhone").on("click", function(){
		$(this).select();
	});
		
})

$("#updateVendor").click(function(){
	var viNum = $("#viNum").val();
	var viName = $("#viName").val().trim();
	var viDesc = $("#viDesc").val().trim();
	var viAddress = $("#viAddress").val().trim();
	var viPhone = $("#viPhone").val().trim();
	if(viName==""){
		alert("회사명을 입력하세요.");
		return;
	}
	if(viDesc==""){
		alert("회사설명을 입력하세요.");
		return;
	}
	if(viAddress==""){
		alert("주소를 입력해주세요.");
		return;
	}
	if(viPhone==""){
		alert("전화번호를 입력해주세요.");
		return;
	}
	
	var isUpdate = confirm("정보를 수정하시겠습니까?");
	if(isUpdate){
		var params = "command=update&viNum=" + viNum;
					 params += "&viName=" + viName;
					 params += "&viDesc=" + viDesc;
					 params += "&viAddress=" + viAddress;
					 params += "&viPhone=" + viPhone;
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
	
$("#returnList").click(function(){
	location.href = "/vendor/vendor_list.jsp";
})
$("#returnVendor").click(function(){
	var viNum = <%=request.getParameter("viNum") %>;
	var params = "command=view&viNum=" + viNum;
	$.ajax({
		type	: "POST"
	,	url		: "/list.vendor"
	,	dataType : "text"
	,	data 	: params
	,	success : function(result){
		var url = "/vendor/vendor_view.jsp";
			url+= result;
		location.href= url;
		
	}
	,	error : function(xhr, status, e){
			alert("에러 : " + e);	
	}
	,	complete : function(){
	}
});
})
</script>
<%@ include file="/common/footer.jsp"%>