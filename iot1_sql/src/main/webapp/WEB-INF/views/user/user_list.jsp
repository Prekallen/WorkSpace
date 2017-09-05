<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/common/header.jsp" %>

<div class="container">
	<h2 class="form-signin-heading" style="text-align:center">리스트</h2>
	<input type="text" id="searchName" /><button id="searchBtn"  type="button">찾기</button><p/>
		<table id="table" data-height="460"
			class="table table-bordered table-hover">
			<thead>
				<tr>
					<th data-field="userId" class="text-center">아이디</th>
					<th data-field="userName" class="text-center">이름</th>
					<th data-field="userAge" class="text-center">나이</th>
					<th data-field="userAddress" class="text-center">주소</th>
					<th data-field="departNum" class="text-center">권한레벨</th>
					<th data-field="gender" class="text-center">성별</th>
				</tr>
			</thead>
			<tbody id="result_tbody" >
			</tbody>	
			</table>
		<p/>
		<button id="userInsertBtn" class="btn btn-lg btn-primary " type="button">회원등록</button>
</div>

<script>
function searchName(){
	
	var param={};
	var userName = $("#searchName").val();
	param["userName"]= userName;
		param=JSON.stringify(param);
		$.ajax({ 
	        type     : "POST"
	    ,   url      : "${rootPath}/user/user_list"
	    ,   dataType : "json" 
	    ,   beforeSend: function(xhr) {
	        xhr.setRequestHeader("Accept", "application/json");
	        xhr.setRequestHeader("Content-Type", "application/json");
	    }
	    ,   data     : param
	    ,   success : function(result){
	    	var userList = result.userList;
	    	var resultList="";
	    	var max = userList.length;
	    	for(var i=0; i<max;i++){
	    		user=userList[i]
	    		resultList += "<tr style='cursor:pointer'>";
	    		resultList += "<td class='text-center'>" + user.userId + "</td>";
	    		resultList += "<td class='text-center'>" + user.userName + "</td>";
	    		resultList += "<td class='text-center'>" + user.age + "</td>";
	    		resultList += "<td class='text-center'>" + user.address + "</td>";	
	    		resultList += "<td class='text-center'>" + user.userRoleLevel + "</td>";
	    		resultList += "<td class='text-center'>" + user.gender + "</td>";
	    		resultList += "</tr>";
	    	}
	    	$("#result_tbody").html(resultList);
	    }
	    ,   error : function(xhr, status, e) {
		    	alert("에러 : "+e);
		},
		done : function(e) {
		}
	})
}
$(document).ready(searchName);
$(document).ready(function(){
	$("#searchBtn").click(function(){
		if($("#searchName").val().trim()==""){
			alert("검색할 이름을 입력해주세요.");
			$("#searchName").val("");
			$("#searchName").focus();
			return;
		}
		searchName();
	})
})
$("#userInsertBtn").click(function(){
	location.href="${rootPath}/user/user_info"
})
</script>
<%@ include file = "/WEB-INF/views/common/footer.jsp" %>