<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%

	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	ArrayList<String> list = new ArrayList<>();
	list.add("red");
	list.add("blue");
	list.add("pink");
	
	//session에 저장하기
	session.setAttribute("id", id);
	session.setAttribute("pass", pass);
	session.setAttribute("list", list);
	response.sendRedirect("main.jsp");

%>
</body>
</html>

