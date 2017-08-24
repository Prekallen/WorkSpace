<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ page import="java.sql.*"%>


<link rel="stylesheet" href="/ui/signin.css">

	 
	     <div class="container">

      <form class="form-signin" >
        <h2 class="form-signin-heading">Log in</h2>
        <label for="inputId" >ID</label>
        <input type="text" id="id" name="id" class="form-control"  placeholder="ID" required autofocus>
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

</script>	

