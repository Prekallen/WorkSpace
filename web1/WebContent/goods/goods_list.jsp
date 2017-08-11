<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
	<div class="container" style="align:center">
		<select id="s_vendor">
			<option value="">회사 선택</option>
		</select>
	상품명 :  <input type="text" id="searchName"/><input type="button" id="btn" value="찾기"/>
	</div>

	<div class="container">
		<table id="table" data-height="460"
			class="table table-bordered table-hover">
			<thead>
				<tr>
					<th data-field="giNum" class="text-center">상품번호</th>
					<th data-field="giName" class="text-center">상품이름</th>
					<th data-field="giDesc" class="text-center">상품설명</th>
					<th data-field="viNum" class="text-center">생산자번호</th>
					<th data-field="viName" class="text-center">생산자이름</th>
				</tr>
			</thead>
			<tbody id="result_tbody" >
			</tbody>
		</table>
	</div>
	<div class="jb-center" style="text-align:center">
		<ul class="pagination" id="page">
		</ul>
	</div>

</body>
<script>
var nowPage=0;
var blockCnt=0;
var startBloc=0;
var endBlock=0;
var totalPageCnt=0;
var pageInfo={};
$("#btn").click(function(){
	var giName = $("#searchName").val().trim();
	var viNum = $("#s_vendor").val().trim();
	if(giName=="" && viNum==""){
		alert("회사 선택이나 제품명을 입력해주세요.");
		return;
	}
	var params = {};
	if(giName!=""){
		params["giName"] = giName;
	}
	if(viNum!=""){
		params["viNum"] = viNum;
	}
	params["command"] = "list";
	var page={};
	page["nowPage"]="1";
	params["page"]=page;
	movePageWithAjax(params, "/list.goods", callback);
})

function callback(results){
	var goodsList = results.list ;
	var barList = results.bList ;
	var page = results.page;
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
	$("#s_vendor").html(selStr);
	var params = {};
	if(search.viNum!=0){
		params["viNum"] = search.viNum;
	}
	if(search.giName){
		params["giName"] = search.giName;
	}
	
	makePagination(page, "page")
	setEvent(page,params, "/list.goods");
    $('#table').bootstrapTable('destroy');
    $('#table').bootstrapTable({
        data: goodsList
    });
    
}

$(document).ready(function(){
	var page={};
	page["nowPage"]="1";
	var params = {};
	params["page"] = page;
	params["command"] = "list";
	movePageWithAjax(params, "/list.goods", callback);
});

</script>

<%@ include file="/common/footer.jsp"%>