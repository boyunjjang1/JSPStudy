<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");
	// request 내장 객체에 바인딩 함
	request.setAttribute("id","hong");
	request.setAttribute("pwd","1234");
	// session 내장 객체에 바인딩 함
	session.setAttribute("name","홍길동");
	// application 내장 객체에 바인딩 함 
	application.setAttribute("emial", "hong@test.com");
%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward1</title>
</head>
<body>
	<!-- member1.jsp로 포워딩 한다. -->
	<jsp:forward page="member1.jsp" />
</body>
</html>