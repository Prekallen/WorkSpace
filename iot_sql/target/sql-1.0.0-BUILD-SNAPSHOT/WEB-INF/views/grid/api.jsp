<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/top_menu.jsp"%>
<c:url value="/user/list" var="uReadUrl" />
<c:url value="/user/update" var="uUpdateUrl" />
<c:url value="/user/delete" var="uDeleteUrl" />
<c:url value="/user/create" var="uCreateUrl" />
<title>UserInfo</title>
<div class="empty" style="padding-top:40px;padding-bottom:10px">
	<h3 style="padding-left:20px">유저정보</h3>
</div>
	<kendo:grid title="그리드" name="grid" pageable="true" sortable="true"
		scrollable="false" height="450" selectable="true">
		<kendo:grid-editable mode="inline" />
			<kendo:grid-toolbar>
				<kendo:grid-toolbarItem name="create" text="생성" />
				<kendo:grid-toolbarItem name="cancel" text="취소" />
				<kendo:grid-toolbarItem name="save" text="저장" />
			</kendo:grid-toolbar>
			
			<kendo:grid-columns>
				<kendo:grid-column title="아이디" field="userId" />
				<kendo:grid-column title="비밀번호" field="userPwd" />
				<kendo:grid-column title="이름" field="userName" />
				<kendo:grid-column title="나이" field="age"  />
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
				<kendo:grid-column title="&nbsp;" width="180px" >
			<kendo:grid-column-command>
				<kendo:grid-column-commandItem name="edit" text="변경"/>
				<kendo:grid-column-commandItem name="destroy" text="삭제" />
           	</kendo:grid-column-command>
        </kendo:grid-column>
			</kendo:grid-columns>
			
			
		<kendo:dataSource pageSize="20" batch="true">
			<kendo:dataSource-transport>
				<kendo:dataSource-transport-read url="${uReadUrl}" dataType="json" type="POST" contentType="application/json" />
				<kendo:dataSource-transport-update url="${uUpdateUrl}" dataType="json" type="POST" contentType="application/json" />
				<kendo:dataSource-transport-destroy url="${uDeleteUrl}" dataType="json" type="POST" contentType="application/json" />
				<kendo:dataSource-transport-create url="${uCreateUrl}" dataType="json" type="POST" contentType="application/json" />
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
                        <kendo:dataSource-schema-model-field-validation required="true" max="9"/>
                        </kendo:dataSource-schema-model-field>
                    </kendo:dataSource-schema-model-fields>
                </kendo:dataSource-schema-model>
            </kendo:dataSource-schema>
        </kendo:dataSource>
	</kendo:grid>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>