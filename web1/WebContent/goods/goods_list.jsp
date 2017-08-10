<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>

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
<select id="s_vendor">
	<option value="">회사 선택</option>
</select>
찾을 회사 <input type="text" id="giname"/><input type="button" id="btn" value="찾기"/>
</body>
<script>
var nowPage=0;
var blockCnt=0;
var startBloc=0;
var endBlock=0;
var totalPageCnt=0;
function callback(results){
	var goodsList = results.list ;
	var barList = results.bList ;
	var page = results.page;
	
	setPagination(page, "page")
	$("#s_vendor").html("");
	
	for(var i=0, max=barList.length;i<max;i++){
		$("#s_vendor").append("<option value='" + barList[i].vinum + "'>" + barList[i].viName + "</option>")
	}
    $('#table').bootstrapTable('destroy');
    $('#table').bootstrapTable({
        data: goodsList
    });
    setEvent(page);
}
function setEvent(pageInfo){
	$("ul[class='pagination']>li:not([class='disabled'])>a").click(function(){
		var pageNum = new Number (this.innerHTML);
		var thisNowPage = pageInfo.nowPage;
		if(isNaN(pageNum)){
			if(this.innerHTML=="＜"){
				thisNowPage -= pageInfo.blockCnt;
			}else if(this.innerHTML=="≪"){
				thisNowPage = 1;
			}else if(this.innerHTML=="＞"){
				thisNowPage += pageInfo.blockCnt;
			}else if(this.innerHTML=="≫"){
				thisNowPage = pageInfo.totalPageCnt;
			}
			if(thisNowPage<=0){
				thisNowPage = 1;
			}else if(thisNowPage>pageInfo.totalPageCnt){
				thisNowPage = pageInfo.totalPageCnt;
			}
			pageNum = thisNowPage;
		}
		
		var page={};
		page["nowPage"]= pageNum+"";
		var params = {}
		params["page"] = page;
		params["command"] = "list";
		goPage(params, "/list.goods", callback);
	})
};
$(document).ready(function(){
	var page={};
	page["nowPage"]="1";
	var params = {};
	params["page"] = page;
	params["command"] = "list";
	goPage(params, "/list.goods", callback);
});


</script>

<%@ include file="/common/footer.jsp"%>