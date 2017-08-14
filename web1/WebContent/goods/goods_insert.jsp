<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.UserInfo"%>
<div class="container-view" style="width:35%;" > 
		<table id="table"  data-height="460"	class="table table-bordered table-hover" >
		<thead>		
			<tr> 
				<th colspan = "3" class="text-center"><h5 class="form-signin-heading">수정 페이지</h5></th>
			</tr>
			<tr>
				<td class="col-md-2">상품이름</td>
				<td colspan="2"><input id="giName"/></td>
			</tr>
			<tr>
				<td >상품설명</td>
				<td colspan="2"><input id="giDesc" /></td>
			</tr>
			<tr>
				<td >생산자이름</td>
				<td>
				<select id="bar_List">
			<option >회사 선택</option>
				</select>
				</td>
			</tr>
			<tr>
				<td >
					<button  id="updateList" class="btn btn-md-2 btn-primary btn-block"  style="width:100px" type="button">입력</button>
				</td>
				<td >
					<button id="returnList" class="btn btn-md-2 btn-primary btn-block"  style="width:100px" type="button">리스트 이동</button>
				</td>
			</tr>
		</table>
	</div>
<!-- /container -->
<script>
$(document).ready(function(){
	var params={};
	params["command"]="barList";
	movePageWithAjax(params, "/list.goods", callBack);
})
function callback(result){
	var barList = results.bList ;
	var pageInfo = results.page;
	var search = results.search;
	var selStr = "<option value=''>회사선택</option>";
	for (var i = 0, max = barList.length; i < max; i++) {
		var vendor = barList[i];
		var selectStr = "";
		if(search.viNum==vendor.viNum){
			selectStr = "selected";
		}
		selStr += "<option value='" + vendor.viNum + "' " + selectStr + ">" + vendor.viName
				+ "</option>";
	}
	$("#bar_List").html(selStr);
}
$("#updateList").click(function(){
	var giName = $("#giName").val().trim();
	var giDesc = $("#giDesc").val().trim();
	var viNum = $("#bar_List").val().trim();
	if(giName==""){
		alter("상품명을 입력하세요.");
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
	
	var isUpdate = confirm("정보를 입력하시겠습니까?");
	if(isUpdate){
		var params={};
		params["command"]="insert"
		params["giName"]=$("#giName").value();
		params["giDesc"]=$("#giDesc").val();
		params["viNum"]=$("#bar_List").val();
		var page={};
		page["nowPage"] = "<%=request.getParameter("nowPage")%>";
		params["page"]=page;
		movePageWithAjax(params, "/list.goods", callBackView);
	}
	location.href = "/goods/goods_list.jsp?nowPage=" + <%=request.getParameter("nowPage")%>
})
	
$("#returnList").click(function(){
	location.href = "/goods/goods_list.jsp?nowPage=" + <%=request.getParameter("nowPage")%>
})

</script>
