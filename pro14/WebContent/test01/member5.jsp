<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, sec01.ex01.*"
    isELIgnored="false"
%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="m1" class="sec01.ex01.MemberBean" />
<jsp:setProperty name="m1" property="*" />
<jsp:useBean id="membersList" class="java.util.ArrayList" />
<jsp:useBean id="membersMap" class="java.util.HashMap" />
<%-- userBean 태그를 사용하여 HaspMap객체를 생성함 --%>

<%
	// HaspMap에 key/value 쌍으로 회원 정보를 저장 함
	membersMap.put("id", "park2");
	membersMap.put("pwd","4321");
	membersMap.put("name","박지성");
	membersMap.put("emial","park2@test.com");
	
	MemberBean m2 = new MemberBean("son","1234","손흥민","son@test.com");
	membersList.add(m1);
	membersList.add(m2);
	// 회원 정보가 저장된 membersList를 membersList라는 key로 HaspMap에 저장 함
	membersMap.put("membersList", membersList);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HashMap 실습!!</title>
</head>
<body>
<table border=1  align="center" >
    <tr align=center bgcolor="#99ccff">
      <td width="20%"><b>아이디</b></td>
      <td width="20%"><b>비밀번호</b></td>
      <td width="20%" ><b>이름</b></td>
      <td width="20%"><b>이메일</b></td>
	</tr>
	<tr align="center">
	<!-- key를 사용하여 value를 가져옴 -->
		<td>${membersMap.id }</td>
		<td>${membersMap.pwd }</td>
		<td>${membersMap.name }</td>
		<td>${membersMap.emial }</td>
	</tr>
	<tr align=center>
      <td>${membersMap.membersList[0].id}</td>
      <td>${membersMap.membersList[0].pwd}</td>
      <td>${membersMap.membersList[0].name}</td>
      <td>${membersMap.membersList[0].email}</td>
   </tr>
   <tr align=center>
      <td>${membersMap.membersList[1].id}</td>
      <td>${membersMap.membersList[1].pwd}</td>
      <td>${membersMap.membersList[1].name}</td>
      <td>${membersMap.membersList[1].email}</td>
</tr>
</table>
</body>
</html>