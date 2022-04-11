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
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div id="wrapper">
<h1>Member Pw Update Page</h1>

	<form action="./pwupdate" method="post" id="form">
		
		<input type="hidden" name="id"  value="${member.id}">
		<input type="hidden" name="bpw" id="bpw" value="${member.pw}">
		
		현재 비밀번호<input type="password" id ="pw1" name="pw1">
		수정 할 비밀번호<input type="password" id ="pw2" name="pw2" ><div id="pwResult2"></div>
		비밀번호 확인<input type="password"id ="pw" name="pw"><div id="pwResult"></div>
		
		<button type="button" id="btn">수정</button>
	</form>
	
	<script type="text/javascript" src="../resources/js/pwupdate.js"></script>
	</div>
	<footer>
	<c:import url="../template/bottom.jsp"></c:import>
	</footer>
</body>
</html>