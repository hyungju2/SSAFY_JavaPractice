package mvc.vo;
//vo(value object) : 값을 저장하기 위한 용도의 객체
public class Customer {
	private String num, name, address;
	
	public Customer() {}
	
	public Customer(String num, String name, String address) {
		super();
		this.num = num;
		this.name = name;
		this.address = address;
	}
	

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
