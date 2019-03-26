<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String id = (String)session.getAttribute("id");
	if(id == null){ //login x 
%>
	<a href="login.html">login</a>
	<%}else{ %>
		welecome, <%= id %>!
		<a href="logout.jsp">logout</a>
		<%} %>
</body>
</html>