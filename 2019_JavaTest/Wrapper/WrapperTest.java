package com.basic;

public class WrapperTest {
	public static void main(String[] args) {
		int count = 123;// 기본형
		count++; //기본형이라 가능함.
		
		Integer i = new Integer(count); //기본형이 아닌 객체. 객체로 바뀌면 메소드를 호출할 수 있음. 기본형은x
		//i++ 불가능 함. 객체로 바뀌었기 때문에.
		i++; //125. auto=unboxing후 연산을 실행하고, 다시 auto-boxing해서 Integer 객체로 만듦
		System.out.println(i); //연산 후 자동으로 Boxing해줌. -> Wrapping한다.
		
		String snum = "567";
		int num = Integer.parseInt(snum); //스트링을 int로
		System.out.println(++num);
		
		double d = 3.14;
		
		Double Rd = new Double(d); //Wrapper Class로 바꾼 d
		
		String snum2 = "2.56";
		Double Rsnum3 = Double.parseDouble(snum2);
		Double Rsnum2 = new Double(snum2);
		
		System.out.println(Rd+Rsnum2);
		System.out.println(Rd+Rsnum3);
		
	}//end of main 
}//end of class
