<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en"><head>
    <meta charset="utf-8">
    <title>个人信息</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="../static/css/bootstrap.css">
    <link rel="stylesheet" href="../static/css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="../static/css/theme.css">
	<link rel="stylesheet" type="text/css" href="../static/css/premium.css">
    <script src="../static/js/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="../static/js/jquery.knob.js" type="text/javascript"></script>
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
             <li><a href="${ pageContext.request.contextPath }/teama/choose"><span class="fa fa-caret-right"></span>教师管理考试成绩allen</a></li>
            <li><a href="${ pageContext.request.contextPath }/login/index"><span class="fa fa-caret-right"></span>教师管理考试题</a></li>
            <li ><a href="${ pageContext.request.contextPath }/stuma/list"><span class="fa fa-caret-right"></span>教师管理学生信息dragon</a></li>
            <li ><a href="${ pageContext.request.contextPath }/file"><span class="fa fa-caret-right"></span>学员资料批量导入dragon</a></li>
    </ul></li>
 </ul>
</div>
  		<!-- 加入内容 -->
    <div class="content">
    	<div style="margin: 0 auto;width: 500px" >
    
    <br><br><br><br><br><br>
    <table border="1px" style="text-align: center;margin: 0 auto;" class="table table-striped table-hover table-condensed">
	<tr>
		<!-- <td>个人信息</td> -->
		<th colspan="2" style="text-align: center;">${ examUser.examUserName }的个人信息</th>
	</tr>
	<tr>
		<td>用户ID</td>
		<td>${ examUser.examUserId }</td>
	</tr>
	<tr>
		<td>用户名</td>
		<td>${ examUser.examUserName }</td>
	</tr>
	<tr>
		<td>学号</td>
		<td>${ examUser.examUserNumber }</td>
	</tr>
	<tr>
		<td>是否老师</td>
		<td>${ examUser.examUserTeacher }</td>
	</tr>
	<tr>
		<td>性别</td>
		<td>${ examUser.examUserSex }</td>
	</tr>
	<tr>
		<td>出生日期</td>
		<td>${ examUser.examUserBirthday }</td>
	</tr>
	<tr>
		<td>住址</td>
		<td>${ examUser.examUserAddress }</td>
	</tr>
	<tr>
		<td>是否完成</td>
		<td>${ examUser.examUserDone }</td>
	</tr>
  </table>	
    
        
    </div>
</div>


    <script src="../static/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  
</body></html>
