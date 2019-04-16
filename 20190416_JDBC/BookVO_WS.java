/**
 * DB의 한 행의 데이터를 관리할 VO 객체 (Value Object)
 * @author student
 *
 */
public class BookVO_WS {
	private int isbn;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private String description;
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "BookVO_WS [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", price=" + price + ", description=" + description + "]";
	}
}
