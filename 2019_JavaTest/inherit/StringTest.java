package com.inherit;

import computer.MainFrame;

public class StringTest {

	public static void main(String[] args) {
		String s = "ILovePolaris"; //String은 따로 객체 만들지 않고 사용해도 가능하다. 기본형에서만 사용 가능. 기본형 아닌건 Only String
									//직접 값을 부여하였기에, Class Area의 String이 저장되는 Constant Pool에 저장됨.
		String m = "ILovePolaris";
		String t = new String("ILovePolaris"); //VM의 Hip에 저장됨. 그냥 입력한 것과 주소가 다름.
		
		System.out.println(s.length()); //문자열 길이 .length();
		System.out.println(s.charAt(3)); // 4번째 글자 추출. 인덱스가 3인 글자
		System.out.println(s.indexOf("i")); //해당 글자의 인덱스 값을 출력.
		
		String s2 = s.substring(2, 7); //substring 오버로딩 되어있음.
		System.out.println(s2);
		
		s2=s.substring(2);
		System.out.println(s2);//end index 부여하지 않은 것으로 사용하면 끝까지 출력됨.
		if(s==m)
			System.out.println("String 단점"); //같은 Class Area에 설정 된 변수는 주소가 같다고 나옴.
											 //데이터는 하나인데, 가르키는 것이 두개임. 그렇기 때문에 원본을 수정하지 않는 독립적 공간 생성.+
		if(s==t) //주소값 비교
			System.out.println("s==t");
		
		if(s.equals(t))//내용 비교
			System.out.println("s.equals(t)");
		
		
		s.toUpperCase(); //소문자를 다 대문자로! 원본을 건드리는 것이 아니라, 새로 만듦.
		System.out.println(s);
		String k = s.toUpperCase(); //이렇게 새로 선언해줘야 사용 가능.
		System.out.println(k);
		
		s.concat("Hello"); // 문자열 결합. 원본은 그대로 있고, 새로 만듦. 
		System.out.println(s);
		//String은 메모리에 계속해서 객체가 만들어짐. 자리를 매우 많이 차지. 원본을 수정하지 않고 독립적으로 만들기 때문에..
		
		s +="hello";
		System.out.println(s);
		
		StringBuilder sb = new StringBuilder("ILovePolaris"); //String과 다르게 원본에 수정이 가능하다.
		sb.append(" But, This program is owed KB");
		System.out.println(sb);
		System.out.println(sb.toString());
		System.out.println(sb.length());
		sb.setLength(5);
		System.out.println(sb.length());
		System.out.println(sb);
		
		
		
	} // end of main
	} // end of class
