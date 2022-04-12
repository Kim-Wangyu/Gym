<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
	<c:import url="./template/header_css.jsp"></c:import>
    <link rel="stylesheet" href="/s1/resources/css/home.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons|Material+Icons+Outlined|Material+Icons+Two+Tone|Material+Icons+Round|Material+Icons+sharp"  rel="stylesheet">
    
</head>
<body>
<div id="wrapper">
<c:import url="./template/header.jsp"></c:import>
<c:if test="${member ne null}">
<h3 id="membername">
	${member.name}님
</h3>
	<span class="material-icons-wg">
		account_circle
	</span>
	
 	
</c:if>
<div id="galleryCont">

 	<img src="/s1/resources/images/img.jpg" id="photo">
 	<div id="gc">
		<button id="cli" type="button">이전</button>
	</div>
	<div id="gc1">
		<button id="cli1" type="button">다음</button>
	</div>
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
</div>
<footer>
<c:import url="./template/bottom.jsp"></c:import>
</footer>
	<script src="./resources/js/homePage.js"></script>

</body>
</html>
