<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<c:url value="/vendor/list" var="readUrl" />
<c:url value="/vendor/create" var="createUrl" />
<script>
// function callback(result){
// 	alert("회사갯수 : " + result.length);
// 	var resultTable="";
// 	resultTable += "<table id='table' data-height='460' class='table table-bordered table-hover'>";
// 	resultTable += "<thead>"
// 	resultTable += "<tr>"
// 	resultTable += 	"<th data-field='viNum' class='text-center'>회사번호</th>"
// 	resultTable += 	"<th data-field='viName' class='text-center'>회사명</th>"
// 	resultTable += 	"<th data-field='viDesc' class='text-center'>회사설명</th>"
// 	resultTable += 	"<th data-field='viAddress' class='text-center'>회사주소</th>"
// 	resultTable += 	"<th data-field='viPhone' class='text-center'>회사전화</th>"
// 	resultTable += 	"<th data-field='viCreDat' class='text-center'>설립일</th>"
// 	resultTable += 	"<th data-field='viCreTim' class='text-center'>설립시간</th>"
// 	resultTable += 	"</tr>"
// 	resultTable += 	"</thead>"
// 	resultTable += "<tbody>"
// 	for(var i=0, max=result.length;i<max;i++){
// 		var vendor = result[i];
// 		resultTable += "<tr style='cursor:pointer'>";
// 		resultTable += "<td class='text-center'>" + vendor.viNum + "</td>";
// 		resultTable += "<td class='text-center'>" + vendor.viName + "</td>";
// 		resultTable += "<td class='text-center'>" + vendor.viDesc + "</td>";
// 		resultTable += "<td class='text-center'>" + vendor.viAddress + "</td>";
// 		resultTable += "<td class='text-center'>" + vendor.viPhone + "</td>";
// 		resultTable += "<td class='text-center'>" + vendor.viCreDat + "</td>";
// 		resultTable += "<td class='text-center'>" + vendor.viCreTim + "</td>";
// 		resultTable += "</tr>";
// 	}
// 	resultTable += "</tbody>"
// 	$("#r_div").html(resultTable);
// }
// $(document).ready(function(){
// 	$("#vendorBtn").click(function(){
// 		var au= new AjaxUtil("vendor/list");
// 		au.setCallbackSuccess(callback);
// 		au.send();
// 	})
// })
</script>

<br><br><p/><br><p/><br>

  <div class="container">
  	<button id="goGoodsBtn" class="btn btn-lg btn-primary " type="button" align="middle">상품목록가기</button>
  </div>
 <br><br><p/><br><p/><br>
<script>
$("#goGoodsBtn").click(function(){
	pageMove("goods/goods_list")
})
</script>
<div class="container" id="r_div"></div>
<kendo:grid title="그리드" name="grid" pageable="true" sortable="true" scrollable="true" height="530">
	<kendo:grid-editable mode="incell"/>
	<kendo:grid-toolbar>
		<kendo:grid-toolbarItem name="create" text="생성"/>
		<kendo:grid-toolbarItem name="save" text="저장"/>
	</kendo:grid-toolbar>
	<kendo:grid-columns>
		<kendo:grid-column title="회사번호" field="viNum" editable="false"/>
		<kendo:grid-column title="회사명" field="viName" />
		<kendo:grid-column title="회사설명" field="viDesc" />
		<kendo:grid-column title="회사주소" field="viAddress" />
		<kendo:grid-column title="회사전화" field="viPhone" />
		<kendo:grid-column title="작성일" field="viCreDat" />
		<kendo:grid-column title="작성시간" field="viCreTim" />
	</kendo:grid-columns>
	<kendo:dataSource pageSize="14">
		<kendo:dataSource-transport>
			<kendo:dataSource-transport-read url="${readUrl}" dataType="json" type="POST" contentType="application/json" />
			<kendo:dataSource-transport-create url="${createUrl}" dataType="json" type="POST" contentType="application/json" />
			<kendo:dataSource-transport-parameterMap>
				<script>
				function parameterMap(options,type){
					if(type==="read"){
						return JSON.stringify(options);
					}else{
						return JSON.stringify(options.models);
					}
				}
				</script>
			</kendo:dataSource-transport-parameterMap>
		</kendo:dataSource-transport>
		
		<kendo:dataSource-schema>
			<kendo:dataSource-schema-model id="viNum" >
				<kendo:dataSource-schema-model-fields>
					<kendo:dataSource-schema-model-field name="viName" type="string">
						<kendo:dataSource-schema-model-field-validation required="true"/>
					</kendo:dataSource-schema-model-field>
					
				</kendo:dataSource-schema-model-fields>
			</kendo:dataSource-schema-model>
		</kendo:dataSource-schema>

	</kendo:dataSource>
</kendo:grid>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>