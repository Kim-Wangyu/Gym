<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<header class="header" >
		<nav class="nav_main" id="headerId" >
			<ul class="mainmenu">
				<li><a href="/s1/"><img class="imgLogo" src="/s1/resources/images/Logo.jpg" alt=""></a></li>
				
				<li>
				
				<a href="/s1/" class="listmenu"><img alt="" src="/s1/resources/images/dumbbel.jpg" class="dumbbelimg"> HOME</a>
					<ul class="submenu">
						<li class="sub1"><a href="/s1/etc/intro">intro</a></li>
						<li><a href="/s1/etc/greeting">guide</a></li>
						<li><a href="/s1/etc/map">map</a></li>
					</ul>
				</li>
				<li><a href="/s1/notice/list"class="listmenu"> <img alt="" src="/s1/resources/images/dumbbel.jpg" class="dumbbelimg"> Notice</a></li>
				<li><a href="/s1/exercise/list"class="listmenu"><img alt="" src="/s1/resources/images/dumbbel.jpg" class="dumbbelimg">  Exercise</a>
					<ul class="submenu">
						<li class="sub1"><a href="/s1/etc/trainers">PT trainer</a></li>
						<li>Pilates trainer</li>
					</ul>
				</li>
				<li><a href="/s1/qna/list"class="listmenu"><img alt="" src="/s1/resources/images/dumbbel.jpg" class="dumbbelimg"> Questions</a>
					<ul class="submenu">
						<li class="sub1"><a href="/s1/etc/faq">FAQ</a></li>
						<li><a href="/s1/qna/list">Q&A</a></li>
					</ul>
				</li>
			</ul>
		</nav>
		
		<nav class="nav_sub">
			<ul>
			<c:choose>
				<c:when test="${not empty member}">
					<c:if test="${member.grade eq 2}">
	
						<li><a href="/s1/member/list"class="listmenu"><img alt="" src="/s1/resources/images/dumbbel.jpg" class="dumbbelimg">Upgrade</a>
					</c:if>
					<li><a href="/s1/member/mypage"class="listmenu"><img alt="" src="/s1/resources/images/dumbbel.jpg" class="dumbbelimg">Mypage</a></li>
					<li><a href="/s1/member/logout"class="listmenu"><img alt="" src="/s1/resources/images/dumbbel.jpg" class="dumbbelimg">Logout</a></li>
				</c:when>
				<c:otherwise>
				<li><a href="/s1/member/login"class="listmenu"><img alt="" src="/s1/resources/images/dumbbel.jpg" class="dumbbelimg">Login</a></li>
				<li><a href="/s1/member/join"class="listmenu"><img alt="" src="/s1/resources/images/dumbbel.jpg" class="dumbbelimg">Join</a></li>
					
				</c:otherwise>
			</c:choose>
				
			</ul>
		
		</nav>
		
	</header>
