<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>


<kendo:grid name="tableInfo">
	<kendo:grid-columns>
		<kendo:grid-column title="컬럼명" field="column_name" />
		<kendo:grid-column title="자료형" field="data_type" />
		<kendo:grid-column title="글자수" field="character_maximum_length" />
		<kendo:grid-column title="NULL여부" field="is_nullable" />
	</kendo:grid-columns>
	<kendo:dataSource batch="true">
		<kendo:dataSource-transport>
			<script>
				
			</script>
		</kendo:dataSource-transport>
	</kendo:dataSource>
</kendo:grid>