<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en"><head>
    <!-- <meta charset="utf-8"> -->
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>教师管理学生信息</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../static/css/bootstrap.css">
    <link rel="stylesheet" href="../static/css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="../static/css/theme.css">
	<link rel="stylesheet" type="text/css" href="../static/css/premium.css">
   	<script src="${pageContext.request.contextPath }/static/js/jquery-2.1.4.min.js"></script>
   	<script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script> 
    <script src="../static/js/jquery.knob.js" type="text/javascript"></script>
    
    <!-- 日期控件                 =====注意js库重复版本的引用会导致一些错误 -->
	
    <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script> 
    <link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
	
	
	<!-- <!-- 处理添加 、修改事件-->
	 <script type="text/javascript">
		function add(){
			var tip = "";
			if($("#examUserName1").val().length>12){
				tip += "姓名--->不能长于12 个字\n\n";
			}
			if( ($("#examUserNumber1").val().length<4) || (($("#examUserNumber1").val().length>10)) ){
				tip += "学号---> 必须为 < 4~10 > 位数\n\n";
			}
			if( ($("#examUserPassword1").val().length<4) || (($("#examUserPassword1").val().length>10)) ){
				tip += "密码---> 必须为 < 4~10 > 位数\n\n";
			}
			if( ($("#examUserBirthday1").val() == "") ){
				tip += "生日---> 必须输入\n\n";
			}
			if($("#examUserTel1").val().length>11){
				tip += "电话--->不能长于11个字\n\n";
			}
			if($("#examUserAddress1").val().length>25){
				tip += "地址--->不能长于25 个字\n\n";
			}
			if( tip != ""){
				alert( tip );
				tip = "";
			}			
			else{
				$("#insertform").submit();
			}
		}
		function change(){
			var tip = "";
			if($("#examUserName").val().length>12){
				tip += "姓名--->不能长于12 个字\n\n";
			}
			if( ($("#examUserNumber").val().length<4) || (($("#examUserNumber").val().length>10)) ){
				tip += "学号---> 必须为 < 4~10 > 位数\n\n";
			}
			if( ($("#examUserPassword").val().length<4) || (($("#examUserPassword").val().length>10)) ){
				tip += "密码---> 必须为 < 4~10 > 位数\n\n";
			}
			if( ($("#examUserBirthday").val() == "") ){
				tip += "生日---> 必须输入\n\n";
			}
			if($("#examUserTel").val().length>11){
				tip += "电话--->不能长于11个字\n\n";
			}
			if($("#examUserAddress").val().length>25){
				tip += "地址--->不能长于25 个字\n\n";
			}
			if( tip != ""){
				alert( tip );
				tip = "";
			}			
			else{
				$("#updateform").submit();
			}
			
		}
	
	</script>
	
	<!-- 处理修改 -->
	<script type="text/javascript">
	$(function(){
		//修改的模态框设置
		$('#changeModal').on('show.bs.modal', function (event) {
			  var button = $(event.relatedTarget) // Button that triggered the modal
			  
			  var id = button.data('id')
			  var name = button.data('name')
			  var number = button.data('number')
			  var password = button.data('password')
			  var teacher = button.data('teacher')
			  var sex = button.data('sex')
			  var birthday = button.data('birthday')
			  var tel = button.data('tel')
			  var address = button.data('address')
			  var done = button.data('done')
			  
			  var modal = $(this)
			  modal.find('.modal-title').text('修改学生 - ' + name + ' - 的个人信息')//设置模态框表头
			  //设置文本框值
			  modal.find(".modal-body input[name='examUserId']").val(id)
			  modal.find(".modal-body input[name='examUserName']").val(name)
			  modal.find(".modal-body input[name='examUserNumber']").val(number)
			  modal.find(".modal-body input[name='examUserPassword']").val(password)
			  modal.find(".modal-body input[name='examUserTeacher']").val(teacher)
			  modal.find(".modal-body select[name='examUserSex']").val(sex)
			  modal.find(".modal-body input[name='examUserBirthday']").val(birthday)
			  modal.find(".modal-body input[name='examUserTel']").val(tel)
			  modal.find(".modal-body input[name='examUserAddress']").val(address)
			  modal.find(".modal-body select[name='examUserDone']").val(done)
			})
			
		 $("#examUserBirthday1").datepicker(); 
		 $("#examUserBirthday").datepicker();  
	});
	</script> 
	
	
	
    <script type="text/javascript">
        $(function() {
            $(".knob").knob();
        });
    </script>
