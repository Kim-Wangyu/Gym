<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>My page</h1>
	<h3>생년월일
	성별
	남은기간
	운동복 락커 사용유무
	수강신청
	이름
	비밀번호는 수정
	전화번호 수정</h3>
	
	<h3>이름 : ${member.name}</h3>
	<h3>전화번호 : ${member.phone}</h3>
	
	<a href="./pwupdate">비밀번호 수정</a>
	<a href="./update">정보 수정</a>
	<a href="./buy">회원권 구매</a>
	
	
	<script type="text/javascript" src="../resources/js/mypage.js"></script>
	
</body>
</html>