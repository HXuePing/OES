<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理考试科目</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/jquery-ui.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/ui.jqgrid.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/js/skin/WdatePicker.css">


<script src="${pageContext.request.contextPath }/static/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/static/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath }/static/js/jquery.jqGrid.min.js"></script>
<!-- 日历插件 -->
<script src="${pageContext.request.contextPath }/static/js/WdatePicker.js"></script>
<script src="${pageContext.request.contextPath }/static/js/calendar.js"></script>
<script src="${pageContext.request.contextPath }/static/js/lang/zh-cn.js"></script>

<!-- 国际化 -->
<script src="${pageContext.request.contextPath }/static/js/grid.locale-cn.js"></script> 
</head>

<body>
      <table id="examSubjectListTable"></table>
	  <div id="examSubjectListTablePager"></div>
	  
	  <script type="text/javascript">
    $(document).ready(function () {
    	
    $("#examSubjectListTable").jqGrid({
    	url:'${pageContext.request.contextPath}/teacher/adminSubject',	
        datatype:"json",
        mtype:"post",
        colNames:['科目ID', '科目名', '科目描述','老师ID','考试时间', '总分','可考', '是否完成'],
        colModel: [
        {
           name: 'examSubjectId',
           index: 'examSubjectId',
           width: 55,
           editable: false,
           editoptions: {
        	   readonly: true,
        	   size: 10
        	   }
        },
    	
        {
            name: 'examSubjectName',
            index: 'examSubjectName',
            width: 55,
            editable: true,//显示编辑框
            editrules:{
				required:true
			},
			editoptions:{
				size:10
			}
         },
         
         {
             name: 'examSubjectDescription',
             index: 'examSubjectDescription',
             width: 55,
             editable: true,
             editrules:{
					required:true
				},
				editoptions:{
					size:10
				}
          },
          {
              name: 'examSubjectTnumber',
              index: 'examSubjectTnumber',
              width: 55,
              editable: true,
              editrules:{
  				required:true
  			},
  			editoptions:{
  				size:10
  			}
          },

          {
              name: 'examSubjectTotaltimeString',
              index: 'examSubjectTotaltimeString',
              width: 55,
              editable: true,
              formatter: 'date',
              formatoptions: {newformat: 'Y-m-d h:m:s' },
              editrules:{
  				required:true
  			},
  			editoptions:{
  			  dataInit:function(el){
  				   $(el).click(function(){
  				    WdatePicker({dateFmt:'yyyy-mm-dd HH:MM:ss'});
  				   })
  				   },
  				size:10
  			}
           },
           
           {
               name: 'examSubjectSum',
               index: 'examSubjectSum',
               width: 55,
               editable: true,
               editrules:{
   				required:true,
   				integer:true
   			},
   			editoptions:{
   				size:10
   			}
            },
            
            {
                name: 'examSubjectFlag',
                index: 'examSubjectFlag',
                width: 55,
                editable: true,
                editrules:{
    				required:true
    			},
    			editoptions:{
    				size:10
    			}
             },
             
             {
                 name: 'examSubjectDone',
                 index: 'examSubjectDone',
                 width: 55,
                 editable: true,
                 editrules:{
     				required:true
     			},
     			editoptions:{
     				size:10
     			}
              }
               ],
               
               rowNum : 10,
               rowList : [ 10, 20, 30 ],
               pager : '#examSubjectListTablePager',
               sortname : 'id',
               viewrecords : true,
               sortorder : "desc",
               caption:"考试科目表",
               loadComplete:function(){
            	   $(".ui-jqgrid-titlebar-close").hide();
               }          
    });
    
    $('#examSubjectListTable').jqGrid('navGrid','#examSubjectListTablePager',{
    	edit:true,
    	add:true,
    	del:true,
    	refresh:false,
    	search:false
    },
    //编辑
    {
    	closeAfterEdit:true,
    	reloadAfterSubmit:true,
    	url:"${pageContext.request.contextPath}/teacher/edit",
    	onclickSubmit:function(params,postdata){
    		var rowId = $('#examSubjectListTable').getGridParam('selrow');
    		var rowData = $('#examSubjectListTable').getRowData(rowId);
    		postdata.examSubjectId = rowData.examSubjectId;
    		return postdata;
    	},
    	afterComplete:function(data,postdata){
    		if(data.responseJSON !== null && data.responseJSON.edit){
    			alert("修改成功");
    		}else{
    			alert("修改失败");
    		}
    	}	
    },
    
    {
		//添加
		closeAfterAdd:true,
		reloadAfterSubmit:true,
		url:"${pageContext.request.contextPath}/teacher/add",
		onclickSubmit:function(params,postdata){
			var rowId = $("#examSubjectListTable").getGridParam('selrow');
			var rowData = $("#examSubjectListTable").getRowData(rowId);
			return postdata;
		},
		afterComplete:function(data,postdata){
			if(data.responseJSON != null && data.responseJSON.add){
				alert("添加成功");
			}else{
				alert("添加失败");
			}
		}
	},
	{
		//删除
		reloadAfterSubmit:true,
		url:"${pageContext.request.contextPath}/teacher/delete",
		onclickSubmit:function(params,postdata){
			var rowId = $("#examSubjectListTable").getGridParam('selrow');
			var rowData = $("#examSubjectListTable").getRowData(rowId);
			postdata.examSubjectId = rowData.examSubjectId;
			return rowData;
		},
		afterComplete:function(data,postdata){
			if(data.responseJSON != null && data.responseJSON.delete1){
				alert("删除成功");
			}else{
				alert("删除失败");
			}
		}
	}
    
    )
    
 }); 
    </script>
</body>

</html>