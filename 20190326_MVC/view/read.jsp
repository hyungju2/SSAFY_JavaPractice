<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>Customer Detail Data</h1>

<table border="1">
	<tr>
		<td>${c.num }</td>
		<td>${c.name }</td>
		<td>${c.address }</td>
	<tr>
</table>
<br>
<a href="list.mvc">list로 돌아가기</a>
<a href="delete.mvc?num=${c.num }">데이터 삭제</a>
</body>
</html>