<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
 <link rel="stylesheet" href="/s1/resources/css/home.css">
 <link rel="stylesheet" href="/s1/resources/css/etc.css">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<h1>Greeting Page</h1>
<div id="galleryCont">

 	<img src="/s1/resources/images/Logo.jpg" id="photo">
	<button id="cli" type="button">이전</button>
	<button id="cli1" type="button">다음</button>
	
</div>
<div id="useBox">
	<img src="/s1/resources/images/use.jpg" id="usePic">
</div>

<c:import url="../template/bottom.jsp"></c:import>
	<script src="/s1/resources/js/etc.js"></script>
</body>
</html>