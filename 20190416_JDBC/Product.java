/**
 * DB의 한 행의 데이터를 관리할 VO 객체 (Value Object)
 * @author student
 *
 */
public class Product {

	
	private int isbn;
	private String title;
	private String kind;
	private String maker;
	private int price;
	


	
	@Override
	public String toString() {
		return "Product [isbn=" + isbn + ", title=" + title + ", kind=" + kind + ", maker=" + maker + ", price=" + price
				+ "]";
	}
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
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
