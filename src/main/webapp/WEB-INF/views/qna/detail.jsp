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
    <link rel="stylesheet" href="/s1/resources/css/home.css">
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
		<c:forEach items="${dto.fileDTOs}" var="f">
			<a href="../resources/upload/${board}/${f.fileName}">${f.oriName}</a> <!--  클릭해서 보기     -->
				<img alt="" src="../resources/upload/${board}/${f.fileName}">
		
		</c:forEach>
		</div>
		<hr>
	
	<div>
		<input type="hidden" name="num" value="${dto.num}" id="num"> 
		Contents<textarea rows="" cols="" name="contents" id="contents" style="width:430px;height:70px" ></textarea>
		<div id="writerbtn">
			Writer<input type="text" name="writer" id="writer" value="${member.id}">
			<button type="button" name="reply" id="reply" >reply</button>
		</div>
	</div>

	<table id="replyResult">

	</table>

	<c:if test="${member.id eq dto.writer}">

		<form id="frm" method="post">
			<input type="hidden" name="num" id="num2" value="${dto.num}">
		</form>

		<%-- 	<button id = "del" >DELETE</button> --%>
		
		<a href="./update?num=${dto.num}" class="btnbtn">UPDATE</a>
		<a href="#" class="btnbtn" id="del">DELETE</a>
		<script src="../resources/js/delete.js"></script>
	</c:if>
	<div>
	<a href="./list"> < LIST</a>
	</div>
	</div>
	
	<c:import url="../template/bottom.jsp"></c:import>
	<script src="../resources/js/qnaReply.js"></script>

</body>
</html>