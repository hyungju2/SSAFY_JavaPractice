<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1> Main 페이지</h1>
Welecome,,, <%= session.getAttribute("id") %>!!!
<hr>

<%
	ArrayList<String> dlist = (ArrayList<String>)session.getAttribute("list");
	
for(String color: dlist){
%>
	<p><%=color%></p>
	<%} %>

<a href="logout.jsp">logout</a>
</body>
</html>