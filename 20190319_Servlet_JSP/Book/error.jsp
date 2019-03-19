<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>도서 정보 관리 ERROR!</h1>
<% String name= request.getParameter("num");	
String pw = request.getParameter("pass");	
%>
<br>
<h2>ID : <%=name %></h2>
<h2>PW : <%=pw %></h2>
<h2>아이디 또는 패스워드가 다릅니다.</h2>
</body>
</html>