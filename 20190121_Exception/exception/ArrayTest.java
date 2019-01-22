package com.exception;
//Run time Exception : java.lang.ArrayIndexOutOfBoundsException
//모든 Exception이 클래스임. 이런 것은 컴파일 할 때까진 문제가 없음. Exception Handling 사용
public class ArrayTest {
	public static void main(String[] args) {
		int[] ar = {1,2,3,4,5,3};

			//exception Handling
		for (int i = 0; i <= ar.length; i++) {
			try {
			System.out.println(ar[i]+ ": hello");
		}catch(ArrayIndexOutOfBoundsException q) //핸들링으로 처리해야 함. q가 발생한 예외 정보를 담고있는
												//변수
			{
			System.out.println(i+1+"번째 값은 배열의 범위 초과");
			System.out.println(q.getMessage());
			}
		}
		
	}//end of main
}//end of class
