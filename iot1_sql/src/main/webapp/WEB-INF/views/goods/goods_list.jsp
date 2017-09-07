<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<c:url value="/goods/list" var="readUrl" />
<c:url value="/goods/create" var="createUrl" />
<c:url value="/goods/update" var="updateUrl" />
<c:url value="/goods/delete" var="deleteUrl" />
<script>
// function callback(result){
// 	alert("상품갯수 : " + result.length);
// 	var resultTable="";
// 	resultTable += "<table id='table' data-height='460' class='table table-bordered table-hover'>";
// 	resultTable += "<thead>"
// 	resultTable += "<tr>"
// 	resultTable += 	"<th data-field='giNum' class='text-center'>상품번호</th>"
// 	resultTable += 	"<th data-field='giName' class='text-center'>상품명</th>"
// 	resultTable += 	"<th data-field='giDesc' class='text-center'>상품설명</th>"
// 	resultTable += 	"<th data-field='viNum' class='text-center'>회사번호</th>"
// 	resultTable += 	"<th data-field='giCreDat' class='text-center'>생산날짜</th>"
// 	resultTable += 	"<th data-field='giCreTim' class='text-center'>생산시간</th>"
// 	resultTable += 	"</tr>"
// 	resultTable += 	"</thead>"
// 	resultTable += "<tbody>"
// 	for(var i=0, max=result.length;i<max;i++){
// 		var goods = result[i];
// 		resultTable += "<tr style='cursor:pointer'>";
// 		resultTable += "<td class='text-center'>" + goods.giNum + "</td>";
// 		resultTable += "<td class='text-center'>" + goods.giName + "</td>";
// 		resultTable += "<td class='text-center'>" + goods.giDesc + "</td>";
// 		resultTable += "<td class='text-center'>" + goods.viNum + "</td>";	
// 		resultTable += "<td class='text-center'>" + goods.giCreDat + "</td>";
// 		resultTable += "<td class='text-center'>" + goods.giCreTim + "</td>";
// 		resultTable += "</tr>";
// 	}
// 	resultTable += "</tbody>"
// 	$("#r_div").html(resultTable);
// }
// $(document).ready(function(){
// 	$("#goodsBtn").click(function(){
// 		var au= new AjaxUtil("goods/list");
// 		au.setCallbackSuccess(callback);
// 		au.send();
// 	})
// })
</script>

<br><br><p/><br><p/><br>

	<div class="container">
		<button id="goVendorBtn" class="btn btn-lg btn-primary " type="button" align="middle">회사목록가기</button>
	</div>
<br><br><p/><br><p/><br>
<script>

$("#goVendorBtn").click(function(){
	pageMove("vendor/vendor_list")
})
</script>
<div class="container" id="r_div"></div>

<kendo:grid title="그리드" name="grid" pageable="true" sortable="true" scrollable="true" height="530">
	<kendo:grid-editable mode="incell"/>
	<kendo:grid-toolbar>
		<kendo:grid-toolbarItem name="create" text="생성"/>
		<kendo:grid-toolbarItem name="save" text="저장" />
		<kendo:grid-toolbarItem name="update" text="변경"/>
	</kendo:grid-toolbar>
<kendo:grid-columns>
		<kendo:grid-column title="상품번호" field="giNum" editable="false"/>
		<kendo:grid-column title="상품명" field="giName" />
		<kendo:grid-column title="상품설명" field="giDesc" />
		<kendo:grid-column title="회사번호" field="viNum" />
		<kendo:grid-column title="작성일" field="giCreDat" />
		<kendo:grid-column title="작성시간" field="giCreTim" />
		<kendo:grid-column title="&nbsp;" width="200px" >
			<kendo:grid-column-command>
           		<kendo:grid-column-commandItem name="destroy" />
            </kendo:grid-column-command>
        </kendo:grid-column>
	</kendo:grid-columns>
	<kendo:dataSource pageSize="10" batch="true">
		<kendo:dataSource-transport>
			<kendo:dataSource-transport-read url="${readUrl}" dataType="json" type="POST" contentType="application/json" />
			<kendo:dataSource-transport-create url="${createUrl}" dataType="json" type="POST" contentType="application/json" />
			<kendo:dataSource-transport-update url="${updateUrl}" dataType="json" type="POST" contentType="application/json" />
			<kendo:dataSource-transport-destroy url="${deleteUrl}" dataType="json" type="POST" contentType="application/json" />
			<kendo:dataSource-transport-parameterMap>
				<script>
				function parameterMap(options,type){
					if(type=="read"){
						return JSON.stringify(options);
					}else{
						return JSON.stringify(options.models);
					}
				}
				
				</script>
			</kendo:dataSource-transport-parameterMap>
		</kendo:dataSource-transport>
		
		<kendo:dataSource-schema>
			<kendo:dataSource-schema-model id="giNum" >
				<kendo:dataSource-schema-model-fields>
					<kendo:dataSource-schema-model-field name="giName" type="string">
						<kendo:dataSource-schema-model-field-validation required="true"/>
					</kendo:dataSource-schema-model-field>
					<kendo:dataSource-schema-model-field name="viNum" type="number">
						<kendo:dataSource-schema-model-field-validation required="true" min="1"/>
					</kendo:dataSource-schema-model-field>
				</kendo:dataSource-schema-model-fields>
			</kendo:dataSource-schema-model>
		</kendo:dataSource-schema>
		
	</kendo:dataSource>
</kendo:grid>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>