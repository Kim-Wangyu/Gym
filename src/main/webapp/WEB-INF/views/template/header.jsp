<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<header class="header" >
		<nav class="nav_main" id="headerId" >
			<ul class="mainmenu">
				<li><a href="/s1/"><img class="imgLogo" src="/s1/resources/images/Logo.jpg" alt=""></a></li>
				<li><a class="heaback" href="/s1/">HOME</a>
					<ul class="submenu">
						<li class="sub1"><a href="./etc/intro">intro</a></li>
						<li><a href="./etc/greeting">guide</a></li>
						<li><a href="./etc/map">map</a></li>
					</ul>
				</li>
				<li><a class="heaback" href="/s1/notice/list"> Notice</a></li>
				<li><a class="heaback" href="/s1/exercise/list"> Exercise</a>
					<ul class="submenu">
						<li class="sub1"><a href="/s1/etc/trainers">PT trainer</a></li>
						<li>Pilates trainer</li>
					</ul>
				</li>
				<li><a href="/s1/qna/list"> Q&A</a>
					<ul class="submenu">
						<li class="sub1"><a href="/s1/etc/faq">자주묻는질문</a></li>
						<li>질문들</li>
					</ul>
				</li>
			</ul>
		</nav>
		
		<nav class="nav_sub">
			<ul>
			<c:choose>
				<c:when test="${not empty member}">
					<c:if test="${member.grade eq 2}">
	
						<li><a href="/s1/member/list">Upgrade</a>
					</c:if>
					<li><a href="/s1/member/mypage">Mypage</a></li>
					<li><a href="/s1/member/logout">Logout</a></li>
				</c:when>
				<c:otherwise>
				<li><a href="/s1/member/login">Login</a></li>
				<li><a href="/s1/member/join">Join</a></li>
					
				</c:otherwise>
			</c:choose>
				
			</ul>
		
		</nav>
		
	</header>
