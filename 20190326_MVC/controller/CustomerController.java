package mvc.controller;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import mvc.dao.CustomerDAO;
import mvc.service.CustomerService;
import mvc.vo.Customer;

//FrontController에서 넘어온 요청을 DAO에 넘겨서 작업 지시하는 객체
//DAO한테서 받은 결과를 저장(Request)하고 JSP로 넘어감.(Forward) -> req가 계속 가져가짐.
public class CustomerController {
	CustomerService dao = new CustomerDAO(); //외부에 공개하는 용도. 
	
	public void list(HttpServletRequest req, HttpServletResponse res) {
		ArrayList<Customer> list = dao.selectAll();
		req.setAttribute("list",list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/list.jsp");
		try{
			dispatcher.forward(req,res);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void delete(HttpServletRequest req, HttpServletResponse res) {
		String num = req.getParameter("num");
		dao.delete(num);
		list(req,res);
	}
	
	public void insertData(HttpServletRequest req, HttpServletResponse res) {
		String num = req.getParameter("num");
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		
		dao.insert(new Customer(num,name,address));
		list(req,res);
	}
	
	
	public void insert(HttpServletRequest req, HttpServletResponse res) {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/insertForm.jsp");
		try{
			dispatcher.forward(req,res);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void read(HttpServletRequest req, HttpServletResponse res) {
		String num = req.getParameter("num");
		Customer c = dao.selectOne(num); //dao 함수 사용.
		
		req.setAttribute("c",c);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/read.jsp"); //read로 넘김(결과)
		try{
			dispatcher.forward(req,res);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
