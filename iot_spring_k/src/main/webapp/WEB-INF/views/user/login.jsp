<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ page import="java.sql.*"%>
	 
	     <div class="container">

      <form class="form-signin" >
        <h2 class="form-signin-heading" >Log in</h2>
        <label for="inputId" >ID</label>
        <input type="text" id="id" name="id" class="form-control"  placeholder="ID" required autofocus>
        <label for="inputPassword">Password</label>
        <input type="password" id="pwd" name="pwd" class="form-control"  placeholder="Password" required>
        <div class="checkbox">
 		<label>
        	<input type="checkbox" value="remember-me"> Remember me
		</label>
        </div>
        <button id="LogInBtn" class="btn btn-lg btn-primary btn-block" type="button">Log in</button>
      </form>

    </div> <!-- /container -->

<script>
$("#LogInBtn").click(function(){
	var userId = $("#id").val();
	var userPwd = $("#pwd").val();
	var param = {};
	param["userId"] = userId;
	param["userPwd"] = userPwd;
	param = JSON.stringify(param);
	$.ajax({ 
        type     : "POST"
    ,   url      : "${pageContext.request.contextPath}/user/login"
    ,   dataType : "json" 
    ,   beforeSend: function(xhr) {
        xhr.setRequestHeader("Accept", "application/json");
        xhr.setRequestHeader("Content-Type", "application/json");
    }
    ,   data     : param
    ,   success : function(result){
    	alert(result.msg);
    	if(result.data=="S"){
    	location.href="${pageContext.request.contextPath}"+result.url;
    	}else{
    		$("#id").val("");
    		$("#pwd").val("");
    	}
    	
    }
    ,   error : function(xhr, status, e) {
    		$("#error").html(xhr.responseText);
	    	alert("에러 : "+e);
	},
	done : function(e) {
	}
	});
});
</script>	
<div id="error"></div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>