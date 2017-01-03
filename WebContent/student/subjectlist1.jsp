<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>

<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath }/static/css/jquery-ui.min.css" />
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath }/static/css/ui.jqgrid.css" />
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath }/static/css/ui.jqgrid-bootstrap-ui.css" />
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath }/static/css/ui.jqgrid-bootstrap.css" />
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath }/static/css/jquery-ui.structure.min.css" />
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath }/static/css/jquery-ui.theme.min.css" />
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath }/static/css/searchFilter.css" />
<script src="${pageContext.request.contextPath }/static/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath }/static/js/jquery.jqGrid.min.js"></script>
<script src="${pageContext.request.contextPath }/static/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath }/static/js/jquery.searchFilter.js"></script>
<script type="text/javascript">
$(function(){
	$("#examSubListTable").jqGrid({
	url:'/OES/student/listSubject',
	datatype:"json", // local or json
	mtype:"post",
	colNames:['科目名称', '说明', '题数', '总时间',  '总分', '考试状态', '是否已做'],
	colModel:[{
		name: 'examSubjectName',
		index: 'examSubjectName',
		width: 55,
		editable: false
		},{
			name: 'examSubjectDescription',
			index: 'examSubjectDescription',
			width:100,
			editable: true,
			editoptions:{
				size:10
			}
		},
			{
				name: 'examSubjectTnumber',
				index: 'examSubjectTnumber',
				width: 100,
				editable: true,
				editoptions:{
					size:10
				}
			},{
				name: 'examSubjectTotaltime',
				index: 'examSubjectTotaltime',
				width: 150,
				editable: true,
				//edittype:"select",
				editoptions:{
					
				}
			},
			{
				name: 'examSubjectSum',
				index: 'examSubjectSum',
				width: 100,
				editoptions:{
					size:10
				}
			},
			{
				name: 'examSubjectFlag',
				index: 'examSubjectFlag',
				width: 100,
				editable: true,
				editoptions:{
					
				},
				formatter:function(cellvalue,options,rowObject){
					if(cellvalue==1){
						return "开启";
					}else{
						return "关闭";
					}					
				}
			},
			{
				name: 'examSubjectDone',
				index: 'examSubjectDone',
				width: 100,
				editable: true,
				editoptions:{
					size:10
				},
			formatter:function(cellvalue,options,rowObject){
				if(cellvalue==1){
					return "已做";
				}else if(cellvalue==0){
					return "未做";
				}					
			}
			}
		],
		loadonce:false,
		sortorder:"desc",
		caption:"科目一览表",
		rowNum:10,
		loadComplete:function(){
			$(".ui-jqgrid-titlebar-close").hide();
		}	
});

});
</script>


</head>
<body style="text-align: center;">		
	
	<table id="examSubListTable"></table>
	<div id="examSubListTablePager"></div>
</body>
</html>