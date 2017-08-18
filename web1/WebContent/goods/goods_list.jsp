<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
	<div class="container" style="padding-left: 120px; padding-bottom: 15px;";>
		<select id="s_vendor" style="width:150px; height:30px;">
			<option value="">회사 선택</option>
		</select>
	상품명 :  <input type="text" id="searchName"/><input type="button" id="searchBtn" value="찾기"/>
	</div>

	<div class="container" style="width:70%">
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
		<button id="vendorViewBtn" class="btn" size="30px" type="button">회사관리</button>
		<button id="insertBtn" class="btn" size="30px" type="button">글작성</button>
	</div>
	<div class="jb-center" style="text-align:center">
		<ul class="pagination" id="page">
		</ul>
	</div>

</body>
<script>
var nowPage="<%=request.getParameter("nowPage")%>";
var blockCnt=0;
var startBloc=0;
var endBlock=0;
var totalPageCnt=0;
var pageInfo={};

if(nowPage=="null"){
	nowPage = "1";
}
$("#searchBtn").click(function(){
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
$("#insertBtn").click(function(){
	location.href="/goods/goods_insert.jsp";
})
$("#vendorViewBtn").click(function(){
	location.href="/vendor/vendor_list.jsp";
})
function callback(results){
	var goodsList = results.list ;
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
	$("#s_vendor").html(selStr);
	var params = {};
	if(search.viNum!=0){
		params["viNum"] = search.viNum;
	}
	if(search.giName){
		params["giName"] = search.giName;
	}
	
	var tableStr="";
	makePagination(pageInfo, "page")
	setEvent(pageInfo,params, "/list.goods");
    $('#table').bootstrapTable('destroy');
	//data: goodsList
  	for(var i=0, max=goodsList.length;i<max;i++){
  		var goods = goodsList[i]
   		tableStr +="<tr data-view='" + goods.giNum + "'>";
   		tableStr += "<td class='text-center'>" + goods.giNum + "</td>";
   	    tableStr += "<td class='text-center'>" + goods.giName + "</td>";
  	    tableStr += "<td class='text-center'>" + goods.giDesc + "</td>";	
   	   	tableStr += "<td class='text-center'>" + goods.viNum + "</td>";
   	   	tableStr += "<td class='text-center'>" + goods.viName + "</td>";
   	   	tableStr += "</tr>";
   	}
   	
   	$("#result_tbody").html(tableStr);
    $("tbody[id='result_tbody']>tr[data-view]").click(function(){
    	var params = {};
    	params["giNum"] = this.getAttribute("data-view");
    	params["command"] = "view";
    	var page = {};
    	page["nowPage"] = pageInfo.nowPage;
    	params["page"]= page;
    	movePageWithAjax(params,"/list.goods",callBackView);		
    })
 function callBackView(result){
    	var url = result.url + "?nowPage=" + result.page.nowPage + "&giNum=" + result.goods.giNum;
    	url += "&giName=" + result.goods.giName;
    	url += "&giDesc=" + result.goods.giDesc;
    	url += "&viNum=" + result.goods.viNum;
    	url += "&viName=" + result.goods.viName;
		location.href=url;
 	}
}		

$(document).ready(function(){
	var page={};
	page["nowPage"]=nowPage;
	var params = {};
	params["page"] = page;
	params["command"] = "list";
	movePageWithAjax(params, "/list.goods", callback);
})

</script>

<%@ include file="/common/footer.jsp"%>