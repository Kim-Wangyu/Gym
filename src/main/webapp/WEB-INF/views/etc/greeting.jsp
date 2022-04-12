<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
 <link rel="stylesheet" href="/s1/resources/css/header.css">
 <link rel="stylesheet" href="/s1/resources/css/etc.css">
     <link rel="stylesheet" href="/s1/resources/css/home.css">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<h1></h1>
<div id="galleryCont">

 	<img src="/s1/resources/images/img.jpg" id="photo">
	<div id="gc">
		<button id="cli" type="button">이전</button>
	</div>
	<div id="gc1">
		<button id="cli1" type="button">다음</button>
	</div>
	
</div>
<div id="useBox">
	<img src="/s1/resources/images/use.jpg" id="usePic">
</div>

<c:import url="../template/bottom.jsp"></c:import>
	<script src="/s1/resources/js/etc.js"></script>
</body>
</html>