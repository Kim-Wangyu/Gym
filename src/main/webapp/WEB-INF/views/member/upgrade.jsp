
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
<div class="d1">
	<h1>Member Upgrade Page</h1>
	
	<c:if test="${dto.grade eq 0}">
		<form action="./upgrade" method="post">
			<input type="hidden" name="memberNum" value="${dto.memberNum}">
			<select name="grade">
					<option value="0">회원</option>
					<option value="1">트레이너</option>		
				</select> 
			가격<input type="text" name="price"> 
			<input type="hidden" name="category" value="0" >
			<button type="submit">수정</button>
		</form>
	</c:if>
	<c:if test="${dto.grade eq 1}">
		<form action="./trainerUpdate" method="post">
			<input type="hidden" name="memberNum" value="${dto.memberNum}">
			<select name="grade">
					<option value="0">회원</option>
					<option value="1">트레이너</option>		
			</select> 
			가격<input type="text" name="price" value="${trainer.price}" > 
				<input type="hidden" name="category" value="0" >
			<button type="submit">수정</button>
		</form>
	</c:if>
</div>
</body>
</html>