</head>
<body class="theme-blue">
    <script type="text/javascript">
        $(function() {
            var match = document.cookie.match(new RegExp('color=([^;]+)'));
            if(match) var color = match[1];
            if(color) {
                $('body').removeClass(function (index, css) {
                    return (css.match (/\btheme-\S+/g) || []).join(' ')
                })
                $('body').addClass('theme-' + color);
            }

            $('[data-popover="true"]').popover({html: true});
            
        });
    </script>
    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .navbar-default .navbar-brand, .navbar-default .navbar-brand:hover { 
            color: #fff;
        }
    </style>

    <script type="text/javascript">
        $(function() {
            var uls = $('.sidebar-nav > ul > *').clone();
            uls.addClass('visible-xs');
            $('#main-menu').append(uls.clone());
        });
    </script>

    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  
  <!-- 顶部横幅 -->
    <div class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a href="index.html"><span class="navbar-brand"><span class="fa fa-paper-plane"></span> 在线考试系统</span></a></div>

        <div class="navbar-collapse collapse" style="height: 1px;">
          <ul id="main-menu" class="nav navbar-nav navbar-right">
            <li class="dropdown hidden-xs">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-user padding-right-small" style="position:relative;top: 3px;"></span> ${examUser.getExamUserName() }
                    <i class="fa fa-caret-down"></i>
                </a>
              <ul class="dropdown-menu">
                <li><a href="${ pageContext.request.contextPath }/login/info">个人信息</a></li>
                <li class="divider"></li>
                <li><a href="${ pageContext.request.contextPath }/login/logout">退出登录</a></li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
      
      
   
    
	<!-- 侧边栏 -->
    <div class="sidebar-nav">
    <ul>
    <li><a href="${ pageContext.request.contextPath }/login/index" data-target=".dashboard-menu" class="nav-header" data-toggle="collapse"><i class="fa fa-fw fa-dashboard"></i>主页<i class="fa fa-collapse"></i></a></li>
    <li><a href="#" data-target=".dashboard-menu" class="nav-header" data-toggle="collapse"><i class="fa fa-fw fa-dashboard"></i>学生入口<i class="fa fa-collapse"></i></a></li>
    <li><ul class="dashboard-menu nav nav-list collapse in">      
    		<li ><a href="${ pageContext.request.contextPath }/login/index"><span class="fa fa-caret-right"></span>学员进行考试</a></li>      
            <li ><a href="${ pageContext.request.contextPath }/login/index"><span class="fa fa-caret-right"></span>学员查看科目列表</a></li>
            <li ><a href="${ pageContext.request.contextPath }/login/index"><span class="fa fa-caret-right"></span>学员查看成绩</a></li>
    </ul></li>
	<li><a href="#" data-target=".dashboard-menu" class="nav-header" data-toggle="collapse"><i class="fa fa-fw fa-dashboard"></i>教师入口<i class="fa fa-collapse"></i></a></li>
    <li><ul class="dashboard-menu nav nav-list collapse in">
            <li><a href="${ pageContext.request.contextPath }/login/index"><span class="fa fa-caret-right"></span>教师管理考试科目</a></li>
            <li><a href="${ pageContext.request.contextPath }/login/index"><span class="fa fa-caret-right"></span>教师管理考试成绩</a></li>
            <li><a href="${ pageContext.request.contextPath }/login/index"><span class="fa fa-caret-right"></span>教师管理考试题</a></li>
            <li ><a href="${ pageContext.request.contextPath }/stuma/list"><span class="fa fa-caret-right"></span>教师管理学生信息dragon</a></li>
            <li ><a href="${ pageContext.request.contextPath }/file"><span class="fa fa-caret-right"></span>学员资料批量导入dragon</a></li>
    </ul></li>
 </ul>
