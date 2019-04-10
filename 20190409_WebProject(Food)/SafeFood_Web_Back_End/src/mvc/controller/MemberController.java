package mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.dao.MemberDAO;
import mvc.service.MemberService;
import mvc.vo.Member;

//FrontController에서 넘어온 요청을 DAO에 넘겨서 작업 지시하는 객체
//DAO한테서 받은 결과를 저장(Request)하고 JSP로 넘어감.(Forward) -> req가 계속 가져가짐.
public class MemberController {
    MemberService dao = new MemberDAO(); //외부에 공개하는 용도.
    
    public void delete(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    	String email = req.getParameter("email");
    	dao.delete(email);
    	RequestDispatcher dispatcher = req.getRequestDispatcher("view/RemoveResult.jsp");
        dispatcher.forward(req, res);
    }
    
    public void insertData(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String phoneNumber = req.getParameter("phoneNumber");
        String[] allergy = req.getParameterValues("allergy");
        ArrayList<String> arr = new ArrayList<>();
        
        for(int i=0; i<allergy.length; i++)
        	arr.add(allergy[i]);
        
        dao.add(new Member(email,password,name,address,phoneNumber,arr));
        result(req,res);
    }
    
    private void result(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email = req.getParameter("email");
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/Result.jsp"); //css 적용할 수 있음. jsp로 넘기면 사용하기 쉬움
        dispatcher.forward(req, res); //화면 넘김
    }


    public void login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Member temp = dao.login(email, password);
        
        if (temp.equals(null)) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("view/Error.jsp");
            dispatcher.forward(req, res);
        } else {
            req.setAttribute("loginID", temp);
            RequestDispatcher dispatcher = req.getRequestDispatcher("view/index_logined.jsp");
            dispatcher.forward(req,res);
        }
    }

    public void search(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	String email =req.getParameter("email");   
        Member temp = dao.search(email);
        String name = temp.getName();
        
        req.setAttribute("SearchName", name);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/Search.jsp");
        dispatcher.forward(req, res);
        
    }

    public void correction(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String phoneNumber = req.getParameter("phoneNumber");
        String[] allergy = req.getParameterValues("allergy");
        ArrayList<String> arr = new ArrayList<>();
        for(int i=0; i<allergy.length; i++)
        	arr.add(allergy[i]);

        dao.correction(new Member(email,password,name,address,phoneNumber,arr));
        main(req, res);
    }

    public void main(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    	RequestDispatcher dispatcher = req.getRequestDispatcher("view/index.jsp");
        dispatcher.forward(req,res);
    }
    
    public void foodInfo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	RequestDispatcher dispatcher = req.getRequestDispatcher("view/ProductInfo.jsp");
    	dispatcher.forward(req, res);
    }
    
    public void searchFood(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	RequestDispatcher dispatcher = req.getRequestDispatcher("view/ProductSearch.jsp");
    	dispatcher.forward(req, res);
    }
    
    public void searchFoodResult(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	RequestDispatcher dispatcher = req.getRequestDispatcher("view/ProductSearchResult.jsp");
    	dispatcher.forward(req, res);
    }
    
    public void logout(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	RequestDispatcher dispatcher = req.getRequestDispatcher("view/logout.jsp");
    	dispatcher.forward(req, res);	
    }
}