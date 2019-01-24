package com.inherit;

public class CEO extends Employee {

	public CEO(int num, String name, int salary) {
		super(num, name, salary); //자식을 생성하면, 부모가 먼저 만들어 짐.
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getBonus() {
		// TODO Auto-generated method stub
		return getSalary()*20;
	}
	
	
}
