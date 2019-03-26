<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="hello" class="com.hello.HelloBean" scope="application"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
name: <%= hello.getName() %>
<% hello.setName("Temp"); %>
name: <%= hello.getName() %>
<hr>
<a href="helloBean2.jsp">helloBean2</a>
</body>
</html>