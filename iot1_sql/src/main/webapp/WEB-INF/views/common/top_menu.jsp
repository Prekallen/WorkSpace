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
          <a class="navbar-brand" id="main" style="cursor:pointer;">WHAT</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a id="board" style="cursor:pointer;">게시판가기</a></li>
            <li><a id="userList" style="cursor:pointer;">유저정보가기</a></li>
            <li><a href="${rootPath}/user/user_info">권한정보가기</a></li>
            <li><a id="logOut" style="cursor:pointer;">로그아웃</a></li>
          </ul>
          
        </div><!--/.nav-collapse -->
      </div>
</nav>
<script>
$("#main").click(function(){
	pageMove("user/main");
})
$("#board").click(function(){
	pageMove("goods/goods_list")
})
$("#userList").click(function(){
	pageMove("grid/api");
})
$("#logOut").click(function(){
	pageMove("user/logout");
})

</script>
<br><br><p/><br>