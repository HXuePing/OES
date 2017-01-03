<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${pageContext.request.contextPath }/static/js/jquery-2.1.4.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>

<!-- 如果使用boostrap模板，直接copy它html的文件里的引用即可。注意一定要修改路径：例如下面实例 -->
<%-- <script src="${pageContext.request.contextPath }/static/js/bootstrap.js"></script> --%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>打印界面</title>

</head>
<a href="../">首页</a>
<body>
<table class="table table-hover table-striped">
	<tr class="success"><td>科目</td><td>学号</td><td>姓名</td><td> 考试日期</td><td>考试成绩</td><tr>
	
	<tr><td>${ Name.examSubjectName}</td><td>${ examStu.examUserId}</td><td>${examStu.examUserName}</td><td>${ grade.examGradeTime}</td><td>${grade.examGradePoint}</td><tr>
	</table>
<br> <button type="button"  class="btn btn-primary btn-lg" data-toggle="modal" data-target="#stamp">
  打印
</button>

<div class="modal fade" id="stamp" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">打印预览</h4>
      </div>    
      <div class="modal-body">      
      <table class="table table-hover table-striped">
	<tr class="success"><td>科目</td><td>学号</td><td>姓名</td><td> 考试日期</td><td>考试成绩</td><tr>
	<c:forEach items="${Grade}" var="post" varStatus="i">
	<tr><td>${ Name.examSubjectName}</td><td>${post.examUserId}</td><td></td><td></td><td>${post.examGradePoint}</td><tr>
	</c:forEach></table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="submit" class="btn btn-primary">打印</button>
      </div>   
    </div>
  </div>
</div>
</body>
</html>