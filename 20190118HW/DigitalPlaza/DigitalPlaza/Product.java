package DigitalPlaza;

public class Product {
	private String name;
	private String kind;
	private int productnum;
	private int price;
	private int amout;
	
	public Product(String name, String kind, int productnum, int price, int amount) {
		this.name = name;
		this.kind = kind;
		this.productnum = productnum;
		this.price = price;
		this.amout = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", kind=" + kind + ", productnum=" + productnum + ", price=" + price
				+ ", amout=" + amout + "]";
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getProductnum() {
		return productnum;
	}

	public void setProductnum(int productnum) {
		this.productnum = productnum;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmout() {
		return amout;
	}

	public void setAmout(int amout) {
		this.amout = amout;
	}
	
	
	
	
}
