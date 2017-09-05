<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<c:url value="/grid/api/read" var="transportReadUrl" />

	 <div class="box wide">
         <div class="box-col">
         <h4>Selection</h4>
         <ul class="options">
             <li>
                 <input type="text" value="0" id="selectRow" class="k-textbox"/>
                 <button class="selectRow k-button">Select row</button>
             </li>
             <li>
                 <button class="clearSelection k-button">Clear selected rows</button>
             </li>
         </ul>
         </div>
         <div class="box-col">
         <h4>Expand / Collapse</h4>
         <ul class="options">
             <li>
                 <input type="text" value="0" id="groupRow" class="k-textbox"/>
                 <button class="toggleGroup k-button">Collapse/Expand group</button>
             </li>
         </ul>
         </div>
     </div>
     
    <kendo:grid name="grid" pageable="true" sortable="true" selectable="multiple row"
    	groupable="true" scrollable="false" height="450">
        <kendo:grid-columns>
            <kendo:grid-column title="Product Name" field="productName" />
            <kendo:grid-column title="Unit Price" field="unitPrice" format="{0:c}" />
            <kendo:grid-column title="Units In Stock" field="unitsInStock" />
        </kendo:grid-columns>
        <kendo:dataSource pageSize="20">             
            <kendo:dataSource-transport>
                <kendo:dataSource-transport-read url="${transportReadUrl}"/>
            </kendo:dataSource-transport>
        </kendo:dataSource>       
   </kendo:grid>       
      
   <script>		
	    $(".clearSelection").click(function () {
	        $("#grid").data("kendoGrid").clearSelection();
	    });
	
		    var selectRow = function (e) {
		        if (e.type != "keypress" || kendo.keys.ENTER == e.keyCode) {
		            var grid = $("#grid").data("kendoGrid"),
		                    rowIndex = $("#selectRow").val(),
		                    row = grid.tbody.find(">tr:not(.k-grouping-row)").eq(rowIndex);
		            grid.select(row);
		        }
		    },
	        toggleGroup = function (e) {
	            if (e.type != "keypress" || kendo.keys.ENTER == e.keyCode) {
	                var grid = $("#grid").data("kendoGrid"),
	                    rowIndex = $("#groupRow").val(),
	                    row = grid.tbody.find(">tr.k-grouping-row").eq(rowIndex);
	
	                if (row.has(".k-i-collapse").length) {
	                    grid.collapseGroup(row);
	                } else {
	                    grid.expandGroup(row);
	                }
	            }
	        };
	
        $(document).ready(function () {
        	alert(1);
		    $(".selectRow").click(selectRow);
		    $("#selectRow").keypress(selectRow);
		
		    $(".toggleGroup").click(toggleGroup);
		    $("#groupRow").keypress(toggleGroup);
        });
	</script>
	