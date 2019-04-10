package mvc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.controller.MemberController;

/**
 * Servlet Filter implementation class MemberFilter
 */
@WebFilter(urlPatterns="*.food")
public class MemberFilter implements Filter {
	MemberController controller;
	
    public MemberFilter() {}
	public void destroy() {}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		req.setCharacterEncoding("euc-kr");
		
		String reqString = req.getServletPath();
		
		if (reqString.equals("/addMember.food")) {
			controller.insertData(req, res);
		} else if (reqString.equals("/searchMember.food")) {
			controller.search(req, res);
		} else if (reqString.equals("/correctionMember.food")) {
			controller.correction(req, res);
		} else if (reqString.equals("/deleteMember.food")) {
			controller.delete(req, res);
		} else if (reqString.equals("/main.food")) {
			controller.main(req, res);
		} else if (reqString.equals("/login.food")) {
			controller.login(req, res);
		} else if (reqString.equals("/foodInfo.food")) {
			controller.foodInfo(req, res);
		} else if (reqString.equals("/search.food")) {
			controller.search(req, res);
		} else if (reqString.equals("/searchFood.food")) {
			controller.searchFood(req, res);
		} else if (reqString.equals("/SearchFoodResult.food")) {
			controller.searchFoodResult(req, res);
		} else if (reqString.equals("/logout.food")) {
			controller.logout(req, res);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		controller = new MemberController();
	}

}
