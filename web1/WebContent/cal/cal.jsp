<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>


<div class="container">
		<table id="table" data-height="460"
			class="table table-bordered table-hover">
			<thead style="width:100%">
				<tr>
					<th data-field="calnum"  class="text-center">번호</th>
					<th data-field="num1"  class="text-center">숫자1</th>
					<th data-field="num2"  class="text-center">숫자2</th>
					<th data-field="op"  class="text-center">연산자</th>
					<th data-field="result"  class="text-center">결과값</th>
				</tr>
			</thead>
			<tbody id="result_tbody" style="width:100%">
			</tbody>
		</table>
	</div>
연산자 : <input type="text" id="op"/><input type="button" id="getCal" value="계산리스트호출"/>
<div id="result_div" class="container"></div>

<script>
$("#getCal").click(function(){
	var op = $("#op").val();
	var param = {};
	param["op"] = op;
	param = JSON.stringify(param);
	var a = { 
	        type     : "POST"
	    	    ,   url      : "/cal/cal_select.jsp"
	    	    ,   dataType : "json" 
	    	    ,   beforeSend: function(xhr) {
	    	        xhr.setRequestHeader("Accept", "application/json");
	    	        xhr.setRequestHeader("Content-Type", "application/json");
	    	    }
	    	    ,   data     : param
	    	    ,   success : function(result){
		    	        $('#table').bootstrapTable({
		    	            data: result
		    	        });
	    	    }
	    	    ,   error : function(xhr, status, e) {
	    		    	alert("에러 : "+e);
	    		},
	    			complete : function(e) {
	    		}
	    		};
	$.ajax(a);
});

$("input[id*='cal']").click(function(){
	var id = this.id;
	var idx = id.substring(id.length-1);
	var num1 = $("#num"+ idx + "_1").val();
	var num2 = $("#num"+ idx + "_2").val();

	var param = {};
	param["num1"] = num1;
	param["num2"] = num2;
	param["op"] = ops[idx];
	param = JSON.stringify(param);
	var a = { 
	        type     : "POST"
	    	    ,   url      : "/cal/cal_ok.jsp"
	    	    ,   dataType : "json" 
	    	    ,   beforeSend: function(xhr) {
	    	        xhr.setRequestHeader("Accept", "application/json");
	    	        xhr.setRequestHeader("Content-Type", "application/json");
	    	    }
	    	    ,   data     : param
	    	    ,   success : function(result){ 
	    	    	alert(result.insert);
	    	    	$("#result" + idx).val(result.num);  
	    	    }
	    	    ,   error : function(xhr, status, e) {
	    		    	alert("에러 : "+e);
	    		},
	    		done : function(e) {
	    			alert("왜 테이블이 찌그러 지나.......");
	    		}
	    		};
	$.ajax(a);
});
</script>
<%@ include file="/common/footer.jsp"%>