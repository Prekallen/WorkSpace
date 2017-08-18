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
				<th colspan = "7" class="text-center"><h5 class="form-signin-heading">회사 관리 페이지</h5></th>
			</tr>
			<tr>
				<td data-field="viNum" class="text-center">회사번호</td>
				<td data-field="viName" class="text-center">회사명</td>
				<td data-field="viDesc" class="text-center">회사설명</td>
				<td data-field="viAddress" class="text-center">회사주소</td>
				<td data-field="viPhone" class="text-center">전화번호</td>
				<td data-field="viCreDat" class="text-center">등록일</td>
				<td data-field="viCreTim" class="text-center">등록시간</td>
			</tr>
			</thead>
				<tbody id="result_tbody" >
			</tbody>	
			</table>
		<button  id="returnList" class="btn btn-primary"  type="button">상품 리스트 이동</button>
		<button id="btnInsert" class="btn btn-primary"  type="button">회사등록</button><p/>
	</div>
	<div  style="padding-top:10px; padding-left:280px;">
		회사명 : <input type="text" id="searchName"/><input type="button" id="searchBtn" value="찾기"/>
	</div>
	<!-- /container -->
<script>
$("#returnList").click(function(){
	location.href = "/goods/goods_list.jsp?nowPage=" + <%=request.getParameter("nowPage")%>;
})
$("#searchBtn").click(function(){
	var viName = $("#searchName").val().trim();
	if(viName==""){
		alert("회사 명을 입력해주세요.");
		return;
	}
	var params = "command=list&viName=" + viName;
	$.ajax({
			type	: "POST"
		,	url		: "/list.vendor"
		,	dataType : "text"
		,	data 	: params
		,	success : function(result){
			$("#result_tbody").html(result);
	    	setTrEvent();
		}
		,	error : function(xhr, status, e){
				alert("에러 : " + e);	
		}
		,	complete : function(){
		}
	});
});
$("#btnInsert").click(function(){
	location.href="/vendor/vendor_insert.jsp"
});

function setTrEvent(){
$("tbody[id='result_tbody']>tr[id]").click(function(){
		var viNum = this.getAttribute("id");
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
});
}
$(document).ready(function() {
		var params = "command=list";
		$.ajax({ 
    		type     : "POST"
	    ,   url      : "/list.vendor"
	    ,   dataType : "text" 
	    ,   data     : params
	    ,   success : function(result){
	    	$("#result_tbody").html(result);
	    	setTrEvent();
	    }
	    ,   error : function(xhr, status, e) {
		    	alert("에러 : "+e);
		},
		complete  : function() {
		}
	});
});
	
</script>
<%@ include file="/common/footer.jsp"%>