<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include1.jsp</title>
</head>
<body>
	안녕하세요. 쇼핑몰 중심 JSP 시작입니다!!!
	<br>
	<!-- duke_image.jsp 를 동적으로 전달 -->
	<jsp:include page="duke_image.jsp" flush="true">
		<jsp:param name="name" value="듀크" />
		<jsp:param name="imgName" value="duke.jpg" />
	</jsp:include>
	<!-- param 액션 태그를 이용해 duke_image.jsp로 이름과 파일 이름을 전달 한다 -->
	<br>
  안녕하세요. 쇼핑몰 중심 JSP 끝 부분입니다.!!! 
</body>
</html>