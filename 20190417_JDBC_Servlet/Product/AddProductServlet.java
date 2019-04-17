package sevlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import dao.ProductDAO;
import vo.BookVO;
import vo.Product;

@WebServlet("/addProduct.do")
public class AddProductServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/jsp/addProduct.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//addBook.jsp에서 폼테그로 받은 추가할 책 정보를 담아왔음
		req.setCharacterEncoding("EUC-KR");
		//파라미터로 넘어온 값을 꺼내서 BookVO 객체로 만들어서
		Product product = new Product();
		product.setIsbn(Integer.valueOf(req.getParameter("isbn")));
		product.setTitle((req.getParameter("title")));
		product.setKind(req.getParameter("kind"));
		product.setMaker(req.getParameter("maker"));
		product.setPrice(Integer.valueOf(req.getParameter("price")));
		
		// 데이터베이스에 INSERT 작업 진행 (BookDAO)
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.insertProduct(product);
		
		resp.sendRedirect("productList.do");
	
	}
}
