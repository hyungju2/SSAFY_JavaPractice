<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<%
	//post�� ��� ok, get�� ��� ��� ����
	request.setCharacterEncoding("utf-8");

	//client(html)�κ��� ���� ������ �ޱ�
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	//id = new String(id.getBytes("8859_1"), "utf-8");
	%>hello,,,<%= id %>...<br>password is...<%=pass %>
</body>
</html>