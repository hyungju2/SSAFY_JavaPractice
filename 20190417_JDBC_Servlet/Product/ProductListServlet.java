package sevlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import dao.ProductDAO;
import vo.BookVO;
import vo.Product;

/**
 *  클라이언트의 요청을 받아, BookDAO를 이용해서 DB에 작업후 결과를 받아서 jsp 화면에 결과를 전달.
 *
 */
@WebServlet("/productList.do")

public class ProductListServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDAO productDAO = ProductDAO.getInstance();
		List<Product> productList = productDAO.selectAll(); 
		// attribute 에 실어 
		req.setAttribute("productList", productList);
		//bookList.jsp로 포워드
		req.getRequestDispatcher("/WEB-INF/jsp/productList.jsp").forward(req, resp);
		
	}
}
