
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member Upgrade Page</h1>
	
	<c:if test="${dto.grade eq 0}">
		<form action="./upgrade" method="post">
			<input type="hidden" name="memberNum" value="${dto.memberNum}">
			등급<input type="text" name="grade" value="${dto.grade}"> 
			가격<input type="text" name="price"> 
			운동종류<input type="text" name="category">
			<button type="submit">수정</button>
		</form>
	</c:if>
	<c:if test="${dto.grade eq 1}">
		<form action="./trainerUpdate" method="post">
			<input type="hidden" name="memberNum" value="${dto.memberNum}">
			등급<input type="text" name="grade" value="${dto.grade}"> 
			가격<input type="text" name="price" value="${trainer.price}" > 
			운동종류<input type="text" name="category" value="${trainer.category}" >
			<button type="submit">수정</button>
		</form>
	</c:if>

</body>
</html>