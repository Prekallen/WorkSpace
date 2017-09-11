<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<c:url value="/user/list" var="readUrl" />
<c:url value="/user/update" var="updateUrl" />
<c:url value="/user/delete" var="deleteUrl" />
<c:url value="/user/create" var="createUrl" />
<br>
<br>
<p>
	<br>
<p>
	<br>
	<kendo:grid title="그리드" name="grid" pageable="true" sortable="true"
		scrollable="false" height="450">
		<kendo:grid-editable mode="incell" />
			<kendo:grid-toolbar>
				<kendo:grid-toolbarItem name="create" text="생성" />
				<kendo:grid-toolbarItem name="cancel" text="취소" />
				<kendo:grid-toolbarItem name="save" text="저장" />
			</kendo:grid-toolbar>
			
			<kendo:grid-columns>
				<kendo:grid-column title="아이디" field="userId" />
				<kendo:grid-column title="비밀번호" field="userPwd" />
				<kendo:grid-column title="이름" field="userName" />
				<kendo:grid-column title="나이" field="age" />
				<kendo:grid-column title="주소" field="address" />
					
					<kendo:grid-column-group title="전화번호" >
					<kendo:grid-column-group-columns>
						<kendo:grid-column title="hp1" field=" hp1" />
						<kendo:grid-column title="hp2" field=" hp2" />
						<kendo:grid-column title="hp3" field=" hp3" />
					</kendo:grid-column-group-columns>
				</kendo:grid-column-group>
				
				<kendo:grid-column title="유저권한" field="userRoleLevel" />
				<kendo:grid-column title="성별" field="gender" />
			</kendo:grid-columns>
		
			
		<kendo:dataSource pageSize="20">
			<kendo:dataSource-transport>
				<kendo:dataSource-transport-read url="${readUrl}" dataType="json" type="POST" contentType="application/json" />
				<kendo:dataSource-transport-update url="${updateUrl}" dataType="json" type="POST" contentType="application/json" />

				<kendo:dataSource-transport-create url="${createUrl}" dataType="json" type="POST" contentType="application/json" />
				<kendo:dataSource-transport-parameterMap>
                	<script>
                	function parameterMap(options,type) { 
                		if(type==="read"){
                			return JSON.stringify(options);
                		} else {
                			return JSON.stringify(options.models);
                		}
                	}
                	</script>
                </kendo:dataSource-transport-parameterMap>
			</kendo:dataSource-transport>
			
		<kendo:dataSource-schema>
                <kendo:dataSource-schema-model id="userId">
                    <kendo:dataSource-schema-model-fields>
                        <kendo:dataSource-schema-model-field name="userName" type="string">
                            <kendo:dataSource-schema-model-field-validation required="true" />
                        </kendo:dataSource-schema-model-field>
                        <kendo:dataSource-schema-model-field name="age" type="number">
                            <kendo:dataSource-schema-model-field-validation required="true" min="1" max="999" />
                        </kendo:dataSource-schema-model-field>
                        <kendo:dataSource-schema-model-field name="address" type="string">
                            <kendo:dataSource-schema-model-field-validation required="true" />
                        </kendo:dataSource-schema-model-field>
                        <kendo:dataSource-schema-model-field name="hp1" type="number" >
                        <kendo:dataSource-schema-model-field-validation required="true" max="4"/>
                        </kendo:dataSource-schema-model-field>
                        <kendo:dataSource-schema-model-field name="hp2" type="number" >
                        <kendo:dataSource-schema-model-field-validation required="true" max="4"/>
                        </kendo:dataSource-schema-model-field>
                        <kendo:dataSource-schema-model-field name="hp3" type="number" >
                        <kendo:dataSource-schema-model-field-validation required="true" max="4"/>
                        </kendo:dataSource-schema-model-field>
                        <kendo:dataSource-schema-model-field name="userRoleLevel" type="number" >
                        <kendo:dataSource-schema-model-field-validation required="true" max="50"/>
                        </kendo:dataSource-schema-model-field>
                        <kendo:dataSource-schema-model-field name="gender" type="number" >
                        <kendo:dataSource-schema-model-field-validation required="true" max="1"/>
                        </kendo:dataSource-schema-model-field>
                    </kendo:dataSource-schema-model-fields>
                </kendo:dataSource-schema-model>
            </kendo:dataSource-schema>
        </kendo:dataSource>
		
	</kendo:grid>

	<%@ include file="/WEB-INF/views/common/footer.jsp"%>