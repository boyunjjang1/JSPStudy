<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
<%
	// 각 내장 객체에 바인딩 된 속성 값들을 getAttribute() 메서드를 이용해 가져옴
   request.setCharacterEncoding("UTF-8");
   String id= (String)request.getAttribute("id");
   String pwd= (String)request.getAttribute("pwd");
   String name= (String)session.getAttribute("name");
   String emial= (String)application.getAttribute("emial");
  
%>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
	<table border="1"  align="center" >
    <tr align="center" bgcolor="#99ccff">
      <td width="20%"><b>아이디</b></td>
      <td width="20%"><b>비밀번호</b></td>
      <td width="20%" ><b>이름</b></td>
      <td width="20%"><b>이메일</b></td>
   </tr>
   <tr align="center">
      <td><%=id %> </td>
      <td><%=pwd%> </td>
      <td><%=name %> </td>
      <td><%=emial %> </td>
   </tr>   
   <tr align="center">
      <td>${id} </td>
      <td>${pwd} </td>
      <td>${name} </td>
      <td>${emial}</td>
   </tr>
</table>
</body>
</html>