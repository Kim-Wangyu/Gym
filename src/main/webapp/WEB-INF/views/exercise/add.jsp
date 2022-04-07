<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Exercise Add Page</h1>
	
	<form action="./add" method="post" enctype="multipart/form-data">
		Title <input type="text" name="title" id="title">
		Writer <input type="text" name="writer" id="writer" value="${member.id}" readonly="readonly">
		Contents <textarea name= "contents" rows="" cols=""></textarea>
		
		<div id = "fileResult">
			
		</div>

		<div>
			<button type="button" id = "fileAdd">fileAdd</button>
			<!-- <button type="button" class="del">DEL</button> -->
		</div> 
	<button type="submit" id="btn">Add</button>
	</form>
	<script type="text/javascript" src="../resources/js/file.js"></script>
	
</body>
</html>