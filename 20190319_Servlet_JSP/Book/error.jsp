<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>���� ���� ���� ERROR!</h1>
<% String name= request.getParameter("num");	
String pw = request.getParameter("pass");	
%>
<br>
<h2>ID : <%=name %></h2>
<h2>PW : <%=pw %></h2>
<h2>���̵� �Ǵ� �н����尡 �ٸ��ϴ�.</h2>
</body>
</html>