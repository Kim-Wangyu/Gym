<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<input name="day" id = "day" type="text" value="${list.get(0).getDay()}" readonly="readonly">
	<select name = "memberNum" id="selectName">
		<c:forEach items="${traName}" var="dto1">
			<option value="${dto1.memberNum}" class="optionName"> 강사${dto1.name}</option>
		</c:forEach>
	</select>
	<select name = "time" id="time">
		<c:forEach items="${list}" var="dto2" varStatus="i">
			<c:if test="${i.first }"> 
				<!-- c:set  변수설정 변수이름:var 값: value scope="request" : 응답이 나갈때까지 변수사용가능(page안에서쓸거니 page로도 가능) -->
				<c:set var="traNum" value="${dto2.traNum}" scope="request"> 
				</c:set>
			</c:if>
			<c:if test="${dto2.traNum eq traNum}">
				<option>${dto2.time}</option>
			</c:if>
		</c:forEach>
	</select>
	<button type="button" id="applyButton">Apply</button>
	