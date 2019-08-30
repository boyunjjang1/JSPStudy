<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 입력 창</title>
</head>
<body>
<!-- out 내장 객체 이용해 데이터 출력하기 -->
	<form method="post" action="out2.jsp">
		이름 : <input type="text" name="name"><br>
		나이 : <input type="text" name="age"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>