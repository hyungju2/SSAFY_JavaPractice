package sevlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import vo.BookVO;

@WebServlet("/addBook.do")
public class AddBookServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/jsp/addBook.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//addBook.jsp에서 폼테그로 받은 추가할 책 정보를 담아왔음
		req.setCharacterEncoding("EUC-KR");
		//파라미터로 넘어온 값을 꺼내서 BookVO 객체로 만들어서
		BookVO book = new BookVO();
		book.setTitle(req.getParameter("title"));
		book.setPublisher(req.getParameter("publisher"));
		book.setYear(req.getParameter("year"));
		book.setPrice(Integer.valueOf(req.getParameter("price")));
		// 데이터베이스에 INSERT 작업 진행 (BookDAO)
		BookDAO bookDAO = BookDAO.getInstance();
		bookDAO.insertBook(book);
		
		//도서의 전체목록을 보여주는 BookList.do로 리다이렉션하자.
		resp.sendRedirect("bookList.do");
	
	}
}