</div>
  		<!-- 加入内容 -->
    <div class="content">
    
    <br><br>

<!-- 添加的模态框 -->
<div class="modal fade" id="insertModal" tabindex="-1" role="dialog" aria-labelledby="insertModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="insertModalLabel">添加学生信息</h4>
      </div>
      <div class="modal-body">
      
        <form id="insertform" action="${ pageContext.request.contextPath }/stuma/insert" method="post">
          <div class="form-group">
            <label for="examUserId" class="control-label">学生ID:</label>
            <input type="text" class="form-control" id="examUserId1" name="examUserId" placeholder="id自动分配，无需填写" readonly="readonly">
          </div>
          
          <div class="form-group">
            <label for="examUserName" class="control-label">学生姓名:</label>
            <input type="text" class="form-control" id="examUserName1" name="examUserName">
          </div>
          
          <div class="form-group">
            <label for="examUserNumber" class="control-label">学号:</label>
            <input type="text" class="form-control" id="examUserNumber1" placeholder="4~10位数，必填" name="examUserNumber">
          </div>
          
          <div class="form-group">
            <label for="examUserPassword" class="control-label">学生密码:</label>
            <input type="text" class="form-control" id="examUserPassword1" placeholder="4~10位数，必填" name="examUserPassword">
          </div>
          
          <div class="form-group">
            <label for="examUserTeacher" class="control-label">是否老师:</label>
            <input type="text" class="form-control" id="examUserTeacher1" name="examUserTeacher" value="0" readonly="readonly">
          </div>
          
          <div class="form-group">
            <label for="examUserSex" class="control-label">性别:</label>
            <select class="form-control" id="examUserSex1" name="examUserSex">
            	<option value="男">男</option>
            	<option value="女">女</option>
            </select>
            
            <!-- <input type="text" class="form-control" id="examUserSex1" name="examUserSex"> -->
          </div>
          
          <div class="form-group">
            <label for="examUserBirthday" class="control-label">出生日期:</label>
            <input type="text" class="form-control" id="examUserBirthday1" placeholder="必填，点击可以选择" name="examUserBirthday">
          </div>
          
          <div class="form-group">
            <label for="examUserTel" class="control-label">学生电话:</label>
            <input type="text" class="form-control" id="examUserTel1" name="examUserTel">
          </div>
          
          <div class="form-group">
            <label for="examUserAddress" class="control-label">学生住址:</label>
            <input type="text" class="form-control" id="examUserAddress1" name="examUserAddress">
          </div>
                    
          <div class="form-group">
            <label for="examUserDone" class="control-label">是否完成:</label>
            <select class="form-control" id="examUserDone1" name="examUserDone">
            	<option value="0">0</option>
            	<option value="1">1</option>
            </select>
            <!-- <input type="text" class="form-control" id="examUserDone1" name="examUserDone"> -->
          </div>
          
          
           <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" onclick="add()">添加</button>
      </div>
          
        </form>
        
      </div>
     
    </div>
  </div>
</div>



