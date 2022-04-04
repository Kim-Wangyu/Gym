<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<header class="header">
		<nav class="nav_main">
			<ul>
				<li><a href="/s1/"><img class="imgLogo" src="/s1/resources/images/Logo.jpg" alt=""></a></li>
				<li><a href="/s1/">HOME</a></li>
				<li><a href="/s1/notice/list"> Notice</a></li>
				<li><a href="/s1/exercise/list"> Exercise</a></li>
				<li><a href="/s1/qna/list"> Q&A</a></li>
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
