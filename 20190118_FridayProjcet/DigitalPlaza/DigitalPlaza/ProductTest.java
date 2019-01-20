package DigitalPlaza;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductTest {
	public static void main(String args[])
	{
		
	Scanner sc = new Scanner(System.in);
	
	ArrayList<Product> p = new ArrayList<>(); 
	
	ProductMgrImpl pm = new ProductMgrImpl();
	UserMgrImpl um = new UserMgrImpl();
	
	
	int T = 1;
	int index = 0;
	while(T!=0)
	{
		System.out.println("<<물품관리 프로그램>>");
		System.out.println("1. 물품 등록 ");
		System.out.println("2. 물품 검색 ");
		System.out.println("3. 물품 삭제 ");
		System.out.println("4. 회원 가입 ");
		System.out.println("5. 전체 회원 조회 ");
		System.out.println("6. 주문 하기 ");
		System.out.println("7. 주문 조회 ");
		System.out.println("8. 주문 삭제 ");
		System.out.println("9. 회원 탈퇴 "); 
		System.out.println("0. 종료 ");
		
		T = sc.nextInt();
		
		if(T==1)
		{
			System.out.println("제품명, 제품종류, 제품번호, 가격, 수량을 등록하세요 ");
			String name = sc.next();
			String kind = sc.next();
			int productnum = sc.nextInt();
			int price = sc.nextInt();
			int amount = sc.nextInt();
			Product pr = new Product(name, kind, productnum, price, amount);
			pm.add(pr);
		}
		
		if(T==2)
		{
			int num;
			System.out.println("1. 전체목록 검색");
			System.out.println("2. 이하가격 검색");
			System.out.println("3. 제품종류 검색");
			num = sc.nextInt();
			if(num==1)
			{
				System.out.println("=====전체 목록 검색=====");
			ArrayList<Product> pr = pm.search();
			int ind = 1;
			for(Product pp : pr)
			{
				if(pp!=null)
				{
					System.out.println(ind+": "+pp.toString());
					System.out.println("=============");
					ind++;
				}
			}
			}
			if(num==2)
			{
				System.out.println("가격을 입력하세요");
				int price = sc.nextInt();
				
			System.out.println("=====이하 가격 목록 검색=====");
			ArrayList<Product> pr = pm.search(price);
			int ind = 1;
			for(Product pp : pr)
			{
				if(pp!=null)
				{
					System.out.println(ind+": "+pp.toString());
					System.out.println("=============");
					ind++;
				}
			}
			}
			if(num==3)
			{
				System.out.println("검색하실 품목을 입력해주세요");
				String name = sc.next();
				System.out.println("=====품목 검색=====");
				ArrayList<Product> pr = pm.search(name);
				int ind = 1;
				for(Product pp : pr)
				{
					if(pp!=null)
					{
						System.out.println(ind+": "+pp.toString());
						System.out.println("=============");
						ind++;
					}
				}
			}
			
		}
		
		if(T==3)
		{
			System.out.println("삭제하실 물품의 번호를 입력");
			int num = sc.nextInt();
			pm.delete(num);
		}
		
		if(T==4)
		{
			System.out.println("회원 가입하실 ID, 이름, 번호, 연락처를 입력해주세요");
			
			String userId = sc.next();
			String userName = sc.next();
			int userNum = sc.nextInt();
			int userPhone = sc.nextInt();
			um.add(new User(userId, userName,userNum,userPhone));
			
		}
		
		if(T==5)
		{
			System.out.println("====전체 회원 목록입니다====");
			ArrayList<User> tmp = um.search();
			for(User u : tmp)
			{
				System.out.println(u.toString());
				System.out.println("==========");
			}
			
		}
		if(T==6) 
		{
			System.out.println("주문하실 회원의 ID와 품목을 입력해주세요");
			String userId = sc.next();
			String productname = sc.next();
			pm.ProductOrder(productname);
			um.order(userId, productname);		
			
		}
		
		if(T==7)
		{
			System.out.println("주문을 조회하실 회원님의 ID를 입력해주세요");
			String userId = sc.next();
			ArrayList<User> tmp = um.searchOrder(userId);
			for(User u : tmp)
			{
				System.out.println(u.toString());
				
			}
		}
		if(T==8)
		{
			System.out.println("주문을 삭제하실 회원님의 ID를 입력해주세요");
			String userId = sc.next();
			um.cancelorder(userId);

		}
		if(T==9)
		{
			System.out.println("회원삭제하실 ID를 입력해주세요");
			String userId = sc.next();
			um.removeuser(userId);
		}
	}//end of while 
	} //end of main
}//end of class 
