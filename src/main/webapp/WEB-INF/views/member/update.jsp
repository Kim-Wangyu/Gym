<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
<link href="../resources/css/mypage.css" rel="stylesheet">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="d1">
<h1>Member Update Page</h1>

<form action="./update" method="post">
		<input type="hidden" name="num"  value="${member.memberNum}">
		
		<h3>ID <input class="updateh3" type="text" name="id" value="${member.id}" readonly="readonly"></h3>
		<h3>Name <input class="updateh3" type="text" name="name" value="${member.name}" ></h3>
		<h3>Phone <input class="updateh3" type="text" name="phone" value="${member.phone}"></h3>
		<a href="./mypage"> < my page</a>
		<button type="submit" id="updatebtn">수정</button>
	</form>
</div>
</body>
</html>