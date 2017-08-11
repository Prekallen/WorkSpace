<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/common/header.jsp" %>
<body>
<input type="button" id="btn" value="서블릿 이동"/>
</body>
<script>
$("#btn").click(function(){
	var params = {};
	params["num"]="3.1415926535897932384626433832795028841971";
	params["name"]="아르키메데스";
	params["command"]="Pi"
	params["struct"]={"a":"1","b":"2"}
	params["people"]=[{"name":"철수","age":"12" },{"name":"영희","age":"15" },{"name":"길동","age":"20" }];
	params = JSON.stringify(params);
	
	$.ajax({
			type : "POST"
		,	url : "/list.goods"
		,	dataType : "json"
		,	beforeSend : function(xhr){
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		}
		,	data : params
		,	success : function(result){
			alert(result.people[0].name);
		}
	})
})
</script>
</html>