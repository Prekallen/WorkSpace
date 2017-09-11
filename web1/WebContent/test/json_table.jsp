<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Json TABLE</title>
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
					<th data-field="tnum"  class="text-center">번호</th>
					<th data-field="ttitle"  class="text-center">타이틀</th>
					<th data-field="twriter"  class="text-center">작성자</th>
					<th data-field="tcontent"  class="text-center">내용</th>
				</tr>
			</thead>
			<tbody id="result_tbody" >
			</tbody>
		</table>
	</div>
	찾을 번호 <input type="text" id="num"/><input type="button" id="btn" value="찾기"/>
</body>
<script>
$("#btn").click(function(){
	var num = $("#num").val();
	var param = {};
	param["num"] = num;
	param=JSON.stringify(param);
	send={
			type : "POST",
			url : "/test/json_table_select.jsp",
			dataType : "json",
			beforeSend : function(xhr){
				xhr.setRequestHeader("Accept","application/json");
				xhr.setRequestHeader("Content-Type","application/json");
			},
			data : param,
			success : function(result){
				$("#table").bootstrapTable({
					data : result
				})
			},
			error : function(xhr, status, e){
				alert("에러 : "+ e);
			},
			complete : function(){
				alert("믿을건 너하나 뿐이냐....");
			}
	}
	$.ajax(send)
});

</script>
</html>