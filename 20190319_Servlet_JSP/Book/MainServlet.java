package com.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		//클라이언트로부터 전송되는 한글 처리
 		request.setCharacterEncoding("euc-kr"); //들어오는 타입을 한글 추가.
 		
 		response.setContentType("text/html;charset=euc-kr");
 		String action = request.getParameter("action");
 		System.out.println(action);
 		//1.클라이언트가 보낸 데이터 받기
 		
 		if(action.equals("Login")) {
 		String num = request.getParameter("num");
 		String pass = request.getParameter("pass");
 		
 		
 		if(num.equals("ssafy")&&pass.equals("1111"))
 		{
 			response.sendRedirect("html/Result.html");
 		}else {
 			RequestDispatcher dispatcher = request.getRequestDispatcher("html/error.jsp"); //css 적용할 수 있음. jsp로 넘기면 사용하기 쉬움
 			dispatcher.forward(request, response); //화면 넘김
 		}
 		}else {
 			request.setCharacterEncoding("euc-kr"); //들어오는 타입을 한글 추가.
 	 		
 	 		response.setContentType("text/html;charset=euc-kr");
 	 		PrintWriter out = response.getWriter();
 	 		
 	 		String fir =  request.getParameter("fir");
 	 		String mid =  request.getParameter("mid");
 	 		String last =  request.getParameter("last");
 	 		String tytle = request.getParameter("title");
 	 		String bookkind =  request.getParameter("bookkind");
 	 		String kind =  request.getParameter("kind");
 	 		String date =  request.getParameter("date");
 	 		String cor =  request.getParameter("cor");
 	 		String name = request.getParameter("name");
 	 		String price =  request.getParameter("price");
 	 		String comment =  request.getParameter("comment");
 	 		
 	 		out.print("도서번호");
 	 		out.print(fir+"-");
 	 		out.print(mid+"-");
 	 		out.print(last+""+"<br>");
 	 		out.print("종류");
 	 		out.print(kind+"<br>");
 	 		out.print("발행일");
 	 		out.print(kind+"<br>");
 	 		out.print("국외종류");
 	 		out.print(bookkind+"<br>");
 	 		out.print("종류");
 	 		out.print(kind+"<br>");
 	 		
 	 		out.print("발행일");
 	 		out.print(date+"<br>");
 	 		out.print("출판사");
 	 		out.print(cor+"<br>");
 	 		out.print("저자");
 	 		out.print(name+"<br>");
 	 		out.print("가격");
 	 		out.print(price+"<br>");
 	 		out.print("내용");
 	 		out.print(comment+"<br>");
 	 		out.print("<hr>");
 	 		out.println("<a href=\"html/Book.html\">추가하기</a>");
 		}
 	}

}
