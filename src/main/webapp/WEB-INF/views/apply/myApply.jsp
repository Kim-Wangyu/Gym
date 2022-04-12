<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../resources/css/myApply.css" rel="stylesheet">
</head>
<body>
	<h1>My Apply Page</h1>
	<div style="display: flex" id="myApplyDiv">
		<div>
			<table>
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
			<table>
				<tr>
					<th>날짜</th>
					<th>시간</th>

				</tr>
				<c:forEach items="${list}" var="dto" varStatus="i">
					<tr>
						<th>${dto.day}</th>
						<th>${dto.time}</th>
						<th><button type="button" class="ApplyDelBtn" data-num="${dto.applyNum}" data-index="index${i.index}" >삭제</button></th>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<script type="text/javascript" src="../resources/js/myApply.js"></script>
</body>
</html>