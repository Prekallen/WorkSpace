<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/js/jquery-3.2.1.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>Get Parameter 방식</p>
<form action="test.formtest" method="get">
	ID : <input type="text" name="id"/><br/>
	PW : <input type="text" name="pwd"/><br/>
	<input type="submit" value="전송"/>
</form>
<p>Post Json 방식</p>
<form action="test.formtest" method="post" id="testForm">
	ID : <input type="text" id="id"/><br/>
	PW : <input type="text" id="pwd"/><br/>
	<input type="button" value="전송" onclick="postTest()"/>
</form>
<div id="out"></div>
</body>
<script>

function postTest(){
	var params={};
	params["id"]=$("#id").val();
	params["pwd"]=$("#pwd").val();
	params = JSON.stringify(params);
	
/*	$("#testForm").serializeArray();
	params = JSON.stringify(params);
	alert(params);	*/
	$.ajax({ 
		type     : "POST"
    ,   url      : "/test.formtest"
    ,   dataType : "json" 
    ,   beforeSend: function(xhr) {
        xhr.setRequestHeader("Accept", "application/json");
        xhr.setRequestHeader("Content-Type", "application/json");
    }
    ,   data     : params
    ,   success : function(result){
    	$("#out").html("");
    		$("#out").append("POST방식으로 받아온 id는" + result[0] + "이고 pwd는" + result[1] + "입니다.");
    }
    ,   error : function(xhr, status, e) {
	    	alert("에러 : "+e);
	},
	complete  : function() {
	}
});
	
	
}
</script>
</html>