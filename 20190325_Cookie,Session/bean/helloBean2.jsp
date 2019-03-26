<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <jsp:useBean id="hello" class="com.hello.HelloBean" scope="application"/> <!--범위가 application이게 하나로 계속 씀 -->
	 <!--범위가 page이면, 새로 만듦. -->
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