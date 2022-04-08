<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<h1>Exercise Detail Page</h1>
	<h3>Num : ${dto.num}</h3>
	<h3>Title : ${dto.title}</h3>
	<h3>Writer : ${dto.writer}</h3>
	<h3>Contents : ${dto.contents}</h3>
	<h3>RegDate : ${dto.regDate}</h3>
	<h3>Hit : ${dto.hit}</h3>
	
	<div>
		<c:forEach items="${dto.exFileDTOs}" var="f"> 
		<img alt="" src="../resources/upload/exercise/${f.fileName}"> <!-- 그냥 보임 -->
		<a href="../resources/upload/${board}/${f.fileName}">${f.oriName}</a> <!--  클릭해서 보기     --> 
		<%-- <a href="./fileDown?fileNum=${f.fileNum}">${f.oriName}</a> --%>	
		</c:forEach>
	</div> 
	
	
	<table id="replyResult">
	</table>
	<c:if test="${not empty member}"></c:if>
	<div>
		<input type="hidden" name = "num" id="num" value="${dto.num}">
		<input type="text" name="writer" id="writer" value="${member.id}">
		<textarea rows="" cols="" name="contents" id="contents" ></textarea>
		<button type="button" name="reply" id="reply" >reply</button>
	</div>
	
		<a href="#" id="del">Delete</a>
		<a href="./update?num=${dto.num}">Update</a>
		<form id="frm" method="post">
			<input type="hidden" name="num" id="num1" value="${dto.num}">
		</form>
	<script src="../resources/js/delete.js"></script>

	<a href="./list">List</a>
</div>
	<script src="../resources/js/exerciseReply.js"></script>
</body>
</html>