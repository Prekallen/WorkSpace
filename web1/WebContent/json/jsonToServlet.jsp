<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "/common/header.jsp" %>

<body>
<script>
var testParam ={};
testParam["giNum"]="1";
testParam["giName"]="상품";
testParam["giDesc"]="상품설명";
testParam["viNum"]="1";
testParam["viName"]="회사";

function callback(results){
		alert(result.giDesc)
		
}
goPage([testParam], "/test.goods",callback)
</script>
</body>
</html>