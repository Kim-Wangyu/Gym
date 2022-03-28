<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach items="${list}" var="dto">
	<tr>
		<td>작성자 : ${dto.writer}</td>
		<td>내용 : </td>
		<td id="up${dto.replyNum}">${dto.contents}</td>
		<td>
			<c:if test="${dto.writer eq member.id}">
				<button class="update" type="button" data-index="${dto.replyNum}">update</button>
				<button class="del" type="button" data-num="${dto.replyNum}">delete</button>
	 		</c:if>
	 	</td>
	</tr>

</c:forEach>