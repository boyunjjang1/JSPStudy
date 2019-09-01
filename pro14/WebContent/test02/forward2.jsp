<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="sec01.ex01.*"
%>
<%
	request.setCharacterEncoding("UTF-8");
	MemberBean member = new MemberBean("lee", "1234", "이순신", "lee@test.com");
	request.setAttribute("member", member);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberBean을 이용하여 member로 객체 바인딩</title>
</head>
<body>
	<jsp:forward page="member2.jsp" />
</body>
</html>