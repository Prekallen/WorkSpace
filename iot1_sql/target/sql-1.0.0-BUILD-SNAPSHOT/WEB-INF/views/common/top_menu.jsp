<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" id="main" style="cursor:pointer;"></a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a id="board" style="cursor:pointer;">게시판가기</a></li>
            <li><a id="userList" style="cursor:pointer;">유저정보가기</a></li>
            <li><a id="querySQL" style="cursor:pointer;">QUERY</a></li>
            <li><a id="logOut" style="cursor:pointer;"></a></li>
          </ul>
          
        </div><!--/.nav-collapse -->
      </div>
</nav>
<script>
var user = "${user}";
var userId = "${user.userId}";

$("#main").click(function(){
	if(userId!=null&&userId){
		pageMove("user/main");
	}else{
		pageMove("user/login");
	}
})
$("#board").click(function(){
	if(userId!=null&&userId){
		pageMove("goods/goods_list")
	}else{
		pageMove("user/login");
	}
})
$("#userList").click(function(){
	if(userId!=null&&userId){
		pageMove("grid/api");
	}else{
		pageMove("user/login");
	}
})
$("#querySQL").click(function(){
	if(userId!=null&&userId){
		pageMove("db/iot_sql");
	}else{
		pageMove("user/login");
	}
})

if(userId!=null&&userId){
	$("#logOut").html("로그아웃");
}else{
	$("#logOut").html("로그인");
}
$("#logOut").click(function(){
	if(userId!=null&&userId){
		pageMove("user/logout");
	}else{
		pageMove("user/login");
	}	
})
</script>
<br><br><p/><br>