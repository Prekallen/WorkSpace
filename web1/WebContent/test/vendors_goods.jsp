<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sales</title>
</head>

<script src="/js/jquery-3.2.1.js"></script>
<script src="/ui/btsp3.7.7/js/bootstrap.min.js"></script>
<script src="/ui/btsp3.7.7/js/bootstrap-table.js"></script>
<link rel="stylesheet" href="/ui/btsp3.7.7/css/bootstrap-theme.min.css"/>
<link rel="stylesheet" href="/ui/btsp3.7.7/css/bootstrap.min.css"/>
<link rel="stylesheet" href="/ui/btsp3.7.7/css/bootstrap-table.css"/>


<body>
	<div class="container">
		<table id="table" data-height="460"
			class="table table-bordered table-hover">
			<thead style="width:100%">
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
	<select id="s_vendor">
		<option value="">회사 선택</option>
	</select>
	찾을 회사 <input type="text" id="giname"/><input type="button" id="btn" value="찾기"/>
</body>
<script>
$(document).ready(function(){
	
	
	var send = {
			type : "POST",
			url : "/test/vendors_select.jsp",
			dataType : "json",
			beforeSend : function(xhr){
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type", "application/json");
			},
			data : null,
			success : function(result){
				var tableList = result.tableList;
		    	var goodsList = result.goodsList;

		    	for(var i=0, max=tableList.length;i<max;i++){
		    		$("#s_vendor").append("<option value='" + tableList[i].vinum + "'>"+tableList[i].viname +"</option>")
		    	}
		        $('#table').bootstrapTable({
		            data: goodsList
		        });
				
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
</html>