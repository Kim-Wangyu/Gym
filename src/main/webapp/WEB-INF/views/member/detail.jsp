<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/header_css.jsp"></c:import>
<link href="../resources/css/detail.css" rel="stylesheet">
<link href="../resources/css/home.css" rel="stylesheet">
</head>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="d1">
	<h1>Member Detail Page</h1>
	<form action="./upgrade" method="post" id="detailForm">
		<input type="hidden" name="memberNum" value="${members.memberNum}">
		<h3>id : ${members.id}</h3>
		<h3>이름 : ${members.name}</h3>
		<h3>번호 : ${members.phone}</h3>
		<c:if test="${members.grade eq 0}">
			<h3>시작일 :  ${membership.startDate}</h3>
			<h3>종료일 :  ${membership.finishDate}</h3>
		</c:if>

		<c:if test="${member.grade eq 2}">
			<c:if test="${members.grade eq 0}">
			<div class="memberdetail" style="font-size: larger;font-weight: bold;">
				등급 :&nbsp<select  name="grade" class="gradeSelect">
					<option value="0" class ="gradeOption" selected="selected">회원</option>
					<option value="1" class ="gradeOption">트레이너</option>
				</select>
				</div>
				
			</c:if>
			<c:if test="${members.grade eq 1}">
			<div class="memberdetail"  style="font-size: larger;font-weight: bold;">
				등급 :&nbsp<select  name="grade" class="gradeSelect">
					<option value="0" class ="gradeOption">회원</option>
					<option value="1" class ="gradeOption" selected="selected">트레이너</option>
				</select>
			</div>
			</c:if>

		</c:if>
		<div id="priceDiv">
			<c:if test="${ members.grade eq 1 }">
			<div class="memberdetail" style="font-size: larger;font-weight: bold;">
				가격 :&nbsp<input style="width: 75px;" type="number" name = "price" value="${trainer.price}">
			</div>
			</c:if>
		</div>
		<c:if test="${member.grade eq 2}">
			<button type="button" id="detailBtn">저장</button>
		</c:if>
	</form>
</div>

	<c:import url="../template/bottom.jsp"></c:import>
	<script type="text/javascript" src="../resources/js/detail.js"></script>
</body>
</html>