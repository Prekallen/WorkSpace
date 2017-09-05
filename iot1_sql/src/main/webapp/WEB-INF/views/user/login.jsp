<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/common/header.jsp" %>

	<div class="container">

      <form class="form-signin" >
        <h2 class="form-signin-heading" >Log in</h2>
        <label for="inputId" >ID</label>
        <input type="text" id="userId" name="id" class="form-control"  placeholder="ID" required value="${userId}">
        <label for="inputPassword">Password</label>
        <input type="password" id="userPwd" name="pwd" class="form-control"  placeholder="Password" required>
        <div class="checkbox">
 		<label>
        	<input type="checkbox" value="1" id="saveId" ${saveId}> Remember me
		</label>
        </div>
        <button id="LogInBtn" class="btn btn-lg btn-primary btn-block" type="button">Log in</button>
      </form>

    </div> <!-- /container -->

<script>
$("#LogInBtn").click(function(){
	var paramIds = "userId,userPwd";
	var au = new AjaxUtil("/user/login",paramIds);
	au.send();
})
</script>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>