<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<c:url value="/goods/list" var="bReadUrl" />
<c:url value="/goods/create" var="bCreateUrl" />
<c:url value="/goods/update" var="bUpdateUrl" />
<c:url value="/goods/delete" var="bDeleteUrl" />
<c:url value="/vendor/combo" var="vendorComboUrl" />
<c:url value="/vendor/list" var="vReadUrl" />
<c:url value="/vendor/create" var="vCreateUrl" />
<c:url value="/vendor/update" var="vUpdateUrl" />
<c:url value="/vendor/delete" var="vDeleteUrl" />
<script>
	$(document).ready(function(){
		if(!"${vendors}"){
			location.href="${vendorComboUrl}";
		}
		
	})

	function onChange(arg){
		var selectViNum = this.dataItem(this.select()).viNum();
			var grid = $('#vGrid').data('kendoGrid');
			var selectedvGrid = grid.dataItem(grid.select());
			var reload = function(options)({
			    transport: {
			        read: {
			            url: "${vReadUrl}",
			            dataType: "json",
			            contentType: 'application/json; charset=utf-8',
			            type: "POST",
				    data: JSON.stringify(selectedvGrid)
			        }
			}
			});
			
			$("#gGrid").data("kendoGrid").dataSource.transport.read=reload;
			$("#gGrid").data("kendoGrid").dataSource.read();
		
	}
</script>
<br><br><p/><br>
<h4 style="padding-left:50px; padding-bottom:5px;bold;">회사목록</h4>
<kendo:grid title="회사그리드" name="vGrid" selectable="multiple" sortable="true" scrollable="true" height="235" dataBound="test" >
	<kendo:grid-editable mode="inline"/>
	<kendo:grid-toolbar>
		<kendo:grid-toolbarItem name="create" text="생성"/>
		<kendo:grid-toolbarItem name="save" text="저장"/>
		<kendo:grid-toolbarItem name="cancel" text="취소"/>
		<kendo:grid-toolbarItem name="vGoods" text="선택한 회사 상품 보기"/>
	</kendo:grid-toolbar>
	<kendo:grid-columns>
		<kendo:grid-column title="회사번호" field="viNum" editable="false"/>
		<kendo:grid-column title="회사명" field="viName" />
		<kendo:grid-column title="회사설명" field="viDesc" />
		<kendo:grid-column title="회사주소" field="viAddress" />
		<kendo:grid-column title="회사전화" field="viPhone" />
		<kendo:grid-column title="작성일" field="viCreDat" />
		<kendo:grid-column title="작성시간" field="viCreTim" />
		<kendo:grid-column title="&nbsp;" width="180px" >
			<kendo:grid-column-command>
				<kendo:grid-column-commandItem name="edit" text="변경"/>
           		<kendo:grid-column-commandItem name="destroy" text="삭제" />
           	</kendo:grid-column-command>
        </kendo:grid-column>
	</kendo:grid-columns>
	<kendo:dataSource batch="true">
		<kendo:dataSource-transport>
			<kendo:dataSource-transport-read url="${vReadUrl}" dataType="json" type="POST" contentType="application/json" />
			<kendo:dataSource-transport-create url="${vCreateUrl}" dataType="json" type="POST" contentType="application/json" />
			<kendo:dataSource-transport-update url="${vUpdateUrl}" dataType="json" type="POST" contentType="application/json" />
			<kendo:dataSource-transport-destroy url="${vDeleteUrl}" dataType="json" type="POST" contentType="application/json" />
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

<h4 style="padding-left:50px; padding-top:5px; padding-bottom:5px;">상품목록</h4>
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
		<kendo:grid-column title="회사번호" field="viNum" >
			<kendo:grid-column-values value="${vendors}"/>
		</kendo:grid-column>
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

<%@ include file="/WEB-INF/views/common/footer.jsp"%>