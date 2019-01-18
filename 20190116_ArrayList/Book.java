package Book;
public class Book{

	private int isbn,price,desc;
	private String title,author,publisher;
	public Book(int isbn, int price, int desc, String title, String author, String publisher) {
		this.isbn = isbn;
		this.price = price;
		this.desc = desc;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}
	
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", price=" + price + ", desc=" + desc + ", title=" + title + ", author=" + author
				+ ", publisher=" + publisher + "]";
	}

	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDesc() {
		return desc;
	}
	public void setDesc(int desc) {
		this.desc = desc;
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

	

}
