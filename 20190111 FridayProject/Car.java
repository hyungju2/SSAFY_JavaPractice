
public class Car extends CarMgr {
private String num;
private String model;
private int price;


Car() {
	//this("1234","Morning",10000000);
}

Car(String num, String model, int price)
{
	this.num = num;
	this.model = model;
	this.price = price;
}

public String getNum() {
	return num;
}

public void setNum(String num) {
	this.num = num;
}

public String getModel() {
	return model;
}

public void setModel(String model) {
	this.model = model;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

}