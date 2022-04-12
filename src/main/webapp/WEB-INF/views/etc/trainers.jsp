<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
 <link rel="stylesheet" href="/s1/resources/css/home.css">
 <link rel="stylesheet" href="/s1/resources/css/trainer.css">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<h1><br> 
</h1>


<div id="imgBox">
	<div class="imgBoxIn">
		<div class="imgBoxIn2">
			<a href="./jongKuk"><img class="photos" alt="" src="../resources/images/jongKuk.jpg"></a>
			<h1>김종국</h1>
		</div>
		<div class="imgBoxIn2">
			<a href="./siYeong"><img class="photos" alt="" src="../resources/images/siyeong.jpg"></a>
			<h1>이시영</h1>
		</div>
			
	</div>
	<div class="imgBoxIn">
		<div class="imgBoxIn2">
		<a href="./rain"><img class="photos" alt="" src="../resources/images/rain.jpg"></a>
		<h1>정지훈</h1>
		</div>
		<div class="imgBoxIn2">
		<a href="./sangHwa"><img class="photos" alt="" src="../resources/images/sanghwa.jpg"></a>
		<h1>이상화</h1>
		</div>
	</div>
</div>


<c:import url="../template/bottom.jsp"></c:import>
	<script src="/s1/resources/js/etc.js"></script>
</body>
</html>