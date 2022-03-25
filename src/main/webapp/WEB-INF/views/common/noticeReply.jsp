<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${noticeReply}" var="dto">
	<tr>
		<td id="up${dto.replyNum}">${dto.contents}</td>
		<td>${dto.writer}</td>
		
		<td>
			<button class="update" type="button" data-index="${dto.replyNum}">UPDATE</button>
		</td>
	</tr>
	
	

</c:forEach>