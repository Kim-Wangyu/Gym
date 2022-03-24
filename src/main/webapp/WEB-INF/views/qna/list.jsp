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
	
	<div>
		<form action="./list" method="get">
			<select name="kind">
				<option value="col1">제목</option>
				<option value="col2">내용</option>
				<option value="col3">작성자</option>
			</select>
			<input type="text" name="search" value="${pager.search }">
			<button type="submit">검색</button>
		</form>
	</div>
		
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
			<td><a href="./detail?num=${qna.num}">${qna.title }</td>
			<td>${qna.contents }</td>
			<td>${qna.writer }</td>
		</tr>
		</c:forEach>		
	</table>
	
	<div>
		<c:if test="${pager.pre}">
			<a href="./list?page=${pager.startPageNum-1}">이전</a>
		</c:if>
		<c:forEach begin="${pager.startPageNum}" end="${pager.lastPageNum}" var="i">
			<a href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a>
		</c:forEach>
		<c:if test="${pager.next}">
			<a href="./list?page=${pager.lastPageNum+1}">다음</a>
		</c:if>
	</div>
	
	
	<a href="./add">ADD</a>
</body>
</html>