<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>前台进入页面</title>
</head>
 <frameset rows="8%,*">
  		<frame src="${pageContext.request.contextPath}/student/head" name="head">
  		<frameset  cols="10%,*">
	  		<frame src="${pageContext.request.contextPath}/student/left" name="left">
	 		<frame src="${pageContext.request.contextPath}/student/listPage" name="right">
 		</frameset>
  </frameset>
<body>

</body>
</html>