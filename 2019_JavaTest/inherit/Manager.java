package com.inherit;

class Out{ // Top Level Class
	protected class In{} //inner class 내부 클래스는 타입 지정 제한 x
	private class In2{}
}

//super class
class Employee{	//Top Level Class
	int num;
	String name;
	int salary = 100;
	
	
	public Employee(int num, String name, int salary)
	{
		this.num = num;
		this.name = name;
		this.salary = salary;
	}
	
	public double getBonus() {
		return salary * 0.3;
	}
	
	public String Info() {
		return "num: "+num+" name:"+name+" salary:"+salary;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}

//sub class
public class Manager extends Employee {
	int mcode;
	public Manager(int num, String name, int salary, int mcode) {
		super(num,name,salary);//부모 생성자 호출. 자신의 생성자 호출은 this.
		this.mcode = mcode;
		} //부모와 다른 생성자를 만들기 위해서, 중복되는 값은 super로 보냄.
	
	public static void main(String[] args) {
	
		Employee[] list = new Employee[3]; //클래스 타입의 배열
		Employee e = new Employee(456,"ellen",3000);
		
		Manager m2 = new Manager(123,"kkk",123,152);
		list[0] = m2;
		list[1] = new Manager(1235,"!25",512,243);
		list[2] = e;  // 다형성의 예시. 부모 클래스가 더 크기 때문에
		
	
		Manager m = new Manager(123,"bill",5000,100);
	
		CEO c = new CEO(000,"Steaven",90000);
		System.out.println(e.getBonus());
		System.out.println(m.getBonus());
		System.out.println(c.getBonus());
	}

	@Override
	public double getBonus() {
		return getSalary() * 0.5;
	}
}