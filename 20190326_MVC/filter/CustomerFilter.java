package mvc.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import mvc.controller.CustomerController;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

@WebFilter("*.mvc")
public class CustomerFilter implements Filter {
	
	CustomerController controller = new CustomerController();
	
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		req.setCharacterEncoding("euc-kr");
		
		
		//클라이언트로부터 들어오는 요청을 구분하는 문자열
		//http://localhost:8080/mvc/list.mvc
		//controller에게 pass하는 역할
		
		String reqString = req.getServletPath();
		if(reqString.equals("/list.mvc")) { //초기화면 요청
			controller.list(req,res);
		}else if(reqString.equals("/read.mvc")) { //상세정보 화면요청
			controller.read(req,res);
		}else if(reqString.equals("/insertForm.mvc")) {
			controller.insert(req, res);
		}else if(reqString.equals("/insertProcess.mvc")) {
			controller.insertData(req,res);
		}else if(reqString.equals("/delete.mvc")) {
			controller.delete(req, res);
		}
		
	}
	public void init(FilterConfig fConfig) throws ServletException {
		CustomerController controller = new CustomerController();
	}

}
