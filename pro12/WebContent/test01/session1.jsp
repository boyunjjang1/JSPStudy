<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String)session.getAttribute("name");
	session.setAttribute("address", "서울시 강남구");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 테스트2</title>
</head>
<body>
<!-- Session 내장 객체에 데이터 바인딩 실습1 -->
	이름은 <%=name %> 입니다. <br>
	<a href=session3.jsp>세 번째 페이지로 이동</a>
</body>
</html>