<!-- 修改的模态框 -->
<div class="modal fade" id="changeModal" tabindex="-1" role="dialog" aria-labelledby="changeModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="changeModalLabel">New message</h4>
      </div>
      <div class="modal-body">
        
        <form id="updateform" action="${ pageContext.request.contextPath }/stuma/update" method="post">
          <div class="form-group">
            <label for="examUserId" class="control-label">学生ID:</label>
            <input type="text" class="form-control" id="examUserId" name="examUserId" readonly="readonly">
          </div>
          
          <div class="form-group">
            <label for="examUserName" class="control-label">学生姓名:</label>
            <input type="text" class="form-control" id="examUserName" name="examUserName">
          </div>
          
          <div class="form-group">
            <label for="examUserNumber" class="control-label">学号:</label>
            <input type="text" class="form-control" id="examUserNumber" placeholder="4~10位数，必填" name="examUserNumber">
          </div>
          
          <div class="form-group">
            <label for="examUserPassword" class="control-label">学生密码:</label>
            <input type="text" class="form-control" id="examUserPassword" placeholder="4~10位数，必填" name="examUserPassword">
          </div>
          
          <div class="form-group">
            <label for="examUserTeacher" class="control-label">是否老师:</label>
            <input type="text" class="form-control" id="examUserTeacher" name="examUserTeacher" value="0" readonly="readonly">
          </div>
          
          <div class="form-group">
            <label for="examUserSex" class="control-label">性别:</label>
            <select class="form-control" id="examUserSex" name="examUserSex">
            	<option vlaue="男">男</option>
            	<option vlaue="女">女</option>
            </select>
            <!-- <input type="text" class="form-control" id="examUserSex" name="examUserSex"> -->
          </div>
          
          <div class="form-group">
            <label for="examUserBirthday" class="control-label">出生日期:</label>
            <input type="text" class="form-control" id="examUserBirthday" placeholder="必填，点击可以选择" name="examUserBirthday">
          </div>
          
          <div class="form-group">
            <label for="examUserTel" class="control-label">学生电话:</label>
            <input type="text" class="form-control" id="examUserTel" name="examUserTel">
          </div>
          
          <div class="form-group">
            <label for="examUserAddress" class="control-label">学生住址:</label>
            <input type="text" class="form-control" id="examUserAddress" name="examUserAddress">
          </div>
                    
          <div class="form-group">
            <label for="examUserDone" class="control-label">是否完成:</label>
            <select class="form-control" id="examUserDone" name="examUserDone">
            	<option vlaue="0">0</option>
            	<option vlaue="1">1</option>
            </select>
            <!-- <input type="text" class="form-control" id="examUserDone" name="examUserDone"> -->
          </div>
          
          
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" onclick="change()">修改</button>
      </div>
          
        </form>
        
      </div>
      
    </div>
  </div>
</div>


<!-- 表格 -->
<div style=" width:1100px;margin: 0 auto;">
	<table id="examUserListTable" border="1" style="text-align: center;" class="table table-striped table-hover">
		<tr class=" success">
			<td>ID</td>
			<td>姓名</td>
			<td>学号</td>
			<td>密码</td>
			<td>老师？</td>
			<td>性别</td>
			<td>生日</td>
			<td>电话</td>
			<td>地址</td>
			<td>完成？</td>
			<td>				
				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#insertModal">添加</button>			
			</td>
		</tr>
<c:forEach items="${ list }" var="examuser">
			<tr>
				<td>${ examuser.examUserId }</td>
				<td>${ examuser.examUserName }</td>
				<td>${ examuser.examUserNumber }</td>
				<td>${ examuser.examUserPassword }</td>
				<td>${ examuser.examUserTeacher }</td>
				<td>${ examuser.examUserSex }</td>
				<td>${ examuser.examUserBirthday }</td>
				<td>${ examuser.examUserTel }</td>
				<td>${ examuser.examUserAddress }</td>
				<td>${ examuser.examUserDone }</td>
				<td>
				   <a href="${ pageContext.request.contextPath }/stuma/delete?examUserId=${ examuser.examUserId }">
					<button type="button" class="btn btn-primary btn-danger">删除</button></a>
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#changeModal" 
					data-id="${ examuser.examUserId }"
					data-name="${ examuser.examUserName }"
					data-number="${ examuser.examUserNumber }"
					data-password="${ examuser.examUserPassword }"
					data-teacher="${ examuser.examUserTeacher }"
					data-sex="${ examuser.examUserSex }"
					data-birthday="${ examuser.examUserBirthday }"
					data-tel="${ examuser.examUserTel }"
					data-address="${ examuser.examUserAddress }"
					data-done="${ examuser.examUserDone }"
					>修改</button>				
				</td>
			</tr>
</c:forEach>
	</table>
</div>


    
    
    
    </div>


    <!-- <script src="../static/js/bootstrap.js"></script> -->
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  
</body></html>
