<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// session에 바인딩한 값은 같은 브라우저 내에서만 접근가능
// application의 값은 다른 브라우저에서도 접근가능
	String name = (String)session.getAttribute("name");
	String address = (String)application.getAttribute("address");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 스코프 테스트2, Application 내장 객체에 데이터 바인딩 실습2</title>
</head>
<body>
	<h1>이름은 <%=name %></h1>
	<h1>주소는 <%=address %></h1>
</body>
</html>