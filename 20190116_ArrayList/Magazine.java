package Book;

public class Magazine extends Book {
	private int year,month;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	
	
	
	public Magazine(int isbn, int price, int desc, String title, String author, String publisher, int year, int month) {
		super(isbn, price, desc, title, author, publisher);
		this.year = year;
		this.month = month;
	}
	
	

}
