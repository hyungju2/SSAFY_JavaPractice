package Movie;

public class Movie extends Theater {

	private String Title;
	private int Time;
	private String Director;
	private int Age;
	private String Genre;
	

	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public int getTime() {
		return Time;
	}
	public void setTime(int time) {
		Time = time;
	}

	
	public Movie()
	{
		
	}

	public String getDirector() {
		return Director;
	}
	public void setDirector(String director) {
		Director = director;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	@Override
	public String toString() {
		return "Movie [Title=" + Title + ", Time=" + Time + ", Director=" + Director + ", Age=" + Age + ", Genre="
				+ Genre + "]";
	}
	public String toUserString() {
		return "Movie [영화명=" + Title + ",  고객이름=" + Director+"]";
	}
	public Movie(String title, int time, String director, int age, String genre) {
		super();
		Title = title;
		Time = time;
		Director = director;
		Age = age;
		Genre = genre;
	}
	
	
	
}
