<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<h1>Detail Page</h1>

<h3>Num : ${dto.num}</h3>
<h3>Title : ${dto.title}</h3>
<h3>Contents : ${dto.contents}</h3>
<h3>Writer : ${dto.writer}</h3>


//-----------------------------
<hr>
<c:if test="${not empty member.id}">
	<div>
	<form action="../common/noticeReply" method="post" enctype="application/x-www-form-urlencoded">
		Contents<textarea rows="" cols="" name="contents" id="contents" ></textarea>
		<input type="hidden" name="num" id="num" value="${dto.num}">
		Writer<input type="text" name="writer" readonly="readonly" id="writer" value="${member.id}">
		<button type="button" name="replyBtn" id="replyBtn">REPLY</button>
	</form>
	</div>
</c:if>
<table id="replyResult">

</table>

<c:if test="${dto.writer eq member.id}">
<a href="./update?num=${dto.num}">UPDATE</a>
<a href="./delete?num=${dto.num}">DELETE</a>
</c:if>
<script type="text/javascript" src="../resources/js/noticeReply.js"></script>
</body>
</html>