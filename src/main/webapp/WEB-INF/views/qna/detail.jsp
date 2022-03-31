<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
<link href="../resources/css/detail.css" rel="stylesheet">
</head>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class ="d1">
		<h1>Qna Detail Page</h1>

		<h3>번호 : ${dto.num}</h3>
		<h3>제목 : ${dto.title}</h3>
		<h3>내용 : ${dto.contents}</h3>
		<h3>작성자 : ${dto.writer}</h3>
	
	<div>
		<input type="hidden" name="num" value="${dto.num}" id="num"> 
		<input type="text" readonly name="writer" value="${member.id}" id="writer">
		<textarea rows="" cols="" name="contents" id="contents"></textarea>
		<button type="button" id="reply">Reply</button>
	</div>

	<table id="replyResult">

	</table>

	<c:if test="${member.id eq dto.writer}">

		<form id="frm" method="post">
			<input type="hidden" name="num" id="num2" value="${dto.num}">
		</form>

		<%-- 	<button id = "del" >DELETE</button> --%>
		<a href="#" id="del">DELETE</a>
		<a href="./update?num=${dto.num}">UPDATE</a>
		<script src="../resources/js/delete.js"></script>
	</c:if>
	
	<a href="./list">LIST</a>
	</div>
	<script src="../resources/js/qnaReply.js"></script>

</body>
</html>