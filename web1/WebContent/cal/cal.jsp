<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Calculator</title>
</head>
<script src="/js/jquery-3.2.1.js"></script>

<body>
<input type="text" id="num1_1"/>
＋
<input type="text" id="num1_2"/>
<input type="button" value="출력" id="cal1"/>
<input type="text" id="result1"/><br/>

<input type="text" id="num2_1"/>
－
<input type="text" id="num2_2"/>
<input type="button" value="출력" id="cal2"/>
<input type="text" id="result2"/><br/>

<input type="text" id="num3_1"/>
×
<input type="text" id="num3_2"/>
<input type="button" value="출력" id="cal3"/>
<input type="text" id="result3"/><br/>

<input type="text" id="num4_1"/>
÷
<input type="text" id="num4_2"/>
<input type="button" value="출력" id="cal4"/>
<input type="text" id="result4"/><br/>

<input type="button" value="목록" id="list"/><p/>

<div id= "cal_civ"></div>
</body>
<script>
var ops = ["","+","-","*","/"];
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
	    	    	$("#result" + idx).val(result.num); 
	    	    	
	    	    }
	    	    ,   error : function(xhr, status, e) {
	    		    	alert("에러 : "+e);
	    		},
	    		done : function(e) {
	    		}
	    		};
	$.ajax(a);
});
$("#list").click(function(){
	var param = {};
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
	    	    	$("#cal_div").html(result.calnum); 
	    	    	
	    	    }
	    	    ,   error : function(xhr, status, e) {
	    		    	alert("에러 : "+e);
	    		},
	    		done : function(e) {
	    		}
	    		};
	$.ajax(a);
});
</script>
</html>