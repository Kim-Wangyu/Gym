<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
	<form action="./login" method="post">
		ID<input type="text" name="id" value="${cookie.rememberid.value}">
		PW<input type="password" name="pw">
		Id저장<input type="checkbox" name="remember" value="1">
		<button type="submit">login</button>
	</form>
	</div>
</body>
</html>