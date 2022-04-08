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
<h1>Detail Page</h1>

<h3>Num : ${dto.num}</h3>
<h3>Title : ${dto.title}</h3>
<h3>Contents : ${dto.contents}</h3>
<h3>Writer : ${dto.writer}</h3>


<hr>

<div>
	<c:forEach items="${dto.fileDTOs}" var="f">
		 <a href="../resources/upload/${board}/${f.fileName}">${f.oriName}</a> <!--  클릭해서 보기     -->
		 <img alt="" src="../resources/upload/${board}/${f.fileName}">
		<%-- <a href="./fileDown?fileNum=${f.fileNum}">${f.oriName}</a> --%>
	
	</c:forEach>
</div>






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
<a href="#" id="del">DELETE</a>
		<form id="frm" method="post">
			<input type="hidden" name="num" id="num1" value="${dto.num}">
		</form>
</c:if>

	<a href="./list">LIST</a>
</div>
<script src="../resources/js/delete.js"></script>
<script type="text/javascript" src="../resources/js/noticeReply.js"></script>
</body>
</html>