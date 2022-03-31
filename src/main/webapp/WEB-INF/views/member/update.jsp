<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Member Update Page</h1>

<form action="./update" method="post">
		<input type="hidden" name="num"  value="${member.memberNum}">
		Id<input type="text" name="id" value="${member.id}" readonly="readonly">
		Name<input type="text" name="name" value="${member.name}" >
		Phone<input type="text" name="phone" value="${member.phone}">
		
		<button type="submit">수정</button>
	</form>

</body>
</html>