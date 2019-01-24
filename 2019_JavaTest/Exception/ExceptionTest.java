package com.exception;


//java.lang.ArithmeticException: 0으로 나누었을 때. 실행을 해봐야 알 수 있는 오류.
public class ExceptionTest {
	public static void main(String[] args) {
		int a = 9, b = 0, c = 0;
		
		int[] ar = {1,2,3};
		
		try {
			c = a/b;
		System.out.println(ar[11]);
		}catch(Exception q) { //여려 개로 세분화해서 캐치해도 됨. but, 예외처리가 길어짐.
								//큰 타입의 예외
			System.out.println("exception 발생");
		}finally { //예외가 발생하던지, 아니던지 무조건 사용되어야 할 때 Finally
			System.out.println("Finally....");
		}
		//System.out.println(c);
	} // end of main
} //end of class
