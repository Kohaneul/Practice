<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>	
	<form action="<c:url value='/faq/board/update.dlv'/>" method="post">
	<input type="hidden" name="no" value="${no}" readonly>
	<input type="text" name="title" placeholder="${faq.title}"><br>
	<input type="text" name="content" placeholder="${faq.content}"><br>
	<input type ="submit" value="수정">
	</form>
</body>
</html>