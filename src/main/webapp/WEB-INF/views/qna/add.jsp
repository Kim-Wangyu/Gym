<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Qna Add Page</h1>
	
	<form action="./add" method="post" enctype="multipart/form-data">
		Title<input type="text" name="title">
		Contents<textarea name ="contents" rows="" cols=""></textarea>
		Writer<input type="text" name="writer" value="${member.id}" readonly>
			
		<div id="fileResult">
		
		</div>
		
		<button id="fileAdd" type="button">FileADD</button>
		
	
	
	
		<button type="submit">ADD</button>
	</form>
<script src="../resources/js/file.js"></script>
</body>
</html>