<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
<link href="../resources/css/table.css" rel="stylesheet"> 
<!-- <link href="../resources/css/list.css" rel="stylesheet">-->
<link href="../resources/css/list.css" rel="stylesheet">
</head>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="table_total">
	<h1>Member list page</h1>
	<div class="search">
		<form action="./list" method="get">
			이름<input type="text" name="search" value="${pager.search}">
			<button type="submit">검색</button>
		</form>
	</div>

		<table class="table_head">
			<tr>
				<th>id</th>
				<th>이름</th>
				<th>번호</th>
				<th>등급</th>
			
			</tr>

			<c:forEach items="${list}" var="member">
				<tr>
					<td>${member.id}</td>	
					<td><a href="./detail?memberNum=${member.memberNum}">${member.name}</td>
					<td>${member.phone}</td>
					
						<c:if test="${member.grade eq 0 }">
							<td>회원</td>
						</c:if>
						<c:if test="${member.grade eq 1 }">
							<td>트레이너</td>
						</c:if>
					
					
				
				</tr>
			</c:forEach>
		</table>

		<div class= "pager">
			<c:if test="${pager.pre}">
				<a href="./list?page=${pager.startPageNum-1}">이전</a>
			</c:if>
			<c:forEach begin="${pager.startPageNum}" end="${pager.lastPageNum}"
				var="i">
				<a href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a>
			</c:forEach>
			<c:if test="${pager.next}">
				<a href="./list?page=${pager.lastPageNum+1}">다음</a>
			</c:if>
		</div>
		
	
	</div>
	
</body>
</html>