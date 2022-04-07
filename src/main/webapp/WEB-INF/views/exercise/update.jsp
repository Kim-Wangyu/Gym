<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Exercise Update Page</h1>
	
	<form action="./update" method="post" enctype="multipart/form-data">
		<input type="hidden" name="num" id="num" value="${dto.num}">
		Title <input type="text" name="title" id="title" value="${dto.title}">
		Contents <textarea name= "contents" rows="" cols="">${dto.contents}</textarea>
		
		<div id=files>
			<c:forEach items="${dto.exFileDTOs}" var = "f">
			<div>
				${f.oriName}<button type="button" data-fileNum="${f.fileNum}" class="fileDelBtn">X</button>
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
	<script type="text/javascript" src="../resources/js/file.js"></script>
	
</body>
</html>