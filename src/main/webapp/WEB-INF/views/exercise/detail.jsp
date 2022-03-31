<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../resources/css/detail.css" rel="stylesheet">
</head>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1>Exercise Detail Page</h1>
	<h3>Num : ${dto.num}</h3>
	<h3>Title : ${dto.title}</h3>
	<h3>Writer : ${dto.writer}</h3>
	<h3>Contents : ${dto.contents}</h3>
	<h3>RegDate : ${dto.regDate}</h3>
	<h3>Hit : ${dto.hit}</h3>
	<table id="replyResult">
	</table>
	<div>
		<input type="hidden" name = "num" id="num" value="${dto.num}">
		<input type="text" name="writer" id="writer" value="${member.id}">
		<textarea rows="" cols="" name="contents" id="contents" ></textarea>
		<button type="button" name="reply" id="reply" >reply</button>
	</div>
	
	<c:if test="${dto.writer eq member.id}">
		<a href="#" id="del">Delete</a>
		<a href="./update?num=${dto.num}">Update</a>
		<form id="frm" method="post">
			<input type="hidden" name="num" id="num1" value="${dto.num}">
		</form>
	<script src="../resources/js/delete.js"></script>
	</c:if>
	<a href="./list">List</a>

	<script src="../resources/js/exerciseReply.js"></script>
</body>
</html>