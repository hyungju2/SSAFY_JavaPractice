package Movie;

import java.util.Scanner;

public class Theater {
	private Movie[] movies = new Movie[100];
	private Movie[] reserv = new Movie[100];
	
	private int index = 0;
	private int res = 0;
	Scanner sc = new Scanner(System.in);
	
	public void add(User u) //사람 추가
	{
		movies[index] = u;
		index++;
	}
	
	
	public void add(Movie m) //영화 추가
	{
		movies[index] = m;
		index++;
	}
	
	public Movie[] search() { //모든 영화 검색
		Movie mv[] = new Movie[100];
		int ind = 0;
		for(int i=0; i<index; i++)
		{
			if(movies[i].getClass().getName().equals("Movie.Movie"))
				mv[ind++] = movies[i];
		}
		return mv;
	}
	
	
	
	public Movie[] Usersearch()//모든 회원 검색
	{
		Movie mv[] = new Movie[100];
		
		int ind = 0;
		for(int i=0; i<index; i++)
		{
			if(movies[i] instanceof User)
				mv[ind++] = movies[i];
		}
		return mv;
	}

	public Movie[] Postsearch(int time)//이후영화
	{
		Movie mv[] = new Movie[100];
		
		int ind = 0;
		for(int i=0; i<index; i++)
		{
			if(movies[i].getTime() >= time)
				mv[ind++] = movies[i];
		}
		return mv;
	}
	
	public void revise(String title)
	{
		String retitle;
		int retime;
		for(int i=0; i<index; i++)
		{
			if(movies[i].getTitle().equals(title))
			{
				System.out.println("바꾸실 영화 제목과 시간을 입력해주세요");
				retitle = sc.next();
				retime = sc.nextInt();
				movies[i].setTime(retime);
				movies[i].setTitle(retitle);
			}
		}
	}
	
	public void resevation(Movie m)
	{
			reserv[res] = m;
			res++;
	}
	
	public Movie[] CheckReservation(String name)//예약 확인
	{
		Movie mv[] = new Movie[100];
		int ind = 0;
		for(int i=0; i<res; i++)
		{
			if(reserv[i].getDirector().equals(name))
				mv[ind] = reserv[i]; 
		}
		return mv;
	}
	
	
	public void delete(String title)
	{
		
		for(int i=0; i<index; i++)
		{
			if(movies[i].getTitle().equals(title) && i<(index-1))
				{
					movies[i].setTime(movies[i+1].getTime());
					movies[i].setTitle(movies[i+1].getTitle());
				}
		}
		index--;
	}
	
}