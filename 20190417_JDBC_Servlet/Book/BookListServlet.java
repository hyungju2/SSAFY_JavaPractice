package sevlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import vo.BookVO;

/**
 *  클라이언트의 요청을 받아, BookDAO를 이용해서 DB에 작업후 결과를 받아서 jsp 화면에 결과를 전달.
 *
 */
@WebServlet("/bookList.do")

public class BookListServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//BookDAO 에서 책의 리스트 조회
		BookDAO bookDAO = BookDAO.getInstance(); //싱글톤이라서 객체를 생성할 수 없다.
		List<BookVO> bookList = bookDAO.selectAll(); 
		
		// attribute 에 실어 
		req.setAttribute("bookList", bookList);
		
		//bookList.jsp로 포워드
		req.getRequestDispatcher("/WEB-INF/jsp/bookList.jsp").forward(req, resp);
		
	}
}
