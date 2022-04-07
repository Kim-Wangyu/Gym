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
<h1>Update Page</h1>

	<form action="./update" method="POST" enctype="multipart/form-data">
		<input type="hidden" name="num" value="${dto.num}" readonly="readonly">
		Title <input type="text" name="title" value="${dto.title}">
		Contents <input type="text" name="contents" value="${dto.contents}">
		Writer <input type="text" readonly="readonly" name="writer" value="${dto.writer}">
		
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
	
	
	
	
	
	<input type="submit" value="update">
	</form>

<script type="text/javascript" src="../resources/js/file.js"></script>
</body>
</html>