<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
<link href="../resources/css/join.css" rel="stylesheet">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="d1">
		<h2>Join Page</h2>
		<form action="./join" method="post" id="form" enctype="multipart/form-data">
			Id<input type="text" id ="id" name="id" placeholder="아이디 필수"><div id="idResult"></div>
			Password<input type="password" id ="pw"  name="pw" placeholder="6자 이상 10자 이하로 작성"><div id="pwResult"></div>
			Password 확인<input type="password" id ="pw2"  name="pw2" placeholder="6자 이상 10자 이하로 작성"><div id="pwResult2"></div>
			Name<input type="text" name="name" id ="name" > 
			Phone<input type="text" name="phone" id ="phone" >
			Photo<input type="file" name="file" id="file">
			
			<button type="submit" id="btn"> Join</button>
		</form>
	</div>
	
<!-- 	<script type="text/javascript" src="../resources/js/join.js"></script> -->

</body>
</html>