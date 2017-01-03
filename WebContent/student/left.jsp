<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>后台左侧导航页面</title>	
  <!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${pageContext.request.contextPath }/static/js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>

  </head> 
  <body style="text-align: center">
 	<button type="button" class="btn btn-primary" data-toggle="collapse"    data-target="#demo">
	 功能列表
	</button>
	<br>
	<div id="demo" class="collapse on">
  	<a href="${pageContext.request.contextPath}/student/listBydone" target="right">查看已考科目</a><br>
	<a href="${pageContext.request.contextPath}/student/listNodone" target="right">查看未考科目</a>
	</div>   
  </body>
</html>
