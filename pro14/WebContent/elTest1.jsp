<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%> <!-- 표현 언어 기능을 활성화 한다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현 언어에서 사용되는 데이터들</title>
</head>
<body>
	<h1>표현언어로 여러가지 데이터 출력하기</h1>
	<h1>
		\${100 }: ${100 }<br>
		\${"안녕하세요" }: ${"안녕하세요" }<br>
		\${10+1 }: ${10+1 }<br>
		\${"10" +1 }: ${"10"+1 }<br>
		
		<%--\${null+10 }: ${null+10 }<br> --%> 
		<%--\${"안녕"+11 }: ${"안녕"+11 }<br> --%> 
		<%--\${"hello"+"world"}:${"hello"+"world"}<br> --%> 
		
		
		<!-- null + 10 == 10 -->
		<!-- 문자열과 숫자는 더할 수 없다 -->
	</h1>
</body>
</html>