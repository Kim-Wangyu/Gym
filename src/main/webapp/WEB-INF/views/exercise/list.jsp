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
	<!-- 관리자 계정일시만 add -->
	<h1>Exercise List</h1>

	<table>
		<tr>
			<td>Num</td>
			<td>Title</td>
			<td>Contents</td>
		</tr>

		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.num}</td>
				<td><a href="./detail?num=${dto.num}">${dto.title}</a></td>
				<td>${dto.contents}</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<c:if test="${pager.pre}">
			<a href="./list?page=${pager.startPageNum-1}">PreView</a>
		</c:if>
		<c:forEach begin="${pager.startPageNum}" end="${pager.lastPageNum }"
			step="1" var="i">
			<a href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a>
		</c:forEach>
		<c:if test="${pager.next }">
			<a href="./list?page=${pager.lastPageNum+1}">Next</a>
		</c:if>
	</div>
	<div>
		<form action="./list" method="get">
			<fieldset>
				<select name="kind">
					<option value="col1">제목</option>
					<option value="col2">내용</option>
					<option value="col3">작성자</option>
				</select> <input type="text" name="search" value="${pager.search}">
				<button type="submit">검색</button>
			</fieldset>
		</form>
	</div>


	<a href="./add">Add</a>

</body>
</html>