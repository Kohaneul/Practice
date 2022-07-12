<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ</title>
</head>
<body>
<h1>배달공구 FAQ</h1>

	<!-- list에 데이터가 존재할경우 -->
	<c:if test="${empty str}">
	<table>
	<tr>
	<th>번호</th>
	<th>제목</th>
	<th>작성일</th>
	</tr>
	<tr>
		<c:forEach items="${list}" var="list" >
	
	<th> <a href="<c:url value='/faq/board/detail.dlv?no=${list.no}'/>">${list.no}</a></th>
	 <th>${list.title}</th>
	 <th>${list.wdate}</th>
	</tr>
	</c:forEach>
	</table>
	<a href="<c:url value='/faq/board/insert.dlv'/>"><button>등록하기</button></a>
	</c:if>
	
	<!-- list에 데이터가 없을경우 : str(에러메세지를 띄운다) -->
- 	<c:if test="${not empty str}">
		${str}
	<button><a href="<c:url value='/faq/board/insert.dlv'/>">등록하기</a></button>
	</c:if>


	
</body>
</html>