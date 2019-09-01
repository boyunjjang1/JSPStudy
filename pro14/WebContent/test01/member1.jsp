<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>

<%
	request.setCharacterEncoding("UTF-8"); // 회원 정보를 표시하기 전에 인코딩 설정 해 줄것!!
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String emial = request.getParameter("emial");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
	<table border="1" align="center">
		<tr align="center" bgcolor="#99ccff">
	      <td width="20%"><b>아이디</b></td>
	      <td width="20%"><b>비밀번호</b></td>
	      <td width="20%" ><b>이름</b></td>
	      <td width="20%"><b>이메일</b></td>
  	 	</tr>
  	 	<tr>
  	 		<td><%=id %></td>
  	 		<td><%=pwd %></td>
  	 		<td><%=name %></td>
  	 		<td><%=emial %></td>
  	 	</tr>
  	 	<tr>
  	 		<td>${param.id }</td> <!-- param 객체를 이용하여 getParameter() 메서드를 이용하지 않고 바로 회원 정보 출력 -->
  	 		<td>${param.pwd }</td>
  	 		<td>${param.name }</td>
  	 		<td>>${param.emial }</td>
  	 	</tr>
	</table>
</body>
</html>