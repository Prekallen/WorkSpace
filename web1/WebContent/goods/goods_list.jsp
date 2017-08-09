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
	var goodsList = results;
    $('#table').bootstrapTable('destroy');
    $('#table').bootstrapTable({
        data: goodsList
    });
}
function setEvent(){
	$("ul[class='pagination']>li:not([class='disabled'])>a").click(function(){
		var pageNum = new Number (this.innerHTML);
		var params = {}
		if(isNaN(pageNum)){
			switch(this.innerHTML){
				case "≪" : nowPage=1;
				break;
				case "＜" : nowPage-= blockCnt;
				break;
				case "＞" : nowPage+= blockCnt;
				break;
				case "≫" : nowPage = totalPageCnt;
				break;
				default: nowPage=1;
			}
		}else{
			nowPage=pageNum;
		}
		if(nowPage<=0){
			nowPage=1;
		}else if(nowPage>totalPageCnt){
			nowPage=totalPageCnt;
		}
		var params={};
		params["nowPage"]= nowPage+"";
		goPage(params, "/test/vendors_select.jsp", callback);
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