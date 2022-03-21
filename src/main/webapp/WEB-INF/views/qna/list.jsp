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
	
	<div>
		<c:if test="${pager.pre}">
			<a href="./list?page=${pager.startPage-1}">이전</a>
		</c:if>
		<c:forEach begin="${pager.startPage}" end="${pager.lastPage}" var="i">
			<a href="./list?page=${i}">${i}</a>
		</c:forEach>
		<c:if test="${pager.next}">
			<a href="./list?page=${pager.lastPage+1}">다음</a>
		</c:if>
	</div>
	
	
	<a href="./add">ADD</a>
</body>
</html>