<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.UserInfo"%>
<div class="container" style="width:50%">
		<table id="table" data-height="460" class="table table-bordered table-hover">
		<thead>		
			<tr> 
				<th colspan = "4" class="text-center"><h5 class="form-signin-heading">회사 등록 페이지</h5></th>
			</tr>
			<tr>
				<td style="text-align:center">회사명</td>
				<td style="text-align:center">회사설명</td>
				<td style="text-align:center">회사주소</td>
				<td style="text-align:center">회사전화번호</td>
			</tr>
			<tr>
				<td ><input id="viName"/></td>
				<td ><input id="viDesc"/></td>
				<td ><input id="viAddress"/></td>
				<td ><input id="viPhone"/></td>
			</tr>
		</table>	
	<button  id="insertBtn" class="btn btn-md-2 btn-primary"  style="width:100px" type="button">등록</button>
	<button id="returnList" class="btn btn-md-2 btn-primary"  style="width:100px" type="button">리스트 이동</button>
</div>
<!-- /container -->
<script>
$(document).ready(function(){
	
})

$("#insertBtn").click(function(){
	var viName = $("#viName").val().trim();
	var viDesc = $("#viDesc").val().trim();
	var viAddress = $("#viAddress").val().trim();
	var viPhone = $("#viPhone").val().trim();
	if(viName==""){
		alert("회사명을 입력하세요.");
		return;
	}
	if(viDesc==""){
		alert("회사 설명을 입력하세요.");
		return;
	}
	if(viAddress==""){
		alert("주소를 선택해주세요.");
		return;
	}
	if(viPhone==""){
		alert("전화번호를 입력해주세요.");
		return;
	}
	var isInsert = confirm("정보를 입력하시겠습니까?");
	if(isInsert){
			var params = "command=insert&viName=" + viName;
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
	location.href = "/vendor/vendor_list.jsp"
})

</script>
