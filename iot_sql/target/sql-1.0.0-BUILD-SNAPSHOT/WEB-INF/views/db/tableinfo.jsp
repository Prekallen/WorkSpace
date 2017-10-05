<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<c:url value="/goods/list" var="bReadUrl" />
<c:url value="/goods/create" var="bCreateUrl" />
<c:url value="/goods/update" var="bUpdateUrl" />
<c:url value="/goods/delete" var="bDeleteUrl" />
<style>
		.k-link, tr {
             text-align : center;
         }
</style>
<kendo:grid title="상품그리드" name="gGrid" selectable="multiple" pageable="true" sortable="true" scrollable="true" height="460">
	<kendo:grid-editable mode="incell"/>
	<kendo:grid-toolbar>
		<kendo:grid-toolbarItem name="create" text="생성"/>
		<kendo:grid-toolbarItem name="save" text="저장" />
		<kendo:grid-toolbarItem name="edit" text="변경"/>
		<kendo:grid-toolbarItem name="destroy" text="삭제" />
		<kendo:grid-toolbarItem name="cancel" text="취소"/>

	</kendo:grid-toolbar>
<kendo:grid-columns>
		<kendo:grid-column title="상품번호" field="giNum" editable="false"/>
		<kendo:grid-column title="상품명" field="giName" />
		<kendo:grid-column title="상품설명" field="giDesc" />
		<kendo:grid-column title="회사번호" field="viNum" />
		<kendo:grid-column title="작성일" field="giCreDat" />
		<kendo:grid-column title="작성시간" field="giCreTim" />
	</kendo:grid-columns>
	<kendo:dataSource pageSize="10" batch="true">
		<kendo:dataSource-transport>
			<kendo:dataSource-transport-read url="${bReadUrl}" dataType="json" type="POST" contentType="application/json" />
			<kendo:dataSource-transport-create url="${bCreateUrl}" dataType="json" type="POST" contentType="application/json" />
			<kendo:dataSource-transport-update url="${bUpdateUrl}" dataType="json" type="POST" contentType="application/json" />
			<kendo:dataSource-transport-destroy url="${bDeleteUrl}" dataType="json" type="POST" contentType="application/json" />
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
