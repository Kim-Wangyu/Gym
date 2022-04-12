<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
<link href="../resources/css/login.css" rel="stylesheet">
<link rel="stylesheet" href="/s1/resources/css/home.css">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="d1">
		<h2>Login Page</h2>
		<form action="./login" method="post" >
			Id<input type="text" name="id" value="${cookie.rememberid.value}">
			Password<input type="password" name="pw"> 
			Id저장<input type="checkbox" name="remember" value="1">
			<input type="submit" value="Login">
		</form>
	</div>
</body>
</html>