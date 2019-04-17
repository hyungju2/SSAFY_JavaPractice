package sevlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import vo.Product;


@WebServlet("/productSearch.do")
public class SearchProductServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDAO productDAO = ProductDAO.getInstance();
		Product temp = productDAO.selectOne(Integer.valueOf(req.getParameter("isbn"))); 
		// attribute 에 실어 
		req.setAttribute("product", temp);
		//bookList.jsp로 포워드
		req.getRequestDispatcher("/WEB-INF/jsp/productSearch.jsp").forward(req, resp);
		
	}
}
