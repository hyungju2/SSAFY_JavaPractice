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
			<th width="200">책 번호</th>		
			<th width="200">책 제목</th>		
			<th width="200">출판사</th>		
			<th width="200">년도</th>		
			<th width="200">가격(원)</th>		
		</tr>
		<!-- 반복 구조일 때는 jstl을 사용하여 쉽게 표현, request의 attribute에서 값을 꺼내기 -->
		<c:forEach var="book" items="${bookList}">
			<tr>
			<td align="center">${book.bookid }</td>
			<td align="center">${book.title }</td>
			<td align="center">${book.publisher }</td>
			<td align="center">${book.year }</td>
			<td align="center">${book.price }</td>
			</tr>
		</c:forEach>
<!-- 도서 추가버튼을 만들고.
클릭시 addBook.do Get방식
addBook.do 를 처리하는 Servlet
서블릿에서는 addBook.jsp에 포워드
addBook.jsp 화면에서 추가할 정보를 입력받아옴
addBook.do 돌아와서 서블릿에서 DB에 데이터를 INSERT
 -->		
	<tr>
		<td colspan="5" align="right"><a href="addBook.do">도서추가</a></td>
	</tr>
		
		<%-- <%

		<!--  만약EL JSTL이 없다면 -->
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