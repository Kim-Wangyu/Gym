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
<a href="./notice/add">ADD</a>
</body>
</html>