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
			<th width="200">��ǰ��</th>		
			<th width="200">����</th>		
			<th width="200">ȸ��</th>		
			<th width="200">����(��)</th>		
		</tr>
		<!-- �ݺ� ������ ���� jstl�� ����Ͽ� ���� ǥ��, request�� attribute���� ���� ������ -->
	
			<tr>
			<td align="center">${product.isbn }</td>
			<td align="center">${product.title}</td>
			<td align="center">${product.kind }</td>
			<td align="center">${product.maker }</td>
			<td align="center">${product.price }</td>
			</tr>
		
	<tr>
		<td colspan="5" align="right"><a href="addProduct.do">��ǰ�߰�</a></td>
	</tr>
		
	
	</table>
</body>
</html>