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
 <link rel="stylesheet" href="/s1/resources/css/etc.css">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<h1>Intro Page</h1>

<div id="galleryCont">

 	<img src="/s1/resources/images/Logo.jpg" id="photo">
	<button id="cli" type="button">이전</button>
	<button id="cli1" type="button">다음</button>
	
</div>
<div id="gridT">
<div id="tab">
	<ul>
		<li><h1 class="tabText">소개</h1></li>
		<li><h1 class="tabText">인사말</h1></li>
		<li><h1 class="tabText">찾아오는길</h1></li>
	</ul>
</div>

<div id="tex">
<h1>인사말 <br>
오랜 경력과 친절한 노하우,</h1><h1 id="red"> Wellgym Fitness Center</h1>
<h1>다양한 운동기구를 통해 즐기면서 운동 할 수 있도록 도와드리겠습니다.</h1>
<hr width="5px">
<h3>
안녕하세요. 웰짐휘트니스 홈페이지에 방문하신 것을 환영 합니다.<br>
운동을 열심히 하는 것도 중요하지만 어떤 환경 속에서 운동을 하는지도 중요합니다.
고객님들이 사용하는데 있어 불편함을 느끼지 않도록 철저히 관리하고 있는 휘트니스! 웰짐휘트니스 입니다.<br>

오랜 경력과 친절한 노하우, 다양한 운동기구를 통해 즐기면서 운동 할 수 있도록 도와드리겠습니다.
헬스, 플라잉요가, 스피닝 등 다양한 운동프로그램이 준비되어 있습니다.<br>
<img alt="" src="/s1/resources/images/intro1.jpg" class="introPic">
<img alt="" src="/s1/resources/images/intro2.jpg" class="introPic">
<br>
운동을 하시기 전 힘을 빼지 않도록 엘리베이터가 준비가 되어 있으니 편하게 올라오실 수 있습니다.

자신이 하고 싶은 운동기구가 있을 것이고 자신에게 어울리는 운동기구가 있기 마련인데 
요즘 휘트니스는 운동을 하고자 하는 사람들이 많아 대기시간이 많이 걸리게 되는데 웰짐휘트니스에서는
 그러한 점을 미리 캐치를 해 다양한 운동기구를 많이 구비해 놨으니 이젠 더 이상 기다리지 마시고 
 자신이 하고 싶은 운동기구로! 자신에게 맞는 운동기구로 운동하실 수 있습니다.
 <img alt="" src="/s1/resources/images/intro3.jpg" class="introPic">
 <img alt="" src="/s1/resources/images/intro4.jpg" class="introPic">
</h3>

</div>
</div>

<c:import url="../template/bottom.jsp"></c:import>
	<script src="/s1/resources/js/etc.js"></script>
</body>
</html>