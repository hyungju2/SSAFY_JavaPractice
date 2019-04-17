<%@page import="vo.BookVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<th width="200">isbn</th>		
			<th width="200">제품명</th>		
			<th width="200">종류</th>		
			<th width="200">회사</th>		
			<th width="200">가격(원)</th>		
		</tr>
		<!-- 반복 구조일 때는 jstl을 사용하여 쉽게 표현, request의 attribute에서 값을 꺼내기 -->
	
			<tr>
			<td align="center">${product.isbn }</td>
			<td align="center">${product.title}</td>
			<td align="center">${product.kind }</td>
			<td align="center">${product.maker }</td>
			<td align="center">${product.price }</td>
			</tr>
		
	<tr>
		<td colspan="5" align="right"><a href="addProduct.do">물품추가</a></td>
	</tr>
		
	
	</table>
</body>
</html>