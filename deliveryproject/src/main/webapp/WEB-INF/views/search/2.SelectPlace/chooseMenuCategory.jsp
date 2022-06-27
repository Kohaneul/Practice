<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴고르기</title>
<script>
	let place_name = document.getElementById("place_name").value;
	

	function setChildText(){
		
		let place_name = document.getElementById('place_name').value;
		let code = document.getElementById('code').value;
		let url = "/deli/place/restaurant.dlv?place_name="+place_name+"&code="+code;
		openWin = window.open(url)
		openWin.document.getElementById("cInput").value =place_name;
		console.log(place_name);
		document.getElementById('url').value = url;
		window.open(url);
	}
	
	

</script>
</head>
   <body>
      <center>
        <br>
        <br>
               [ ${place.name} ] 주변 원하는 메뉴를 골라주세요
               <!--                <form action="<c:url value='/place/restaurant.dlv'/>" name="childForm"> -->
               <form name="childForm">
                   <input type="text" id="cInput" value=""/>
                <input type = "hidden" name = "place_name" value="${place.name}" readonly/>
                    <br>
               <c:forEach items="${category}" var="category" >
                       
               
               <input type="radio" name="code" value="${category.code}" id="code">${category.foodtype}<br>
                   
               </c:forEach>
               <br>
               <input type = "submit" value="선택" onclick ="setChildText();"/>
      </center>
      
   </body>   
               
</html>