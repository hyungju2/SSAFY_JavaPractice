package com.inherit;

public class BonusTest {
	
	public void printBouns(Employee who) { //상위 클래스를 변수로 받으면, 하위 클래스 사용 가능.
											//상속이 선언되면, 하위 클래스는 부모 클래스의 타입이 된다. 
		System.out.println(who.getClass().getSimpleName());
		if(who instanceof Manager) { //물어볼 때는 작은애부터 물어봐야 함.
			System.out.println("Type is Manager");
		}
		System.out.println(who.getBonus());
	
	}
	
	public static void main(String[] args) {

		BonusTest bt = new BonusTest();
		Employee tom = new Employee(100,"tom",5000);
		Manager bil = new Manager(200,"bill",6000,1);
		
		bt.printBouns(tom);
		bt.printBouns(bil);
	}//end of main
}//end of class
