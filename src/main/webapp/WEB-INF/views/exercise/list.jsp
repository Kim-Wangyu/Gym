<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
			<td>Num</td><td>Title</td><td>Contents</td>
		</tr>
	
		<c:forEach items="${list}" var="dto" >
			<tr>
				<td>${dto.num}</td>
				<td><a href="./detail?num=${dto.num}">${dto.title}</a></td>
				<td>${dto.contents}</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="./add">Add</a>
	
</body>
</html>