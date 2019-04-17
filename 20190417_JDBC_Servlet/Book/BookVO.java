package vo;
/**
 * DB의 한 행의 데이터를 관리할 VO 객체 (Value Object)
 * @author student
 *
 */
public class BookVO {
	private int bookid;
	private String title;
	private String publisher;
	private String year;
	private int price;
	
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "BookVO [bookid=" + bookid + ", title=" + title + ", publisher=" + publisher + ", year=" + year
				+ ", price=" + price + "]";
	}
	
}
