<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<script>
function callback(result){
	alert(result.length);
}
$(document).ready(function(){
	$("input[type='button']").click(function(){
		var au= new AjaxUtil("goods/list");
		au.setCallbackSuccess(callback);
		au.send();
	})
})
</script>

<br><br><p><br><p><br>
<form action="${rootPath}/goods/list" method="post">
<input type="button" value="전송"/>
</form>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>