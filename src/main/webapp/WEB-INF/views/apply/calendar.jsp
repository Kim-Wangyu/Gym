<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<c:import url="../template/header_css.jsp"></c:import>
<link rel="stylesheet" href="/s1/resources/css/home.css">
<link rel="stylesheet" href="/s1/resources/css/calendar.css">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
    <div class="container" style="position:relative;">
    <div id="calendardiv">
    <c:if test="${member.grade eq 0 }">
		<h2 style="margin-left:5px;margin-bottom:10px">수강신청 Page</h2>
	</c:if>
	<c:if test="${member.grade eq 1 }">
		<h2 style="margin-left:5px;margin-bottom:10px;position: relative;z-index: 1;">트레이너 pt 시간 등록 Page</h2>
	</c:if>
        <div style="width:300px;">
        	<div>
        		<button type="button" id="preMonth"><i class="fa fa-chevron-left"></i></button>
                <input type="number" id="year" value="2022" style="width: 80px;display: initial;" class="form-control"/>
                <select id="month" class="form-control" style="width:80px;display: initial;" >
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
				<button type="button" id="nextMonth"><i class="fa fa-chevron-right"></i></button>
        	</div>
            <table class = "table table-bordered">
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
    	<img alt="" src="../resources/images/Logo.jpg" style="position: absolute; margin-left:350px;margin-top:-350px">
    </div>
    
    <div id="applyDiv" data-id="${member.grade}"></div>
    <div id="addDiv"></div>
    </div>
    	<div>
			<img id="faqPic" alt="" src="/s1/resources/images/faqPic.jpg"
				style="width: 550px; height: 200px; margin-left: 400px;margin-top:30px;position: relative;
    z-index: -5;">
		</div>
    </div>
    <script src="../resources/js/calendar.js"></script>
    <script src="../resources/js/apply.js"></script>
    <c:import url="../template/bottom.jsp"></c:import>
</body>
</html>