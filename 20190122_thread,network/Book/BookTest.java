package Book;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
public class BookTest {

	public static void main(String[] args) throws Exception {
	int T=1;

	ArrayList<Book> b = new ArrayList<>();
	
	BookMgrImpl pm = new BookMgrImpl();
	
	Scanner sc = new Scanner(System.in);
	while(T!=0) {
	
	System.out.println("도서관리 프로그램");
	System.out.println("1. 도서 추가");
	System.out.println("2. 전체 도서 목록");
	System.out.println("3. 도서 판매");
	System.out.println("4. 도서 구매");
	System.out.println("5. 총 도서 재고금액 합계 ");
	System.out.println("6. 서버로 전송하기");
	System.out.println("0. 종료 ");
	System.out.println("==================");
	T = sc.nextInt();
	
	if(T==1)
	{
		System.out.println("1.도서추가, 2.잡지추가");
		int num = sc.nextInt();
			if(num==1)
			{
				System.out.println("책의 번호, 이름, 가격, 수량을 입력하세요");
				int isbn = sc.nextInt();
				String title = sc.next();
				int price = sc.nextInt();
				int amount = sc.nextInt();
				Book books = new Book(isbn,title,price,amount);
				pm.add(books);
			}
			if(num==2)
			{
				System.out.println("책의 번호, 이름, 가격, 수량, 발행년도를 입력하세요");
				int isbn = sc.nextInt();
				String title = sc.next();
				int price = sc.nextInt();
				int amount = sc.nextInt();
				int year = sc.nextInt();
				Magazine books = new Magazine(isbn,title,price,amount,year);
				pm.add(books);
			}
	} //end of T1
	if(T==2)
	{
		System.out.println("전체 도서목록입니다");
		ArrayList<Book> tmp = pm.search();
		for(Book books : tmp)
		{
			if(books.getQuantity()!=0)
			System.out.println(books.toString());
		}
		
	}//end of T2
	
	if(T==3)
	{
		System.out.println("도서 판매입니다");
		System.out.println("판매하실 도서 번호와 수량을 입력해주세요");
		int isbn = sc.nextInt();
		int quantity = sc.nextInt();
		pm.sell(isbn, quantity);
	}//end of T3
	if(T==4)
	{
		System.out.println("도서 구매입니다");
		System.out.println("구매하실 도서 번호와 수량을 입력해주세요");
		int isbn = sc.nextInt();
		int quantity = sc.nextInt();
		pm.buy(isbn, quantity);
	}//end of T4
	if(T==5)
	{
		int money = pm.getTotalAmount();
		System.out.println("총 재고의 총 금액 합입니다"
				+ "."+money);
	}//end of T5
	
	if(T==6)
	{
		System.out.println("서버로 전송합니다");
		pm.send();
		
	}//end of T6
	
	}//end of while

	pm.close();
	
	}//end of main
}//end of class
