<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>로그아웃 되었습니다</h1>
<%
session.setAttribute("id", null);
session.setAttribute("pass", null);
%>
<a href=login.html>login</a>&nbsp;
<a href=main.jsp>main</a>
</body>
</html>