<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>

	<div class="container">
		<table id="table" data-height="460"
			class="table table-bordered table-hover">
			<thead>
				<tr>
					<th data-field="vinum"  class="text-center">회사번호</th>
					<th data-field="viname"  class="text-center">회사이름</th>
					<th data-field="videsc"  class="text-center">회사소개</th>
					<th data-field="viaddress"  class="text-center">회사주소</th>
					<th data-field="viphone"  class="text-center">회사전화번호</th>
					<th data-field="vicredat"  class="text-center">회사설립일</th>
					<th data-field="vicretim"  class="text-center">회사설립시간</th>
					<th data-field="ginum"  class="text-center">상품번호</th>
					<th data-field="giname"  class="text-center">상품명</th>
					<th data-field="gidesc"  class="text-center">상품소개</th>
					<th data-field="vinum"  class="text-center">회사번호</th>
					<th data-field="gicredat"  class="text-center">상품일자</th>
					<th data-field="gicretim"  class="text-center">상품시간</th>
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
	var tableList = results.tableList;
	var goodsList = results.goodsList;
	var pageInfo = results.pageInfo;			
	
	var pageStr= "<li><a>≪</a></li>";
	pageStr+= "<li><a>＜</a></li>";
	nowPage = new Number(pageInfo.nowPage);
	blockCnt = new Number(pageInfo.blockCnt);
	startBlock = Math.floor((nowPage-1)/blockCnt)*10+1;
	endBlock = startBlock+blockCnt-1;
	totalPageCnt = new Number(pageInfo.totalPageCnt);
	if(endBlock>totalPageCnt){
		endBlock=totalPageCnt
	}
	setPagination(startBlock, endBlock, nowPage, totalPageCnt, "page");
	$("#s_vendor").html("");
	
	for(var i=0, max=tableList.length;i<max;i++){
		$("#s_vendor").append("<option value='" + tableList[i].vinum + "'>"+tableList[i].viname +"</option>")
	}
	$('#table').bootstrapTable('destroy');
	$('#table').bootstrapTable({
		data: goodsList
	});
	setEvent();
	
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
	var params = {};
	params["nowPage"] = "1";
	goPage(params, "/test/vendors_select.jsp", callback);
});

$("#btn").click(function(){
	var giname = $("#giname").val();
	var s_vendor=$("#s_vendor").val()
	var param = {};
	param["giname"] = giname;
	param["s_vendor"] = s_vendor;
	param = JSON.stringify(param);
	var send = {
			type : "POST",
			url : "/test/vendors_goods_select.jsp",
			dataType : "json",
			beforeSend : function(xhr){
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type", "application/json");
			},
			data : param,
			success : function(result){
				$("#table").bootstrapTable('destroy');
				$("#table").bootstrapTable({
					data : result
				})
			},
			error : function(xhr, status, e){
				alert("에러 :" + e);
			},
			complete : function(){
				alert("무조건");
			}
	}
	$.ajax(send);
	
})

</script>

<%@ include file="/common/footer.jsp"%>