<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Qna Detail Page</h1>
	
	<h3>번호 : ${detail.num }</h3>
	<h3>제목 : ${detail.title }</h3>
	<h3>내용 : ${detail.contents }</h3>
	<h3>작성자 : ${detail.writer }</h3>
	
	<a href="./update?num=${detail.num}">UPDATE</a>
	<a href="./delete?num=${detail.num}">DELETE</a>
	

</body>
</html>