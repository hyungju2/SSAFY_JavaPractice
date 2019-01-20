package DigitalPlaza;
import java.util.ArrayList;

public interface UserMgr {

	public void add(User user); //회원가입 
	public void delete(int usernum); //회원탈퇴 
	public ArrayList<User> search(); //등록된 회원 전체검색
	public ArrayList<User> search(String name); //이름으로 회원 정보 검색 
	public void order(String username, String productname); //주문하기
	public void cancelorder(String username); //주문 취소
	public ArrayList<User> searchOrder(String username); //주문 확인 
	public void removeuser(String userId);
	
}
