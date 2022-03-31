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

<div id="galleryCont">
<p> <img src="/s1/resources/images/Logo.jpg" id="photo">
</p>
<p>
	<button onclick="changePic(0);">이전</button>
	<button onclick="changePic(1);">다음</button>
</p>
</div>

<div class="wd1">
<ul class="wul">
    <li class="wli"><h1> Notice</h1>
        <c:forEach items="${list}" var="dto">
			<tr class="listNotice">
				<td> <a class="wa" href="./notice/detail?num=${dto.num}">
				${dto.title}</a></td>
            </tr>
        </c:forEach>
    </li>
    <li class="wli"><h1>Exercise</h1>
            <c:forEach items="${list1}" var="dto">
			<tr class="listExercise">
				<td> <a class="wa" href="./exercise/detail?num=${dto.num}">
				${dto.title}</a></td>
            </tr>
        </c:forEach>
    </li>
    <li class="wli"><h1>Q&A</h1>
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







<script src="./resources/js/homePage.js"></script>
</body>
</html>
