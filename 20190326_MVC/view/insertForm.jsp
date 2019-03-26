<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="insertProcess.mvc">
	num: <input type="text" name="num"><br>
	name: <input type="text" name="name"><br>
	address: <input type="text" name="address"><br>
	<input type="reset" value="취소">
	<input type="submit" value="전송">
</form>
</body>
</html>