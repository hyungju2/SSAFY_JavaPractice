import java.util.Scanner;

public class MovieTest {
	public static void main(String[] args) {
		
	
	Scanner sc = new Scanner(System.in);
	MovieMgr mg = new MovieMgr();
	int T = 1;
	while(T!=0)
	{
		System.out.println();
		System.out.println("<<< 영화 관리 프로그램 >>>");
		System.out.println("1. 영화 정보 입력");
		System.out.println("2. 영화 정보 전체 검색");
		System.out.println("3. 영화명 검색");
		System.out.println("4. 영화 장르별 검색");
		System.out.println("5. 영화 정보 삭제");
		System.out.println("0. 종료");
		System.out.println("원하는 번호를 선택하세요.");
		T = sc.nextInt();
	
			if(T==1)
			{
				System.out.print("추가할 제목, 디렉터, 등급, 장르, 요약을 입력해주세요");
				Movie mv = new Movie();
				String title, director, genre, summary;
				int grade;
				title = sc.next();
				director = sc.next();
				grade = sc.nextInt();
				genre = sc.next();
				summary = sc.next();
				mv.setDirector(director);
				mv.setGenre(genre);
				mv.setGrade(grade);
				mv.setSummary(summary);
				mv.setTitle(title);
				mg.add(mv);
			}
			else
				if(T==2)
				{
					Movie mv = new Movie();
					System.out.print("전체검색");
					for(int i=0; i<mg.getSize(); i++)
					{
						mv = mg.search()[i];
						System.out.print(mv);
					}		
					System.out.println();
				}
				else
					if(T==3)
					{
						System.out.print("영화 이름검색");
						String title = sc.next();
						Movie[] mv = mg.search(title);
						
						for(int i=0; i<mv.length && mv[i]!=null; i++)
						{
							System.out.println(mv[i].toString());
						}
					
					}
					else
						if(T==4)
						{
							System.out.print("영화 장르검색");
							String genre = sc.next();
							Movie[] mv = mg.search(genre);
							
							for(int i=0; i<mv.length&&mv[i]!=null;i++)
							{
								System.out.println(mv[i].toString());
							}
					
						}
						else
							if(T==5)
							{
								System.out.print("영화 정보 삭제");
								String title = sc.next();
								mg.delete(title);
						
							}
	
				}
	}
}
