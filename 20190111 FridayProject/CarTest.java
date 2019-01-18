import java.util.Arrays;

public class CarTest {
	public static void main(String[] args) {
		
		Car c = new Car();
		CarMgr m = new CarMgr();
		
		m.add(new Car("1234","Canival",300000));
		m.add(new Car("5678","Audi",3004));
		m.add(new Car("1010","morning",1000));

		for(int i=0; i<m.size(); i++)
		{
			c = m.search()[i];
			System.out.println(c.getModel()+","+c.getNum());
		}
		
		m.update("5678", 5000);
		m.delete("1010");
		
		Car[] c2 = m.search(6000);
		
		for(int i=0; i<m.size(); i++)
		{
			c = m.search()[i];
			System.out.println(c.getModel()+","+c.getNum());
		}
	
		for(int i=0; i<c2.length && c2[i]!=null; i++)
		{
			System.out.println("=====");
			System.out.println(c2[i].getModel()+","+c2[i].getPrice());
		}
		
		int cnt = m.size();
		int money = m.totalPrice();
		//System.out.println(cnt);
		//System.out.println(money);
	
		

	} // end of main
} //end of class
