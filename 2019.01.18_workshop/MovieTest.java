package Movie;
import java.util.Scanner;

public class MovieTest {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	Movie[] mv = new Movie[100];
	Theater te = new Theater();
	
	int T = 1;
	int index = 0;
	while(T!=0)
	{
		System.out.println("1. 영화 추가");
		System.out.println("2. 회원 등록");
		System.out.println("3. 모든 영화 검색");
		System.out.println("4. 이후 영화 검색");
		System.out.println("5. 모든 회원정보 검색");
		System.out.println("6. 예매하기");
		System.out.println("7. 예약확인");
		T = sc.nextInt();
		
		if(T==1)
		{
			String title;
			int time;
			String director;
			int age;
			String genre;
			System.out.println("제목, 시간, 감독, 연령대, 장르 입력");
			title = sc.next();
			time = sc.nextInt();
			director = sc.next();
			age = sc.nextInt();
			genre = sc.next();
			Movie m = new Movie(title,time,director,age,genre);
			te.add(m);
		}
		if(T==2)
		{
			System.out.println("이름, 연락처를 입력");
			String name = sc.next();
			int phone = sc.nextInt();
			User u = new User(name,phone);
			te.add(u);
		}
		
		if(T==3)
		{
		
			Movie mmv[] = te.search();
			for(Movie vmv : mmv)
			{
				if(vmv!=null)
				{
				System.out.println(vmv.toString());
				}
			}
		}
		
		if(T==4)
		{
			System.out.println("원하시는 시간을 입력하세요");
			int time = sc.nextInt();
			Movie mmv[] = te.Postsearch(time);
			System.out.println(time+"이후 영화 정보");
			for(Movie vmv : mmv)
			{
				if(vmv!=null)
				{
					System.out.println(vmv.toString());
				}
			}
		}
		if(T==5)
		{
			System.out.println("등록된 회원 정보");
	
			Movie mmv[] = te.Usersearch();
			for(Movie vmv : mmv)
			{
				if(vmv!=null)
					System.out.println(vmv.toString());
			}
		}
		
		if(T==6)
		{
			System.out.println("회원 이름과 예매하실 영화를 입력하세요.");
			String name = sc.next();
			String title = sc.next();
			Movie m = new Movie(title,0,title,0,"");
			te.resevation(m);
		}
		if(T==7)
		{
			System.out.println("예매 확인하실 회원님의 이름을 입력해주세요");
			String name = sc.next();
			Movie mmv[] = te.CheckReservation(name);
			System.out.println("영화 예매 내역입니다");
			for(Movie vmv : mmv)
			{
				if(vmv!=null)
				{
					System.out.println(vmv.toUserString());
				}
			}
		}
		if(T==0)
			break;
		
	}
	
	}
}
