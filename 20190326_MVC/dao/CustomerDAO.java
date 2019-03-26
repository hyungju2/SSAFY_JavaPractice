package mvc.dao;

import java.util.ArrayList;

import mvc.service.CustomerService;
import mvc.vo.Customer;

//실제로 DB작업하는 객체(Create,Read,Update,Delete)
//DAO(Data Access Object)
public class CustomerDAO implements CustomerService{
	ArrayList<Customer> list;
	public CustomerDAO() {
		//ArrayList생성, db 연결 준비 작업
		list = new ArrayList<>();
		list.add(new Customer("111","iu","seoul"));
		list.add(new Customer("222","nu","yeoksam"));
		list.add(new Customer("333","ou","samsan"));
	}
	
	@Override
	public ArrayList<Customer> selectAll() {
		//db에서 모든 데이터 가져와서 ArrayList에 넣어 리턴
		return list;
	}

	@Override
	public Customer selectOne(String num) {
		for (Customer c: list) {
			if(c.getNum().equals(num)) {
				return c;
			}
		}
		return null;
	}

	@Override
	public void insert(Customer c) {
		list.add(c);
	}

	@Override
	public void delete(String num) {
		int index=0;
		
		for(Customer c:list) {
			if(c.getNum().equals(num)) {
				{
					System.out.println("ttt");
					list.remove(index);
					break;
				}
			}
			index++;
		}
	}
}
