<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>FAQ</title>
</head>
<body>
<h1>FAQ</h1>
<ul>번호 : ${faq.no}</ul>
<ul>아이디 : ${faq.id}</ul>
<ul>제목 : ${faq.title}</ul>
<ul>내용 : ${faq.content}</ul>
<button><a href="<c:url value='/faq/board/update.dlv?no=${faq.no}'/>">수정</button></a>
<button><a href="<c:url value='/faq/board/delete.dlv?no=${faq.no}'/>">삭제</button></a>

</body>
</html>