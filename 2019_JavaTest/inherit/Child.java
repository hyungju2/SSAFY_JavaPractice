package com.inherit;
class Parents{
//Field
	String name = "Dahyun";
	String Address = "Seoul";
	void printName() {
		System.out.println("name "+name);
	}
	public Parents() {
		System.out.println("Parent 생성자임");
	}
	public void printAddress() {
		System.out.println("Address "+Address);
	}
} //super class

public class Child extends Parents {
	Child(){
		System.out.println("자식 생성자임"); //상속 관계에서는 부모가 먼저 만들어진다.
		   }
	
	@Override //Source에서 오버라이딩 가능 한 메소드들이 나옴. 재정의. class 안의 설정 정보를 어노테이션 '@'로 표현. 즉, 메타데이터
				//범위가 넓어지는 것은 가능하나, 부모의 메소드보다 범위가 작아지는 것은 허용x
	protected void printName() {
		System.out.println("In...jik");
	}
	
	public void callSuper() { //static안에서 사용할 수 없는 super 메소드를 이용하기 위함.
		super.printName();
	}
	
	public static void main(String[] args) {
		//Child c = new Child();
		// Child c = new Parent() -> 이건 오류. 부모 클래스가 더 큰 범위인 것임.
		//Parent p = new Child() -> 이건 오류 x. Child클래스에서, Parent부분만 사용한다는 의미.
		//Object t = new Parents(); -> 모든 것의 루트는 Object 클래스.
		
		Parents cc = new Child(); // 생성 된 객체는 똑같이 Child이나, 가르키는 변수 레퍼런스가 다른것을 의미하는 것이 다형성.
		Child c = (Child)cc; //타입을 변환. 실제로 저장된 타입이 Child()이기에 형변환이 가능한 것임. 형 변환 타입이 정확하게 들어있음.
		Parents cc2 = new Parents();
		Child cc3 = (Child)cc2; //작은 타입으로 변환요청. 데이터 값이 정확하게 들어있지 않음.
		
		//Child c = new Child(); //다형성의 예시. 동일한 타입의 생성 객체를 다양한 타입으로 가르킬 수 있는 현상.

		c.printAddress();
		c.printName(); //원칙적으로는, c의 타입이 parent여서 parent가 되어야 하나, 오버라이딩 되어있으면 자식꺼를 호출하게 된다.
						//내꺼에서 없는 함수를 호출하였으면, 보편적으로 부모 클래스의 함수를 확인. 만약, 부모클래스의 함수가
						//자식 클래스에서 재정의가 되었음이 확인되면 자식꺼 호출함.
		
		c.callSuper(); //실제로 저장된 타입이 Child()이기에 형변환이 가능한 것임.
		//cc3.callSuper(); 무조건 자식 타입으로 형 변환이 가능하지는 않음. 내용물이 자식이 들어있다면 가능!
		
		//super.printName(); super, this는 static 메소드 안에서는 사용 불가. 따로 메소드를 만들어서 사용.
	
	}//end of main
}//end of class, sub class