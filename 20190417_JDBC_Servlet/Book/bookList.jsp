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
			<th width="200">å ��ȣ</th>		
			<th width="200">å ����</th>		
			<th width="200">���ǻ�</th>		
			<th width="200">�⵵</th>		
			<th width="200">����(��)</th>		
		</tr>
		<!-- �ݺ� ������ ���� jstl�� ����Ͽ� ���� ǥ��, request�� attribute���� ���� ������ -->
		<c:forEach var="book" items="${bookList}">
			<tr>
			<td align="center">${book.bookid }</td>
			<td align="center">${book.title }</td>
			<td align="center">${book.publisher }</td>
			<td align="center">${book.year }</td>
			<td align="center">${book.price }</td>
			</tr>
		</c:forEach>
<!-- ���� �߰���ư�� �����.
Ŭ���� addBook.do Get���
addBook.do �� ó���ϴ� Servlet
���������� addBook.jsp�� ������
addBook.jsp ȭ�鿡�� �߰��� ������ �Է¹޾ƿ�
addBook.do ���ƿͼ� �������� DB�� �����͸� INSERT
 -->		
	<tr>
		<td colspan="5" align="right"><a href="addBook.do">�����߰�</a></td>
	</tr>
		
		<%-- <%

		<!--  ����EL JSTL�� ���ٸ� -->
		<%
		List<BookVO> list = (List<BookVO>)request.getAttribute("bookList");
		%>
			for(int i=0; i<list.size(); i++){
				BookVO book = list.get(i);
		%>
		<tr>
			<td align="center"><%= book.getBookid() %></td>
			<td align="center"><%= book.getTitle() %></td>
			<td align="center"><%= book.getPublisher() %></td>
			<td align="center"><%= book.getYear() %></td>
			<td align="center"><%= book.getPrice() %></td>
		</tr>
			<%
			}
			%> --%>
			
	</table>
</body>
</html>