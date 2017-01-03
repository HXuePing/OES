<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<%-- <script src="${pageContext.request.contextPath }/static/js/jquery.min.js"></script> --%>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>

<script src="${pageContext.request.contextPath }/static/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	function doit(){
		if(window.confirm('你确定要开始考试吗？')){
			return true;
		}else{
			return false;
		}				
	}
</script>
</head>
<body>

	<div style="width: 800px;text-align: center;margin: 0 auto;" >

	<table id="userListTable"   border="1" class="table table-striped table-hover table-condensed">
		<tr><td colspan="3"></td></tr>
		<tr>
			<td>科目名称</td>
			<td>说明</td>
			<td>题数</td>
			<td>总时间</td>
			<td>总分</td>
			<td>考试状态</td>
			<td>是否已考</td>
			<td>操作</td>
		</tr>
	
	
	<c:forEach items="${list}" var="ls">
	<tr>
		<td>${ls.examSubjectName }</td>
		<td>${ls.examSubjectDescription }</td>
		<td>${ls.examSubjectTnumber}</td>
		<td>${ls.examSubjectTotaltime}</td>
		<td>${ls.examSubjectSum}</td>
		<td>
		<c:if test="${ls.examSubjectFlag=='1'}">
			开启
		</c:if>
		<c:if test="${ls.examSubjectFlag=='0'}">
			关闭
		</c:if>
		</td>
		<td>
		<c:if test="${ls.examSubjectDone=='1'}">
			已考
		</c:if>
		<c:if test="${ls.examSubjectDone=='0'}">
			未考
		</c:if>
		</td>
		<td>
		<c:if test="${ls.examSubjectDone=='1'}">
		
		<a class="btn btn-primary" href="${pageContext.request.contextPath }/student/listbygrade/${ls.examSubjectId}" role="button">查看成绩</a> 
		<%-- <a href="/OES/student/listbygrade/${ls.examSubjectId}">查看成绩</a> --%>
		</c:if>
		<c:if test="${ls.examSubjectDone=='0'}">
		
			<c:if test="${ls.examSubjectFlag=='0'}">
				<font color="red">考试时间已截止</font>
			</c:if>
			<c:if test="${ls.examSubjectFlag=='1'}">
			<a class="btn btn-primary" href="${pageContext.request.contextPath }/student/test/${ls.examSubjectId}" role="button" onclick="return doit();" target="_blank">开始考试</a> 	
			</c:if>
		
		<%-- <a href="/OES/student/test/${ls.examSubjectId}" onclick="return doit();" target="_blank">开始考试</a> --%>
		</c:if>
		</td>
		</tr>
	</c:forEach>
	
		</table>
		
		</div>
		
	<a href="${ pageContext.request.contextPath }/login/index">主页</a>	
</body>
</html>