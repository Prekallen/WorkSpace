<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.UserInfo"%>
<div class="container" style="width:25%">
		<table id="table" data-height="460" class="table table-bordered table-hover">
		<thead>		
			<tr> 
				<th colspan = "2" class="text-center"><h5 class="form-signin-heading">상품 등록 페이지</h5></th>
			</tr>
			<tr>
				<td >상품이름</td>
				<td ><input id="giName"/></td>
			</tr>
			<tr>
				<td >상품설명</td>
				<td ><input id="giDesc" /></td>
			</tr>
			<tr>
				<td >생산자이름</td>
				<td>
				<select id="bar_List" style="width:150px; height:30px;">
			<option >회사 선택</option>
				</select>
				</td>
			</tr>
		</table>			
		<button  id="insertList" class="btn btn-md-2 btn-primary"  style="width:100px" type="button">입력</button>
		<button id="returnList" class="btn btn-md-2 btn-primary"  style="width:100px" type="button">리스트 이동</button>
			

	</div>
<!-- /container -->
<script>
$(document).ready(function(){
	var params={};
	params["command"]="barList";
	movePageWithAjax(params, "/list.goods", callback);
})
function callback(result){
	var barList = result.bList;
	var selStr = "<option value=''>회사선택</option>";
	for (var i = 0, max = barList.length; i < max; i++) {
		var bar = barList[i];
		selStr += "<option value='" + bar.viNum + "'>" + bar.viName + "</option>";
	}
	$("#bar_List").html(selStr);

}

$("#insertList").click(function(){
	var giName = $("#giName").val().trim();
	var giDesc = $("#giDesc").val().trim();
	var viNum = $("#bar_List").val().trim();
	if(giName==""){
		alert("상품명을 입력하세요.");
		return;
	}
	if(giDesc==""){
		alert("상품설명을 입력하세요.");
		return;
	}
	if(viNum==""){
		alert("회사를 선택해주세요.");
		return;
	}
	
	var isInsert = confirm("정보를 입력하시겠습니까?");
	if(isInsert){
		var params={};
		params["command"]="insert";
		params["giName"]=$("#giName").val();
		params["giDesc"]=$("#giDesc").val();
		params["viNum"]=$("#bar_List").val();
		movePageWithAjax(params, "/list.goods", callbackInsert);
	}
})

function callbackInsert(result){
		alert(result.msg);
		location.href = result.url;
}

$("#returnList").click(function(){
	location.href = "/goods/goods_list.jsp?nowPage=" + <%=request.getParameter("nowPage")%>
})

</script>
<%@ include file="/common/footer.jsp"%>