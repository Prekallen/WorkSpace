<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSON TEST</title>
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
					<th data-field="jTNum"  class="text-center">번호</th>
					<th data-field="jTTest"  class="text-center">테스트</th>
				</tr>
			</thead>
			<tbody id="result_tbody" >
			</tbody>
		</table>
	</div>
	찾을 번호 <input type="text" id="sN"/><input type="button" id="sNB" value="찾기"/>
</body>
<script>
$("#sNB").click(function(){
	var sn = $("#sN").val();
	var param = {};
	param["sN"]=sn;
	param=JSON.stringify(param);
	alert(param); 
	var send={
				type : "POST",
				url : "/test/json_test_select.jsp",
				dataType : "json",
				beforeSend : function(xhr){
					xhr.setRequestHeader("Accept", "application/json");
	    	        xhr.setRequestHeader("Content-Type", "application/json");
	    	    },
	    	    data : param,
	    	    success : function(results){
	    	    	$('#table').bootstrapTable('destroy');
	    	        $('#table').bootstrapTable({
	    	            data : results
	    	        });
	    	    },
	    	    error : function(xhr, status, e) {
			    	alert("에러 : "+e);
				},
				complete : function(e){
				}
			};
	$.ajax(send);	
});
</script>
</html>