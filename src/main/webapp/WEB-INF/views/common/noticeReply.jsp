<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${noticeReply}" var="dto">
	<tr>
		<td id="up${dto.replyNum}">${dto.contents}</td>
		<td>${dto.writer}</td>
		
		<td>
		<c:if test="${dto.writer eq member.id}">
			<button class="update" type="button" data-index="${dto.replyNum}">UPDATE</button>
			<button class="del" type="button" data-num="${dto.replyNum}">DELETE</button>
		</td>
		</c:if>
	</tr>
	
	

</c:forEach>