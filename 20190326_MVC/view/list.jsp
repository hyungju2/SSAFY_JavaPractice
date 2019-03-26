<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">

</style>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<h1>Customer Data</h1>
	<table border="1">	
		<th>num</th><th>name</th>
		<tr>
		<c:forEach items="${list}" var="c">
			<td>${c.num }</td>
			<td><a href="read.mvc?num=${c.num }">${c.name }</a></td>
	
			<tr>
		</c:forEach>
	</table>
	<br>
	<a href="insertForm.mvc">고객추가</a>
</body>
</html>

