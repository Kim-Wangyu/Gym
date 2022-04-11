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
	<div id="wrapper">
		<h1>My page</h1>

		<h3 class="h3">이름 : ${member.name}</h3>
		<h3 class="h3">전화번호 : ${member.phone}</h3>
		<h3 class="h3">
			회원 사진<img alt=""
				src="../resources/upload/member/${member.memberFileDTO.fileName}" style="margin-left:10px;">
		</h3>

		<a class="mypagebtn" href="./pwupdate">비밀번호 수정</a> <a
			class="mypagebtn" href="./update">정보 수정</a>
		<c:if test="${member.grade==0}">
			<a class="mypagebtn" href="./buy">회원권 구매</a>
			<a class="mypagebtn" href="../apply/calendar">수강 신청</a>
		</c:if>
		<c:if test="${member.grade==1}">
			<a class="mypagebtn" href="../apply/calendar">pt시간 등록</a>
		</c:if>
		</div>
	<script type="text/javascript" src="../resources/js/mypage.js"></script>
	<footer>
	<c:import url="../template/bottom.jsp"></c:import>
	</footer>
	</div>
	<script type="text/javascript" src="../resources/js/mypage.js"></script>

>>>>>>> Add_css
</body>
</html>