<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/header_css.jsp"></c:import>
<link href="../resources/css/detail.css" rel="stylesheet">
</head>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1>Member Detail Page</h1>
	
	<h3>id : ${member.id}</h3>
	<h3>이름 : ${member.name}</h3>
	<h3>번호 : ${member.phone}</h3>
	<h3>등급 : ${member.grade}</h3>
	<c:if test="${ member.grade eq 1 }">
	
		<h3>가격 : ${trainer.price}</h3>
		<h3>운동종류 : ${trainer.category}</h3>
	</c:if>
	
	
	<a href="./upgrade?memberNum=${member.memberNum}">Upgrade</a>
	
	
	

</body>
</html>