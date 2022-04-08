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
<c:if test="${member ne null}">
<h3> ${member.name}님 환영합니다</h3>
</c:if>
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


<c:import url="./template/bottom.jsp"></c:import>

	<script src="./resources/js/homePage.js"></script>
</body>
</html>
