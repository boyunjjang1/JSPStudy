<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("name", "보유미");
	request.setAttribute("address","제주특별자치도");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>첫 번째 JSP</title>
</head>
<body>
<%
	// request 객체를 다른 JSP로 포워딩 함
	// RequestDispatcher ? 클라이언트로부터 최초에 들어온 요청을 JSP/Servlet 내에서 자원으로 넘기는 역할 수행
	RequestDispatcher dispatch = request.getRequestDispatcher("request2.jsp");
	dispatch.forward(request,response);
	
	//==> 즉, request1.jsp 로 요청을 하면 request 객체에 바인딩한 후 request2.jsp로 포워딩 함
%>
</body>
</html>