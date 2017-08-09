<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>예뻐해주세요.</title>
</head>
<%!
public void printStr(String str){
	System.out.println("WoW");
}
%>
<%
	String userId = (String) session.getAttribute("userid");
	String userName = "";
	int age = 0;
	String address = "";
	String hp1 = "";
	String hp2 = "";
	String hp3 = "";
	boolean signin=false;
	boolean login = false;
	if (userId != null) {
		userName = (String) session.getAttribute("username");
		age = (int) session.getAttribute("age");
		address = (String) session.getAttribute("address");
		hp1 = (String) session.getAttribute("hp1");
		hp2 = (String) session.getAttribute("hp2");
		hp3 = (String) session.getAttribute("hp3");
		login = true;
	}
	String rootPath = request.getContextPath();
	Date toDate = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	String toDateStr = sdf.format(toDate);
	String init = request.getParameter("init");
	String defaultUrl = "";

		if(init==null&&!login){
			defaultUrl = rootPath + "/user/login.jsp?init=2";
			response.sendRedirect(defaultUrl);
		} 
	String nowUrl=request.getRequestURI();

String version = "1.2.2";
%>

<script src="<%=rootPath%>/js/jquery-3.2.1.js?version=<%=version%>"></script>
<script src="<%=rootPath%>/ui/btsp3.7.7/js/bootstrap.min.js?version=<%=version%>"></script>
<script src="<%=rootPath%>/ui/btsp3.7.7/js/bootstrap-table.js?version=<%=version%>"></script>
<link rel="stylesheet" href="<%=rootPath%>/ui/btsp3.7.7/css/bootstrap-theme.min.css?version=<%=version%>"/>
<link rel="stylesheet" href="<%=rootPath%>/ui/btsp3.7.7/css/bootstrap.min.css?version=<%=version%>"/>
<link rel="stylesheet" href="<%=rootPath%>/ui/btsp3.7.7/css/bootstrap-table.css?version=<%=version%>"/>
<link rel="stylesheet" href="<%=rootPath%>/ui/common.css?version=<%=version%>"/>
<link rel="stylesheet" href="<%=rootPath%>/ui/footer.css?version=<%=version%>"/>

<script>
var rootPath="<%=rootPath%>";
var url="";
function bSelect(pageId) {
	
	if(pageId=="board"){
		url= rootPath + "/board/board_select.jsp"
		location.href = url;
	}else if(pageId=="main"){
		location.href = rootPath + "/main.jsp";
	}else if(pageId=="insert"){
		url=rootPath +"/board/board_insert.jsp"
		location.href = url;
	}else{
	location.href= url;
	}
}
Number.prototype.equals = function(obj){
	if(obj instanceof Number){
		return this.toString() == obj.toString();
	}
	return this==obj;
}

function setPagination(sNum,eNum,nPage,nTotal, objId){
	var pageStr=""; 
	if(nPage==1){
		pageStr = "<li class='disabled'><a>≪</a></li>";
		pageStr+= "<li class='disabled'><a>＜</a></li>";
	}else{
	pageStr = "<li><a>≪</a></li>";
	pageStr+= "<li><a>＜</a></li>";
	}
	for(var i=sNum, max=eNum;i<=max;i++){
		if(i==nPage){
			pageStr +="<li class='active'><a>" + i + "</a></li>";		
		}else{
			pageStr+= "<li><a>" + i + "</a></li>";	
		}
	}
	
	if(nPage.equals(nTotal)){
		pageStr+= "<li class='disabled'><a>＞</a></li>";
		pageStr+= "<li class='disabled'><a>≫</a></li>";
	}else{
	pageStr+= "<li><a>＞</a></li>";
	pageStr+= "<li><a>≫</a></li>";
	}
	$("#"+objId).html(pageStr);
}
$(document).ready(function(){
	var nowUrl = "<%=nowUrl%>";
	$("a[href='" + nowUrl + "']").parent().attr("class","active");
});
function goPage(pParams, pUrl, pCallBackFunc){
	var params = JSON.stringify(pParams);
	$.ajax({ 
    		type     : "POST"
	    ,   url      : pUrl
	    ,   dataType : "json" 
	    ,   beforeSend: function(xhr) {
	        xhr.setRequestHeader("Accept", "application/json");
	        xhr.setRequestHeader("Content-Type", "application/json");
	    }
	    ,   data     : params
	    ,   success : pCallBackFunc
	    ,   error : function(xhr, status, e) {
		    	alert("에러 : "+e);
		},
		complete  : function() {
		}
	});
}

</script>
<%

String loginStr = "로그인";
if(login){
	loginStr="로그아웃";
}

%>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/main.jsp" style="color:red;">CHOCOLATE</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="/board/board_select.jsp">게시판가기</a></li>
            <li><a href="/user/user_info.jsp">유저정보가기</a></li>
            <li><a href="/role/role_select.jsp">권한정보가기</a></li>
            <li><a href="/user/logout.jsp"><%=loginStr %></a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
