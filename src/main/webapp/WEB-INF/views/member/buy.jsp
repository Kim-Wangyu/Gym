<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<c:import url="../template/header_css.jsp"></c:import>
<link rel="stylesheet" href="/s1/resources/css/home.css">
<link rel="stylesheet" href="/s1/resources/css/calendar.css">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div id="wrapper">
		<div id="buydiv">
			<h1 style="margin-left: 5px">Buy Page</h1>
			<div class="container" style="position: relative;">
				<div style="width: 300px;">
					<div>
						<button type="button" id="preMonth">
							<i class="fa fa-chevron-left"></i>
						</button>
						<input type="number" id="year" value="2022"
							style="width: 80px; display: initial;" class="form-control" /> <select
							id="month" class="form-control"
							style="width: 80px; display: initial;">
							<option value="1">1월</option>
							<option value="2">2월</option>
							<option value="3">3월</option>
							<option value="4">4월</option>
							<option value="5">5월</option>
							<option value="6">6월</option>
							<option value="7">7월</option>
							<option value="8">8월</option>
							<option value="9">9월</option>
							<option value="10">10월</option>
							<option value="11">11월</option>
							<option value="12">12월</option>
						</select>
						<button type="button" id="nextMonth">
							<i class="fa fa-chevron-right"></i>
						</button>
					</div>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>일</th>
								<th>월</th>
								<th>화</th>
								<th>수</th>
								<th>목</th>
								<th>금</th>
								<th>토</th>
							</tr>
						</thead>
						<tbody id="tb_body"></tbody>
					</table>
				</div>

				<div>
					<img alt="" src="../resources/images/Logo.jpg"
						style="position: absolute; margin-left: 350px; margin-top: -350px">
				</div>
			</div>
			<form action="./buy" method="post" id="form">
				<input type="hidden" name="memberNum" value="${member.memberNum}">
				<div style="height: 35px;">
					&nbsp시작날짜&nbsp<input name="start" id="startDate" type="text"
						value="달력에서 시작날짜 클릭" readonly="readonly"> <select
						id=select6>
						<option value="">기간</option>
						<option value="1">1개월 12만원</option>
						<option value="3">3개월 30만원</option>
						<option value="6">6개월 50만원</option>
						<option value="12">12개월 80만원</option>
					</select> 종료날짜<input name="finish" id="finishDate" type="text" value=""
						readonly="readonly">
				</div>
				<div style="height: 35px;">
					&nbspPT 선택<select style="margin-left: 15px;" name="traNum"
						id="select2">

						<option value="">이름 가격</option>
						<c:forEach items="${list}" var="f">
							<option class="dataprice" data-price="${f.price}"
								value="${f.traNum}">${f.memberDTOs.name}${f.price}</option>
						</c:forEach>

					</select> <select id="select3" name="count">
						<option value="0">신청 횟수</option>
						<option value="5">5</option>
						<option value="10">10</option>
						<option value="15">15</option>
						<option value="20">20</option>
					</select>
				</div>
				<div style="height: 35px;">
					&nbsp선택<select style="margin-left: 38px;" id="select4"
						name="locker">
						<option value="0">사물함 신청</option>
						<option value="1">예</option>
						<option value="0">아니요</option>
					</select> <select id="select5" name="clothes">
						<option value="0">운동복 신청</option>
						<option value="1">예</option>
						<option value="0">아니요</option>
					</select>
				</div>
				<div style="height: 35px;">
					&nbsp총 가격<input style="margin-left: 17px;" type="text" name="price"
						id="sum" value="" readonly>

					<button id="btn" type="button">신청</button>
				</div>
		</div>
		</form>
		<script type="text/javascript" src="../resources/js/buy.js"></script>
		<script src="../resources/js/calendar.js"></script>
		<div>
			<img id="faqPic" alt="" src="/s1/resources/images/faqPic.jpg"
				style="width: 550px; height: 200px; margin-left: 600px; margin-top: 30px;">
		</div>
	</div>

	

</body>
</html>