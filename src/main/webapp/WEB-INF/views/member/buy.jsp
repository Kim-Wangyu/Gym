<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>


	<h1>Buy Page</h1>


	<form action="./buy" method="post" id="form">
		<input type="hidden" name="memberNum" value="${member.memberNum}">
			<div>
			<select name="traNum" id="select2">	
			
				<option value="">이름 가격 운동종류</option>
				<c:forEach items="${list}" var="f">
					<option class="dataprice" data-price="${f.price}" value="${f.traNum}">${f.memberDTOs.name}   ${f.price}   ${f.category}</option>
				</c:forEach>
				   
			</select>
			<select id="select3" name="count">
				<option value="">신청 횟수</option>
				<option value="5">5</option>
				<option value="10">10</option>
				<option value="15">15</option>
				<option value="20">20</option>
			</select>
		</div>
		<div>
			<select id="select4" name="locker">
				<option value="">사물함 신청</option>
				<option value="1">예</option>
				<option value="0">아니요</option>
			</select> 
			<select id="select5" name="clothes">
				<option value="">운동복 신청</option>
				<option value="1">예</option>
				<option value="0">아니요</option>
			</select>
			총 가격<input type="text" name="price" id="sum" value="" readonly>
			
			<button id="btn" type="button">신청</button>

		</div>
	</form>
	<script type="text/javascript" src="../resources/js/buy.js"></script>
</body>
</html>