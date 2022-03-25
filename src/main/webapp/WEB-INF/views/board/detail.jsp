<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Detail Page</h1>

<h3>Num : ${dto.num}</h3>
<h3>Title : ${dto.title}</h3>
<h3>Contents : ${dto.contents}</h3>
<h3>Writer : ${dto.writer}</h3>


//-----------------------------
<hr>

<div>
<form action="../common/noticeReply" method="post" enctype="application/x-www-form-urlencoded">
	Contents<textarea rows="" cols="" name="contents" id="contents" ></textarea>
	<input type="hidden" name="num" id="num" value="${dto.num}">
	Writer<input type="text" name="writer" readonly="readonly" id="writer" value="${member.id}">
	<button type="button" name="replyBtn" id="replyBtn">REPLY</button>
</form>
</div>

<table id="replyResult">

</table>

<a href="./update?num=${dto.num}">UPDATE</a>
<a href="./delete?num=${dto.num}">DELETE</a>

<script type="text/javascript" src="../resources/js/noticeReply.js"></script>
</body>
</html>