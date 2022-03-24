<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<h3> ${member.name}님 환영합니다</h3>

<a href="./notice/list">Notice List</a>
<a href="./qna/list">Qna List</a>
<a href="./exercise/list">Exercise List</a>
<c:if test="${member eq null}">
<a href="./member/join">Join</a>
<a href="./member/login">Login</a>
</c:if>
<c:if test="${member ne null}">
<a href="./member/logout">Logout</a>
<a href="./member/mypage">Mypage</a>
</c:if>


<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
