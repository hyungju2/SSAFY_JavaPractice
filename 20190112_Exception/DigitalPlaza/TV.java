package DigitalPlaza;

public class TV extends Product{

	private int size;
	public TV(String name, String kind, int productnum, int price, int amount, int size) {
		super(name, kind, productnum, price, amount);
		this.size = size;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "TV [size=" + size + ", name="+super.getName()+", productnum="+super.getProductnum() +"]";
	}
	
	
}
