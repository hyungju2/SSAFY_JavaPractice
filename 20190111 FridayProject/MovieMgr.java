
public class MovieMgr {
	private Movie[] movies = new Movie[100];
	private int index = 0;
	
	public void add(Movie m)
	{
		movies[index] = m;
		index++;
	}
	
	public Movie[] search() {
		return movies;
	}
	
	public Movie[] search(String title) {
		Movie mv[] = new Movie[100]; // 객체의 주소를 저장할 100칸 생성, 각 칸에는 null
		
		int ind = 0;
		for(int i=0; i<index; i++)
		{
			if(movies[i].getTitle().contains(title))
			{			
				mv[ind] = movies[i];
				ind++;
			}
		}
		return mv;
	}
	
	public Movie[] searchDirector(String name)
	{
	Movie mv[] = new Movie[100]; // 객체의 주소를 저장할 100칸 생성, 각 칸에는 null
		
		int ind = 0;
		for(int i=0; i<index; i++)
		{
			if(movies[i].getDirector().contains(name))
			{			
				mv[ind] = movies[i];
				ind++;
			}
		}
		return mv;
	}
	
	public Movie[] searchGenre(String genre) {
		Movie mv[] = new Movie[100]; // 객체의 주소를 저장할 100칸 생성, 각 칸에는 null
		
		int ind = 0;
		for(int i=0; i<index; i++)
		{
			if(movies[i].getGenre().contains(genre))
			{			
				mv[ind] = movies[i];
				ind++;
			}
		}
		return mv;
	}
	
	public void delete(String title)
	{
		
		for(int i=0; i<index; i++)
		{
			if(movies[i].getTitle().equals(title) && i<(index-1))
				{
					movies[i].setDirector(movies[i+1].getDirector());
					movies[i].setGenre(movies[i+1].getGenre());
					movies[i].setGrade(movies[i+1].getGrade());
					movies[i].setSummary(movies[i+1].getSummary());
					movies[i].setTitle(movies[i+1].getTitle());
				}
		}
		
		index--;

	}
	
	public int getSize() {
		return index;
	}
}
