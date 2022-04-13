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
	<h1>Exercise Update Page</h1>
	<form action="./update" method="post" enctype="multipart/form-data">
		<input type="hidden" name="num" id="num" value="${dto.num}">
		<h3 class="updateh3">Title</h3> <input  class="updateinput"type="text" name="title" id="title" value="${dto.title}">
		<h3 class="updateh3">Contents</h3> <textarea class="updatetextarea" name= "contents" rows="" cols="">${dto.contents}</textarea>
		<h3 class="updateh3">Writer</h3> <input  class="updateinput" type="text" readonly="readonly" name="writer" value="${dto.writer}">
		<div id=files>
			<c:forEach items="${dto.exFileDTOs}" var = "f">
			<div>
				${f.oriName}<button type="button" data-fileNum="${f.fileNum}" class="fileDeleteBtn">X</button>
			</div>
			</c:forEach>
		</div>
		<div id="fileResult">
		
		</div>
		<div>
			<button type="button" id="fileAdd">fileAdd</button>
		</div>
		
		
		<button type="submit" id="btn">Update</button>
	</form>
	</div>
	<script type="text/javascript" src="../resources/js/file.js"></script>
	
</body>
</html>