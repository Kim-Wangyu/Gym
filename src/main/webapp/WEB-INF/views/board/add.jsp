<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ADD PAGE</h1>


	<form action="./add" method="post" enctype="multipart/form-data">
		Title <input type="text" name="title">
		Contents <textarea name="contents" rows="" cols="" ></textarea>
		Writer <input type="text" name="writer" value="${member.id}" readonly="readonly">
		
		<div id="fileResult">
		
		</div>
		
		<div>
			<button id="fileAdd" type="button">fileADD</button>
			<button type="button" class="del">SAMPLE DEL</button>
		</div>
		
	
	<button type="submit">ADD</button>
	</form>

<script src="../resources/js/file.js"></script>
</body>
</html>