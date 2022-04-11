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
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="d1">
<h1>Qna Update Page</h1>
	<form action="./update" method="post" enctype="multipart/form-data">
		<input type="hidden" name="num"  value="${dto.num}">
		<h3 class="updateh3">Title</h3><input class="updateinput" type="text" name="title" value="${dto.title}" >
		<h3 class="updateh3">Contents</h3><textarea class="updatetextarea" name ="contents"  rows="" cols="" >${dto.contents}</textarea>
		<h3 class="updateh3">Writer</h3> <input  class="updateinput" type="text" readonly="readonly" name="writer" value="${dto.writer}">
		<div id="files">
			<c:forEach items="${dto.fileDTOs}" var="f">
				<div>
					${f.oriName} <button type="button" data-fileNum="${f.fileNum}" class="fileDeleteBtn">X</button>
				</div>
			
			</c:forEach>
		
		</div>
			<div id="fileResult"></div>
		
		<div>
			<button id="fileAdd" type="button">fileADD</button>
		</div>
	
		<!-- <input type="submit" name="insert"> -->
		<button type="submit">게시물 업데이트</button>
	</form>
	</div>
	<script type="text/javascript" src="../resources/js/file.js"></script>
</body>
</html>