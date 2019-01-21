package DigitalPlaza;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductTest {
	public static void main(String args[]) throws Exception
	{
		
	Scanner sc = new Scanner(System.in);
	
	ArrayList<Product> p = new ArrayList<>(); 
	
	ProductMgrImpl pm = new ProductMgrImpl();

	
	
	int T = 1;
	int index = 0;
	while(T!=0)
	{
		System.out.println("<<물품관리 프로그램>>");
		System.out.println("1. 물품 등록 ");
		System.out.println("2. 물품 검색(상품번호) ");
		System.out.println("3. 냉장고 크기검색 ");
		System.out.println("4. TV 사이즈 검색 ");
		System.out.println("5. 제품 삭제 ");
		System.out.println("6. 물품 전체 조회 ");
		
		System.out.println("0. 종료 ");
		
		T = sc.nextInt();
		
		if(T==1)
		{
			System.out.println("1. 냉장고, 2. TV");
			int num = sc.nextInt();
			if(num==1)
			{
			System.out.println("제품명, 제품종류, 제품번호, 가격, 수량, 크기를 등록하세요 ");
			String name = sc.next();
			String kind = sc.next();
			int productnum = sc.nextInt();
			int price = sc.nextInt();
			int amount = sc.nextInt();
			int size = sc.nextInt();
			TV tv = new TV(name, kind, productnum, price, amount,size);
			pm.add(tv);
			}
			
			if(num==2)
			{
			System.out.println("제품명, 제품종류, 제품번호, 가격, 수량, 용량를 등록하세요 ");
			String name = sc.next();
			String kind = sc.next();
			int productnum = sc.nextInt();
			int price = sc.nextInt();
			int amount = sc.nextInt();
			int capacity = sc.nextInt();
			Refrigerator rf = new Refrigerator(name, kind, productnum, price, amount, capacity);
			pm.add(rf);
			}
		}
		if(T==2)
		{
			System.out.println("상품 번호를 입력하세요");
			int num = sc.nextInt();
			ArrayList<Product> tmp = pm.search(num);
			for(Product ps: tmp)
			{
				System.out.println(ps.toString());
			}
		}
		if(T==3)
		{
			System.out.println("냉장고 크기를 입력하세요.");
			int num = sc.nextInt();
			ArrayList<Product> tmp = pm.searchRef(num);
			for(Product ps: tmp)
			{
				System.out.println(ps.toString());
			}
		}
		if(T==4)
		{
			System.out.println("티비 크기를 입력하세요.");
			int num = sc.nextInt();
			ArrayList<Product> tmp = pm.searchTv(num);
			for(Product ps: tmp)
			{
				System.out.println(ps.toString());
			}
		}
	
		if(T==5)
		{
			System.out.println("삭제하실 물품의 번호를 입력하세요");
			int productnum = sc.nextInt();
			pm.delete(productnum);
		}
		
		if(T==6)
		{
			System.out.println("====전체 물품 목록입니다====");
			ArrayList<Product> tmp = pm.search();
			
			for(Product ps : tmp)
			{
				System.out.println(ps.toString());
			}
		}

	}//end of while 
	pm.close();
	} //end of main
}//end of class 
