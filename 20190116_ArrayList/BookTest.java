package Book;
import java.util.ArrayList;
import java.util.Scanner;

import Book.Magazine;

public class BookTest {
	public static void main(String[] args) {
		
	
	Scanner sc = new Scanner(System.in);

	ArrayList<Book> bk = new ArrayList<>();
	
	BookMgrImpl mg = new BookMgrImpl();
	
	int T = 1;
	int index = 0;
	while(T!=0)
	{
		
		System.out.println("<<< 도서관리 프로그램 >>>");
		System.out.println("1. 책 입력 기능");
		System.out.println("2. 데이터  전체 검색");
		System.out.println("3. isbn으로  정보 검색");
		System.out.println("4. Title로 검색");
		System.out.println("5. Book만 검색");
		System.out.println("6. Magazine만 검색 ");
		System.out.println("7. Magazine중 올해 잡지만 검색");
		System.out.println("8. 출판사로 검색");
		System.out.println("9. 가격으로 도서 검색(이하)");
		System.out.println("10. 저장된 모든 도서의 금액 합계");
		System.out.println("11. 저장된 모든 도서의 금액 평균");
		System.out.println("0. 종료");
		System.out.println("===================================");
		T = sc.nextInt();
	
			if(T==1)
			{
				int num;
				System.out.println("1. Book등록. 2. Magazine 등록");
				num = sc.nextInt();
				if(num == 1)
				{
					
					int isbn,price,desc;
					String title,author,publisher;
					System.out.println("책 번호, 가격, desc, 제목, 작가, 출판사 입력");
					isbn = sc.nextInt();
					price = sc.nextInt();
					desc = sc.nextInt();
					title = sc.next();
					author = sc.next();
					publisher = sc.next();
					Book bks = new Book(isbn,price,desc,title,author,publisher);
					
					mg.add(bks);
				}
				else
				{
					int isbn,price,desc,year,month;
					String title,author,publisher;
					System.out.println("잡지 번호, 가격, desc, 년도, 월, 제목, 작가, 출판사 입력");
					isbn = sc.nextInt();
					price = sc.nextInt();
					desc = sc.nextInt();
					year = sc.nextInt();
					month = sc.nextInt();
					title = sc.next();
					author = sc.next();
					publisher = sc.next();
					mg.add(new Magazine(isbn, price, desc, title, author, publisher, year, month));
				}
			}
			else
				if(T==2)
				{
					ArrayList<Book> bks = mg.search();
					
					System.out.println("도서명 전체 검색");
					for(Book x : bks)
					{
						if(x!=null)
						{
							System.out.println(x.toString());
							System.out.println("===================================");
					}
					}
					
				}
			
				else
					if(T==3)
					{
						System.out.print("isbn으로 도서 검색");
						int num = sc.nextInt();
						ArrayList<Book> bks = mg.search(num);
						
						for(Book x : bks)
						{
							if(x!=null)
							{
							System.out.println(x.toString());
							System.out.println("===================================");
						}
						}
					}
					else
						if(T==4)
						{
							
							System.out.print("Title 검색");
							String title = sc.next();
							ArrayList<Book> bks = mg.search(title);
							
							for(Book x : bks)
							{
								if(x!=null)
								{
								System.out.println(x.toString());
								System.out.println("===================================");
								}
							}

						}
			
						else
							if(T==5)
							{
							
								System.out.println("책만 검색");
								ArrayList<Book> bks = mg.searchBook();
								
								for(Book x : bks)
								{
									if(x!=null)
										{
										System.out.println(x.toString());
										System.out.println("===================================");
										}
								}
							}
							else
								if(T==6)
								{
									ArrayList<Book> bks = mg.searchMagazine();
									System.out.println("잡지만 검색");
									for(Book x : bks)
									{
										if(x!=null)
										{	
											System.out.println(x.toString());
											System.out.println("===================================");
										}
									}
								}
								else
									if(T==7)
									{
										System.out.println("년도를 입력하세요");
										int year = sc.nextInt();
										
										ArrayList<Book> bks = mg.searchYear(year);
										
										for(Book x : bks)
										{
											if(x!=null)
											{	
												System.out.println(x.toString());
												System.out.println("===================================");
											}
										}
									}
									else
										if(T==8)
										{
											
											System.out.println("출판사 검색");
											String publisher = sc.next();
											ArrayList<Book> bks = mg.searchPublisher(publisher);
											
											for(Book x : bks)
											{
												if(x!=null)
													{System.out.println(x.toString());
													System.out.println("===================================");
											}
											}
										}
										else
											if(T==9)
											{
												System.out.println("이하 가격 검색");
												int price = sc.nextInt();
												ArrayList<Book> bks = mg.searchPrice(price);
												
												for(Book x : bks)
												{
													if(x!=null)
														{System.out.println(x.toString());
														System.out.println("===================================");
												}
												}
											}
											else
												if(T==10)
												{
													System.out.print("가격 평균 :");
													int num = mg.getAvg();
													System.out.println(num);
												}
												else
													if(T==11)
													{
														System.out.print("가격 합계 :");
														int num = mg.getSum();
														System.out.println(num);
													}
	
				}
	}
}
