package DigitalPlaza;
import java.util.ArrayList;

public class UserMgrImpl implements UserMgr {

	ArrayList<User> list;
	ArrayList<User> order;
	
	UserMgrImpl(){
		list = new ArrayList<>();
		order = new ArrayList<>();
	}
	private int index = 0;
	private int orderindex = 0;
	String [] orderproduct = new String[100];
	@Override
	public void add(User user) { //회원가입  
		list.add(user);
		index++;
	}

	@Override
	public void delete(int usernum) { //회원탈퇴  
		list.remove(usernum-1);
		index--; 
	}

	@Override
	public ArrayList<User> search() { //회원정보 전체검색
		return list;
	}
	
	public String orderproduct(int cnt) {
		return orderproduct[cnt];
	}

	@Override
	public ArrayList<User> search(String name) { //이름으로 회원정보 검색 
		ArrayList<User> tmp = new ArrayList<>();
		
		for(User u : list)
		{
			if(u.getUserName().equals(name))
				tmp.add(u);
		}
		return tmp;
	}

	@Override
	public void order(String userId, String productname) {
		
		String userName = "";
		int userNum= 0;
		int userPhone=0;
		
		for(User u : list)
		{
			if(u.getUserId().equals(userId))
			{
				userName = u.getUserName();
				userNum = u.getUserNum();
				userPhone = u.getUserPhone();
			}
		}
		User user = new User(userId,userName,userNum,userPhone);
		order.add(user);
		orderproduct[orderindex] = productname;
		orderindex++;
	} //주문 추가.

	@Override
	public void cancelorder(String username) {
		
		int ind = 0;
		int cnt = -1;
		for(User u : order)
		{
			cnt++;
			if(u.getUserId().equals(username))
			{
				ind = cnt;
			}
		}
		order.remove(ind);
		
	}

	@Override
	public ArrayList<User> searchOrder(String userId) {
		ArrayList<User> tmp = new ArrayList<>();
		
		int i=-1;
		
		int cnt = 0;
		for(User u : order)
		{
			i++;
			if(u.getUserId().equals(userId))
			{
				cnt = i;
				System.out.println(orderproduct(cnt)+"제품의 주문 내역입니다 ");
				tmp.add(u);
			}
		}
		
		
		return tmp;
	}

	@Override
	public void removeuser(String userId) {
		int i=-1;
		int cnt = 0;
	for(User u : list)
	{
		i++;
		if(u.getUserId().equals(userId))
		{
			cnt = i;
		}
	}
	list.remove(cnt);
	}
	
	

}//end of class
