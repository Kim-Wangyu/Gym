<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <style type="text/css">
.select{letter-spacing:10px}
</style> -->
</head>
<body>
	<h1>Buy Page</h1>
<div>
	<select>
		<option value="0">PT</option>
		<option  value="1">Pilates</option>
	</select>
	
	<select class ="select">
	<c:forEach items="${list}" var="f">
		<option class="select" value="col1">${f.memberDTOs.name}${f.price}${f.category}</option>
	</c:forEach>
	</select>
	
	<select>
		<option value="0">5</option>
		<option  value="1">10</option>
		<option value="2">15</option>
		<option  value="3">20</option>
	</select>
	
	
</div>	
</body>
</html>