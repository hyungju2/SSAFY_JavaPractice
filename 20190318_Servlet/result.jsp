<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	h1{
		color: blue;
	}
	h2{
		color: red;
	}
	
</style>
</head>
<body>
	<h1>result page</h1>
	<%
		String city = (String)request.getAttribute("city");	
		String age = (String)request.getAttribute("age");	
	%>
<h2><%=city %></h2>
<h2><%=age %></h2>

</body>
</html>