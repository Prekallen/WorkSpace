<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="container">
	<form class="form-signin" >
		<button id="userMainBtn" class="btn btn-lg btn-primary " type="button">MAIN</button>
		<button id="logOutBtn" class="btn btn-lg btn-primary " type="button">Log Out</button>
	</form>
	<h2 class="form-signin-heading" style="text-align:center">리스트</h2>
	<input type="text" id="searchName" /><button id="searchBtn"  type="button">찾기</button><p/>
		<table id="table" data-height="460"
			class="table table-bordered table-hover">
			<thead>
				<tr>
					<th class="text-center">아이디</th>
					<th class="text-center">이름</th>
					<th class="text-center">나이</th>
					<th class="text-center">주소</th>
					<th class="text-center">권한레벨</th>
					<th class="text-center">성별</th>
				</tr>
			</thead>
			<tbody id="insert_tbody" >
				<tr>
					<td data-field="userId" class="input"/>
					<td data-field="userName" class="input"/>
					<td data-field="userAge" class="input"/>
					<td data-field="userAddress" class="input"/>
					<td data-field="departNum" class="input"/>
					<td data-field="gender" class="input"/>
				</tr>
			</tbody>	
			</table>
		<p/>
		<button id="userInsertBtn" class="btn btn-lg btn-primary " type="button">회원등록</button>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>