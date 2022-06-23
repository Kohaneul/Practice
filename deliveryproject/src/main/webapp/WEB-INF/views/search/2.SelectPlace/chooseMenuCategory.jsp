<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴고르기</title>
</head>
	<body>
		<center>
     	<br>
     	<br>
					[ ${place.name} ] 주변 원하는 메뉴를 골라주세요
					
					<form action="<c:url value='/place/restaurant.dlv'/>" >
					 <input type = "hidden" name = "place_name" value="${place.name}" readonly/>
					
					     <br>
					<c:forEach items="${category}" var="category" >
					     
					
					<input type="radio" name="category_name" value="${category.category_name}">${category.category_name}<br>
					</c:forEach>
					<br>
					<input type = "submit" value="선택" onclick="close_window()"/>
		</center>
		
	</body>	
					
</html>