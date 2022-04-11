<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="../template/header_css.jsp"></c:import>
    <link rel="stylesheet" href="/s1/resources/css/home.css">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div id="wrapper">
<h1>Member Update Page</h1>

<form action="./update" method="post">
		<input type="hidden" name="num"  value="${member.memberNum}">
		Id<input type="text" name="id" value="${member.id}" readonly="readonly">
		Name<input type="text" name="name" value="${member.name}" >
		Phone<input type="text" name="phone" value="${member.phone}">
		
		<button type="submit">수정</button>
	</form>
	</div>
	<footer>
	<c:import url="../template/bottom.jsp"></c:import>
	</footer>
</body>
</html>