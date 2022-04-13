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
<link href="../resources/css/mypage.css" rel="stylesheet">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
		<div id="wrapper">
<div class="d1">
			<h1>Member Pw Update Page</h1>

			<form action="./pwupdate" method="post" id="form">

				<input type="hidden" name="id" value="${member.id}"> <input
					type="hidden" name="bpw" id="bpw" value="${member.pw}">
				<div class="d2">
				<h3>
					현재 비밀번호<input class="upgradeh3" type="password" id="pw1" name="pw1"
						style="margin-left: 36px;">
				</h3>
				<h3>
					수정 할 비밀번호<input class="upgradeh3" placeholder="6자리이상 10자리 이하"
						type="password" id="pw2" name="pw2">
				</h3>
				<div id="pwResult2"></div>
				<h3>
					비밀번호 확인<input class="upgradeh3" placeholder="6자리이상 10자리 이하"
						type="password" id="pw" name="pw" style="margin-left: 35px;">
				</h3>
				<div id="pwResult"></div>
				
				<a class ="mypagea" href="./mypage"> < my page</a>
				<button id="upgradebtn" type="button" >비밀번호 수정</button></div>
			</form>
		 <div>
        <img id="faqPic" alt="" src="/s1/resources/images/faqPic.jpg" style="width:550px;height:200px;margin-left:600px">
        </div>
		<script type="text/javascript" src="../resources/js/pwupdate.js"></script>
	</div>
	<footer>
		<c:import url="../template/bottom.jsp"></c:import>
	</footer>
	</div>
</body>
</html>