<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/faq/faqInsert.css"/>" >

</head>
<body>
<center>
	<form action="<c:url value='/faq/board/insert.dlv'/>" method="post">
	아이디 : <input type="text" name="id" id = "id" placeholder="아이디 입력"><br>
	비밀번호 : <input type="password" name="pw" id ="pw" placeholder="비밀번호 입력"><br>
	제  목 : <input type ="text" name="title" id ="title"  placeholder="제목"><br>
	내  용 : <input type="text" name="content" id ="content" placeholder="내용입력"><br>
	<input type="submit" value="등록하기">
	</form>
</center>
</body>
</html>