package mvc.service;

import java.util.ArrayList;

import mvc.vo.Customer;

//client를 위한 서비스 내용을 표시. (서비스를 사용하는 사용자)

public interface CustomerService {
	public ArrayList<Customer> selectAll();
	public Customer selectOne(String num);
	public void insert(Customer c);
	public void delete(String num);
	
}
