<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<kendo:tabStrip name="tabStrip">
	<kendo:tabStrip-animation>
		<kendo:tabStrip-animation-open effects="fadeIn"></kendo:tabStrip-animation-open>
	</kendo:tabStrip-animation>
	<kendo:tabStrip-items>
		<kendo:tabStrip-item text="테이블정보" selected="true">
			<kendo:tabStrip-item-content>
				<div class="tableInfo">
					<kendo:grid title="테이블정보" name="tableInfoGrid" sortable="true"
					pageable="false" navigatable="true">
						<kendo:grid-columns>
							<kendo:grid-column title="컬럼명" field="columnName" />
							<kendo:grid-column title="데이터타입" field="dataType" />
							<kendo:grid-column title="길이" field="characterMaximumLength" />
							<kendo:grid-column title="널허용여부" field="isNullable">
							</kendo:grid-column>
						</kendo:grid-columns>
					</kendo:grid>
				</div>
			</kendo:tabStrip-item-content>
		</kendo:tabStrip-item>
		<kendo:tabStrip-item text="쿼리">
			<kendo:tabStrip-item-content>
				<div class="sql">
					<textarea id="query" style="width: 98%;height:80%;overflow: scroll;resize:none;"></textarea>
				</div>
			</kendo:tabStrip-item-content>		
		</kendo:tabStrip-item>
	</kendo:tabStrip-items>
</kendo:tabStrip>