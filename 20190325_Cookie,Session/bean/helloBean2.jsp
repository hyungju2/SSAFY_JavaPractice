<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <jsp:useBean id="hello" class="com.hello.HelloBean" scope="application"/> <!--������ application�̰� �ϳ��� ��� �� -->
	 <!--������ page�̸�, ���� ����. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
name: <%= hello.getName() %>
</body>
</html>