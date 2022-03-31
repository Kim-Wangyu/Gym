<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Member Pw Update Page</h1>

	<form action="./pwupdate" method="post" id="form">
		
		<input type="hidden" name="id"  value="${member.id}">
		<input type="hidden" name="bpw" id="bpw" value="${member.pw}">
		
		현재 비밀번호<input type="password" id ="pw1" name="pw1">
		수정 할 비밀번호<input type="password" id ="pw2" name="pw2" >
		비밀번호 확인<input type="password"id ="pw" name="pw">
		
		<button type="submit" id="btn">수정</button>
	</form>
	
	<!-- <script type="text/javascript" src="../resources/js/pwupdate.js"></script> -->

</body>
</html>