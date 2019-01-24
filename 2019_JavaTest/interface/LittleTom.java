package com.inter;
class Tom{
	int age = 50;
}
interface Hillary{
	int age = 46;//static이라고 안 붙여도 interface안의 값은 static,final임
}

public class LittleTom extends Tom implements Hillary {
	int age = 23;
	
	private void test() {
	System.out.println(this.age); //23
	System.out.println(age); // 23
	System.out.println(super.age);
	System.out.println(Hillary.age);
	}
	
	public static void main(String[] args) {
	LittleTom lt = new LittleTom();
	lt.test();
	}
}
