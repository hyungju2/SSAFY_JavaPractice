package DigitalPlaza;

public class Refrigerator extends Product{

	private int capacity;
	public Refrigerator(String name, String kind, int productnum, int price, int amount, int capacity) {
		super(name, kind, productnum, price, amount);
		this.capacity = capacity;
		// TODO Auto-generated constructor stub
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	@Override
	public String toString() {
		return "Refrigerator [capacity=" + capacity + ", name="+super.getName()+", productnum="+super.getProductnum() +"]";
	}
	
}
