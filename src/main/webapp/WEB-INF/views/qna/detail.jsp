<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Qna Detail Page</h1>
	
	<h3>번호 : ${dto.num}</h3>
	<h3>제목 : ${dto.title}</h3>
	<h3>내용 : ${dto.contents}</h3>
	<h3>작성자 : ${dto.writer}</h3>
	
	<div>
      <input type="hidden" name="num" value="${dto.num}" id="num">
         <input type="text" readonly name="writer" value="${member.id}" id="writer">
         <textarea rows="" cols="" name="contents" id="contents"></textarea>
         <button type="button" id ="reply">Reply</button>
   </div>
   
   	<table id="replyResult">
		
	</table>
	
	<form id ="frm" method ="post">
		<input type="hidden" name ="num" id="num2" value ="${dto.num}">
	</form>
	
	<%-- 	<button id = "del" >DELETE</button> --%>
	<a href="#" id="del">DELETE</a>
	<a href="./update?num=${dto.num}">UPDATE</a>
	
	<a href="./list">LIST</a>
	
	<script src="../resources/js/qnaReply.js"></script>

</body>
</html>