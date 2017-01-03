<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en"><head>
    <meta charset="utf-8">
    <title>用户登录</title>
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
    
	<script type="text/javascript">	
	 
	//登陆验证
	function logincheck(){
		var tip = "";
		if( ($("#examUserNumber").val().length<4) || (($("#examUserNumber").val().length>10)) ){
			tip += "学号---> 必须为 < 4~10 > 位数\n\n";
		}
		if( ($("#examUserPassword").val().length<4) || (($("#examUserPassword").val().length>10)) ){
			tip += "密码---> 必须为 < 4~10 > 位数\n\n";
		}
		if( tip != ""){
			alert( tip );
		}else{
			$("#loginsubmit").submit();		
		}	
	}
	</script>
	<script type="text/javascript">
	var req = "${req}";
	$(function(){
		if(req !== ""){
			alert(req);
			req = "";
		}else{}
	}); 
	</script>

</head>
<body  class=" theme-blue">

    <!-- Demo page code -->

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

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  

  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
   
  <!--<![endif]-->

    <div class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
          <a class="" href="http://www.bootcss.com/"><span class="navbar-brand"><span class="fa fa-paper-plane"></span>在线考试系统(Online Examination System)</span></a></div>

        <div class="navbar-collapse collapse" style="height: 1px;">

        </div>
      </div>
    


        <div class="dialog">
    <div class="panel panel-default">
        <p class="panel-heading no-collapse">用户-登录</p>
        <div class="panel-body">
        
        
        
            <form id="loginsubmit" action="index" method="post">
                <div class="form-group">
                    <label>学号：</label>
                    <input type="text" id="examUserNumber" name="examUserNumber" class="form-control span12">
                </div>
                <div class="form-group">
                <label>密码：</label>
                    <input type="password" id="examUserPassword" name="examUserPassword" class="form-controlspan12 form-control">
                </div>
               <!--  <a href="login/index" class="btn btn-primary pull-right">Sign In</a> -->
                <input id="login" type="button" class="btn btn-primary pull-right" onclick="logincheck()" value="登陆"/>
                
                <label class="remember-me"><input type="checkbox">记住我</label>
                <div class="clearfix"></div>
            </form>
            
            
            
        </div>
    </div>
    <!-- <p class="pull-right" style=""><a href="tlogin" target="blank" style="font-size: .75em; margin-top: .25em;">教师登陆</a></p> -->
    <p><a href="http://www.bootcss.com/">忘记密码?</a></p>
</div>



    <script src="../static/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  
</body>
</html>
