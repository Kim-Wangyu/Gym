<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Qna Update Page</h1>

	<form action="./update" method="post">
		<input type="hidden" name="num" id ="num" value="${update.num }">
		Title<input type="text" name="title" id="title" value="${update.title }">
		Contents<textarea name ="contents" id ="contents" rows="" cols=""  >${update.contents }</textarea>
		
	
		<button type="submit">UPDATE</button>
	</form>

</body>
</html>