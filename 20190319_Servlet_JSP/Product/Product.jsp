<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>상품 정보입니다</h1>
<% String name= request.getParameter("num");	
String price = request.getParameter("price");	
String info = request.getParameter("info");	
%>
<br>
<h2>ID    : <%=name %></h2>
<h2>Price : <%=price %></h2>
<h2>Info  : <%=info %></h2>
</body>
</html>