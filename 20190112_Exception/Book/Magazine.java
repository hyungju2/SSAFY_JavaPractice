package Book;

public class Magazine extends Book {

	private int month;
	
	public Magazine(int isbn, String title, int price, int quantity, int month) {
		super(isbn, title, price, quantity);
		this.month = month;
	}

	
	@Override
	public String toString() {
		super.toString();
		return "Magazine [isbn="+ super.getIsbn()+", title="+ super.getTitle() +", price="+ super.getPrice() +", quantity="+ super.getQuantity()  + ", month=" + month + "]";
	}

}
