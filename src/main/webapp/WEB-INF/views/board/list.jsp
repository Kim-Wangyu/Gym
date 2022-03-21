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
<h1>List Page</h1>

<table>
	<thead>
		<tr>
			<th>Title</th>
			<th>Contents</th>
			<th>Writer</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td> <a href="./detail?num=${dto.num}">
				${dto.title}</a></td>
				<td>${dto.contents}</td>
				<td>${dto.writer}</td>
			</tr>
		</c:forEach>
		
	</tbody>
			

</table>

<div>
	<c:if test="${pager.pre}">
		<a href="./list?page=${pager.startNum-1}">PREVIEW</a>
	</c:if>

	<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
		<a href="./list?page=${i}">${i}</a>
	</c:forEach>

	<c:if test="${pager.next}">
		<a href="./list?page=${pager.lastNum+1}">NEXT</a>
	</c:if>


</div>

<a href="./add">ADD</a>
</body>
</html>