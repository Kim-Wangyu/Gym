<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../resources/css/myApply.css" rel="stylesheet">
<c:import url="../template/header_css.jsp"></c:import>
<link href="../resources/css/mypage.css" rel="stylesheet">
<link rel="stylesheet" href="/s1/resources/css/home.css">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="myapplypagediv" style="border-radius: 50px;">
	<h1>My Apply Page</h1>
	<div style="display: flex;justify-content: center;margin-top: 10px;border-radius: 50px;" id="myApplyDiv">
		<div>
			<table style="line-height: 30px;">
				<tr>
					<th>번호</th>
					<th>강사</th>
				</tr>
				<c:forEach items="${list2}" var="dto2" varStatus="i">
					<tr id="index${i.index}">
						<th>${i.index+1}번</th>
						<th class="th">${dto2.name}강사</th>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div>
			<table style="line-height: 30px;">
				<tr>
					<th>날짜</th>
					<th>시간</th>

				</tr>
				<c:forEach items="${list}" var="dto" varStatus="i">
					<tr>
						<th>${dto.day}</th>
						<th>${dto.time}</th>
						<th><button style="margin-left: 10px; border: solid 2px #ec3b3b;box-sizing: border-box;height: 30px;width: 100%;" type="button" class="ApplyDelBtn" data-num="${dto.applyNum}" data-index="index${i.index}" >삭제</button></th>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	</div>
	<div>
			<img id="faqPic" alt="" src="/s1/resources/images/faqPic.jpg"
				style="width: 550px; height: 200px; margin-left: 600px">
		</div>
	<script type="text/javascript" src="../resources/js/myApply.js"></script>
	<c:import url="../template/bottom.jsp"></c:import>
</body>
</html>