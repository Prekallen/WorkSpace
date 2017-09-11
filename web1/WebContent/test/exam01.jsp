<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>

var AjaxUtil = function(p_url,params){
	this.params = params;


	var getHttpXmlObj=function(){
		//해당브라우져가 익스플로러 7.0 이상이거나 파이어폭스, 크롭 등일경우
		if(window.XMLHttpRequest){
			return new XMLHttpRequest();
		}else if(window.ActiveXObject){
			//해당 브라우져가 익스플로러 6.0 이하일경우
			return new ActiveXObject("Microsoft.XMLHTTP");
		}
		//해당 브라우져가 듣보잡일경우.. 어떤 브라우져 인진 나도 모름.
		alert("해당 브라우져가  Ajax를 지원하지 않습니다.");
	}
	this.xhr = getHttpXmlObj();
	var method = "get";
	var url = p_url;
	var aSync = true;
	this.xhr.onreadystatechange=function(){
   		if (this.readyState==4){
   			if(this.status==200){
	   			var result = decodeURIComponent(this.responseText);
	   			document.getElementById("test_div").innerHTML=result;
   			}
   		}
	}
	this.changeCallBack = function(func){
		this.xhr.onreadystatechange = func;
	}
   	this.xhr.open(method, url+this.params, aSync);
   	this.send = function(){
   		this.xhr.send.arguments = this;
   	   	this.xhr.send();
   	}
}  	
function doCheckValue(){	
	var name1 = document.getElementById("id").value;
	var name2 = document.getElementById("name").value;
	var name3 = document.getElementById("age").value;
	var name4 = document.getElementById("address").value;
	var name5 = document.getElementById("address2").value;
	var name6 = document.getElementById("hp1").value;
	var name7 = document.getElementById("hp2").value;
	var name8 = document.getElementById("hp3").value;
	var name9 = document.getElementById("zipcode").value;
	var name10 = document.getElementById("password").value;
	
	var params = "?";
			params += "id="+name1+"&";
			params += "name="+name2+"&";
			params += "age="+name3+"&";
			params += "address="+name4+"&";
			params += "address2="+name5+"&";
			params += "hp1="+name6+"&";
			params += "hp2="+name7+"&";
			params += "hp3="+name8+"&";
			params += "zipcode="+name9+"&";
			params += "password="+name10+"&";
			var au = new AjaxUtil("/test/exam01_ok.jsp",params);
			au.send();
	
}
function rsbt(){
	location.href="/test/exam01.jsp"
}

</script>
<body>
<form action="exam01_ok.jsp">
<table border ="1" align="center">
<tr>
<th>ID</th><td><input type="text" id="id" name="id"/></td>
</tr>
<tr>
<th>Name</th><td><input type="text" id="name" name="name"/></td>
</tr>
<tr>
<th>Age</th><td><input type="text" id="age" name="age"/></td>
</tr>
<tr>
<th>Address</th><td><input type="text" id="address" name="address"/></td>
</tr>
<tr>
<th>Address2</th><td><input type="text" id="address2" name="address2"/></td>
</tr>
<tr>
<th>hp1</th><td><input type="text" id="hp1" name="hp1"/></td>
</tr>
<tr>
<th>hp2</th><td><input type="text" id="hp2" name="hp2"/></td>
</tr>
<tr>
<th>hp1</th><td><input type="text" id="hp3" name="hp3"/></td>
</tr>
<tr>
<th>Zipcode</th><td><input type="text" id="zipcode" name="zipcode"/></td>
</tr>
<tr>
<th>Password</th><td><input type="text" id="password" name="password"/></td>
</tr>
<tr>
<td style="width:50%;"><input type="reset" onclick="rsbt()" style="width:100%;"/></td>
<td style="width:50%;"><input type="button" value="값 확인" onclick="doCheckValue()" style="width:100%;"/></td>
</tr>
</table>
</form>
<div id= test_div></div>
</body>
</html>