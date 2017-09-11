<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.UserInfo"%>

<link rel="stylesheet" href="<%=rootPath %>/ui/signin.css">

	 
	     <div class="container">

      <form class="form-signin" action="<%=rootPath %>/user/userinfo.jsp" >
        <h2 class="form-signin-heading">Log in</h2>
        <label for="inputId" >ID</label>
        <input type="text" id="id" name="id" class="form-control" placeholder="ID" required autofocus>
        <label for="inputPassword">Password</label>
        <input type="password" id="pwd" name="pwd" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button id="btn2" class="btn btn-lg btn-primary btn-block" type="button">Log in</button>
       
      </form>

    </div> <!-- /container -->

<script>

$("button.btn").click(function(){
	var userId = $("#id").val();
	var userPwd = $("#pwd").val();
	var param = {};
	param["userId"] = userId;
	param["userPwd"] = userPwd;
	param = JSON.stringify(param);
	$.ajax({ 
        type     : "POST"
    ,   url      : "/user/userinfo.jsp"
    ,   dataType : "json" 
    ,   beforeSend: function(xhr) {
        xhr.setRequestHeader("Accept", "application/json");
        xhr.setRequestHeader("Content-Type", "application/json");
    }
    ,   data     : param
    ,   success : function(result){
    	alert(result.msg);
    	if(result.msg=="로그인"){
    	location.href="<%=rootPath%>/main.jsp";
    	}else{
    		$("#userId").val("");
    		$("#userPwd").val("");
    	}
    	
    }
    ,   error : function(xhr, status, e) {
	    	alert("에러 : "+e);
	},
	done : function(e) {
	}
	});
});


</script>	
<%@ include file="/common/footer.jsp"%>
