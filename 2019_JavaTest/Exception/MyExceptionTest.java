package com.exception;

public class MyExceptionTest {
	public static void main(String[] args) {
		MyExceptionTest m = new MyExceptionTest();
		try {
			m.go(-1);
		} catch (MyException e) { //Exception을 하려면, 작은애부터 해야 잡힘.
			e.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
			}
	}

	private void go(int num) throws MyException, Exception {
	//	num>=0 정상, num<0 예외 발생
	if(num>0)
		System.out.println(++num);
	else if(num ==0) { //예외 발생
		throw new MyException();
		}
	else {
		throw new Exception();
	}
	
	}
}
