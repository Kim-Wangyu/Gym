<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
<link href="../resources/css/add.css" rel="stylesheet">
<link rel="stylesheet" href="/s1/resources/css/home.css">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="d1">
<h1>ADD PAGE</h1>
	<form action="./add" method="post" enctype="multipart/form-data">
		<h3 class="addh3">Title</h3><input class="addinput" type="text" name="title">
		<h3 class="addh3">Contents</h3><textarea class="addtextarea" name="contents" rows="" cols="" ></textarea>
		<h3 class="addh3">Writer</h3><input class="addinput" type="text" name="writer" value="${member.id}" readonly="readonly">
		
		<div id="fileResult">
		
		</div>
		
		<div>
			<button id="fileAdd" type="button">fileADD</button>
			<button type="button" class="del">SAMPLE DEL</button>
		</div>
		
	
	<button type="submit">게시물 작성</button>
	</form>
</div>
<script src="../resources/js/file.js"></script>
</body>
</html>