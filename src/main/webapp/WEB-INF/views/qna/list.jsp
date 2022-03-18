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
	<h1>qna list page</h1>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성자</th>
		</tr>
		

		<c:forEach items="${list}" var="qna">
		<tr>
			<td>${qna.num }</td>
			<td><a href="./detail?num=${qna.num }">${qna.title }</td>
			<td>${qna.contents }</td>
			<td>${qna.writer }</td>
		</tr>
		</c:forEach>
		
		
		
	</table>
	<a href="./add">ADD</a>
</body>
</html>