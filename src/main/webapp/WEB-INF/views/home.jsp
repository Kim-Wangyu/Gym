<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
	<c:import url="./template/header_css.jsp"></c:import>
    <link rel="stylesheet" href="/s1/resources/css/home.css">
   
</head>
<body>
<c:import url="./template/header.jsp"></c:import>
<h3> ${member.name}님 환영합니다</h3>

<a href="./notice/list">Notice List</a>
<a href="./qna/list">Qna List</a>
<a href="./exercise/list">Exercise List</a>
<c:if test="${member eq null}">
<a href="./member/join">Join</a>
<a href="./member/login">Login</a>
</c:if>
<c:if test="${member ne null}">
<a href="./member/logout">Logout</a>
<a href="./member/mypage">Mypage</a>
</c:if>


<P>  The time on the server is ${serverTime}. </P>
<div id="galleryCont">

 	<img src="/s1/resources/images/Logo.jpg" id="photo">
	<button id="cli" type="button">이전</button>
	<button id="cli1" type="button">다음</button>
	
</div>

<div id="btnBox">
<!-- 	<button id="cli" type="button">이전</button>
	<button id="cli1" type="button">다음</button> -->
</div>


<div class="wd1">
<ul class="wul">
    <li class="wli"><h1 class="lim"> Notice</h1>
        <c:forEach items="${list}" var="dto">
			<tr class="listNotice">
				<td> <a class="wa" href="./notice/detail?num=${dto.num}">
				${dto.title}</a></td>
            </tr>
        </c:forEach>
    </li>
    <li class="wli"><h1 class="lim">Exercise</h1>
            <c:forEach items="${list1}" var="dto">
			<tr class="listExercise">
				<td> <a class="wa" href="./exercise/detail?num=${dto.num}">
				${dto.title}</a></td>
            </tr>
        </c:forEach>
    </li>
    <li class="wli"><h1 class="lim">Q&A</h1>
    	<c:forEach items="#{list2}" var="dto">
    	<tr class="listQna">
    		<td> <a class="wa" href="./qna/detail?num=${dto.num}">
    		${dto.title}</a></td>
    		</tr>
    	</c:forEach>
    </li>
</ul>
</div>

<h1 id="title">BEFORE & AFTER</h1>
<div class="beforeImage">
	<img id="imagee" alt="" src="/s1/resources/images/womanBefore.jpg">
	<img id="imagee1" alt="" src="/s1/resources/images/manBefore.jpg">
	<img id="imagee2" alt="" src="/s1/resources/images/bodyBefore.jpg">
	<img id="imagee3" alt="" src="/s1/resources/images/woBefore.jpg">
</div>

	<div id="bottomBox">
		<div class="bottom">
			<ul id="boliBox">
				<li class="boli">소개 <img class="bp" src="/s1/resources/images/intro.jpg"></li>
				<li class="boli">ceo인사말 <img class="bp" src="/s1/resources/images/ceo.jpg"></li>
				<li class="boli">찾아오는길 <img class="bp" src="/s1/resources/images/map.jpg"> </li>
			</ul>
		</div>
		<div class="bottom">
			<h1>오늘 흘린 땀이 내일의 근육이 된다.</h1>
		</div>
		
	</div>
	<div id="lastBox">
		<div id="last1">
			<img src="/s1/resources/images/Logo.jpg" id="lastLogo">
		</div>
		<div id="last2">
		<h5>(주)러브 휘트니스 사업자 번호 : 123-12-12345   주소 : 서울 마포구 월드컵북로 21 2층 풍성빌딩<br></h5>
		<h5>TEL : 1588-1588 FAX : 0123-123-1234   EMAIL : www.sist.co.kr <br>
		COPYRIGHT(c) 2020 러브 휘트니스, ALL RIGHTS RESERVED. 홈페이지제작 4조<br>
		홈페이지 화면 및 사진은 저작권관련 무단전재 및 재배포를 금지하며, 이로 인하여 민형사상 불이익을 받을 수<br>
		모든 권리 및 저작권은 러브휘트니스에 귀속되어 있습니다.
		</h5>
		
		</div>
	</div>



	<script src="./resources/js/homePage.js"></script>
</body>
</html>
