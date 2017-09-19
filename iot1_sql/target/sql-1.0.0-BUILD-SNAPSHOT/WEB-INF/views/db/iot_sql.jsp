<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ page session="false" %> 
<c:set var="dbTreeJsp" value="/WEB-INF/views/db/db_treeview.jsp" />
<c:set var="tableInfoJsp" value="/WEB-INF/views/db/tableinfo.jsp" />
<c:set var="tabJsp" value="/WEB-INF/views/db/tab.jsp" />
<c:url var="tableInfoUrl" value="/db/table/info" />
<title>IOT SQL</title>
</head>
<script>
var treeview;

function onBound(){
	if(!treeview){
		treeview = $('#treeview').data('kendoTreeView');
	}
}
$(document).ready(function(){
	$( "#query" ).keydown(function(e) {
		var keyCode = e.keyCode || e.which;
		if(keyCode==120){
			var sql;
			var sqls;
			if(e.ctrlKey && keyCode==120 && e.shiftKey){
				sql = this.value;
				var cursor = this.selectionStart;
				var startSql = sql.substr(0,cursor);
				var startSap = startSql.lastIndexOf(";")
				startSql = startSql.substr(startSap+1);
				var endSql = sql.substr(cursor);
				var endSap = endSql.indexOf(";");
				if(endSap==-1) {
					endSap=sql.length;
				}
				endSql = endSql.substr(0,endSap);
				sql = startSql + endSql;
			}else if(e.ctrlKey && keyCode==120){
				sql = this.value.substr(this.selectionStart, this.selectionEnd - this.selectionStart);
			}else if(keyCode==120){
				sql = this.value;
			}
			if(sql){
				sql = sql.trim();
				sqls = sql.split(";");
				sqls = sqls.filter(function(e){return e});
				if(sqls.length==1){
					var au = new AjaxUtil("db/run/sql");
					var param = {};
					param["sql"] = sql;
					au.param = JSON.stringify(param);
					au.setCallbackSuccess(callbackSql);
					au.send();
					return;
				}else if(sqls.length>1){
					var au = new AjaxUtil("db/run/sqls");
					var param={};
					param["sql"] = sqls;
					au.param = JSON.stringify(param);
					au.setCallbackSuccess(callbackSql);
					au.send();
					return;
				}
			}
			
		}
	});
})

function callbackSql(result){
	var state=result.state;
	if(result.error){
		alert(result.error);
		$("#stateLog").append(result.error);
		$("#stateLog").append("<br/>");
		$("#stateLog").append(state);
		$("#stateLog").append("<br/>");
		return;
	}
	var key = result.key;
	var obj = result[key];
	var list = obj.list;
	var sql = obj.sql;
	var sqls = obj.sqls;
	if(key){
		if(sql){
		$("#stateLog").append(sql);
		$("#stateLog").append("<br/>");
		}
		if(sqls){
			for(var i = 0; i<sqls.length; i++){
				$("#stateLog").append(sqls[i]);
				$("#stateLog").append("<br/>");
			}
		}
		$("#stateLog").append(state);
		$("#stateLog").append("<br/>");
	}
	
	try{
		$("#resultGrid").kendoGrid("destroy").empty();
	}catch(e){
		
	}
	var grid = $("#resultGrid").kendoGrid({
  		dataSource: {
  	      data: list,
  	      pageSize: 5
  	    },
  	    editable: false,
  	    sortable: true,
  	    pageable:true	    
	});
}

function treeSelect(){
	window.selectedNode = treeview.select();
	var data = treeview.dataItem(window.selectedNode);
	if(data.database && !data.hasChildren){
	      var au = new AjaxUtil("db/table/list");
	      var param = {};
	      param["database"] = data.database;
	      au.param = JSON.stringify(param);
	      au.setCallbackSuccess(callbackForTreeItem2);
	      au.send();
	}else if(data.tableName){
		var ki = new KendoItem(treeview, $("#tableInfoGrid"), "${tableInfoUrl}","tableName");
		ki.send();
	}
}

function callbackForTreeItem2(result){
	if(result.error){
		alert(result.error);
		return;
	}
	for(var i=0, max=result.tableList.length;i<max;i++){
		var table = result.tableList[i];
		treeview.append({
			tableName: table.tableName
        }, treeview.select());
	}
	$("#btnConnect").text("접속해제");
}

function callbackForTreeItem(result){
	if(result.error){
		alert(result.error);
		return;
	}
	for(var i=0, max=result.databaseList.length;i<max;i++){
		var database = result.databaseList[i];
		treeview.append({
			database: database.database
        }, treeview.select());
	}
	$("#btnConnect").text("접속해제");
}

function toolbarEvent(e){
	if($("#btnConnect").text()=="접속해제"){
		treeview.dataSource.read();
		$("#btnConnect").text("접속");
		return;
	}
	var data = treeview.dataItem(window.selectedNode);
	if(data && data.diNum){
		//$('#treeview>.k-group>.k-item>.k-group').remove();
		//treeview.dataSource.read();
		var au = new AjaxUtil("db/connect");
		var param = {};
		param["diNum"] = data.diNum;
		au.param = JSON.stringify(param);
		au.setCallbackSuccess(callbackForTreeItem);
		au.send();
	}else{
		alert("접속하실 데이터베이스를 선택해주세요");
	}
}

</script>
<body>
<c:import url="${menuUrl}"/> 
<kendo:splitter name="vertical" orientation="vertical" style="height: 800px;">
    <kendo:splitter-panes>
        <kendo:splitter-pane id="top-pane" collapsible="false">
            <kendo:splitter-pane-content>
                <kendo:splitter name="horizontal" style="height: 100%; width: 100%;">
				    <kendo:splitter-panes>
				        <kendo:splitter-pane id="left-pane" collapsible="true" size="220px">
				            <kendo:splitter-pane-content >
				                <div class="pane-content">
					                <c:import url="${dbTreeJsp}"/>
                                </div>
				            </kendo:splitter-pane-content>
				        </kendo:splitter-pane>
				        <kendo:splitter-pane id="center-pane" collapsible="false">
				            <kendo:splitter-pane-content>
								<kendo:splitter name="vertical1" orientation="vertical" style="height: 100%; width: 100%;">
				   					<kendo:splitter-panes>
		       							<kendo:splitter-pane id="top-pane" collapsible="false" >
		       								<c:import url="${tabJsp}"/>
		       							</kendo:splitter-pane>
		       							
		       							<kendo:splitter-pane id="middle-pane" collapsible="true" >
							                <div class="pane-content">
						                		<div id="resultGrid" style="width: 100%;"></div>
			                                </div>
		       							</kendo:splitter-pane>
		       							
	       							</kendo:splitter-panes>
       							</kendo:splitter>
				            </kendo:splitter-pane-content>
				        </kendo:splitter-pane>
				    </kendo:splitter-panes>
				</kendo:splitter>
            </kendo:splitter-pane-content>
        </kendo:splitter-pane>
        <kendo:splitter-pane id="middle-pane" collapsible="false" size="25%">
            <kendo:splitter-pane-content>
                <div class="pane-content" >
                	<dive id="stateLog" />
	            </div>
            </kendo:splitter-pane-content>
        </kendo:splitter-pane>
        <kendo:splitter-pane id="bottom-pane" collapsible="false" resizable="false" size="20px" scrollable="false">
            <kendo:splitter-pane-content>
	                <b>MySql Tool For Web</b>
            </kendo:splitter-pane-content>
        </kendo:splitter-pane>
    </kendo:splitter-panes>
</kendo:splitter>
</body>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>