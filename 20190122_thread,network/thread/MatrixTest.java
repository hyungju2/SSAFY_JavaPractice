package com.thread;


class Matrix extends Thread{
	int num; //자기가 맡은 단
	
	public Matrix(int num)
	{
		this.num = num;
	}
	
	//thread가 해야 할 작업 내용을 가지고 있는 메소드
	//자기가 맡은 단 한개를 출력.
	
	public void run()
	{
			for(int i=1; i<10; i++)
				System.out.printf("%2d *%2d = %2d",num,i,num*i);
	}

}

public class MatrixTest {
	public static void main(String[] args) {
		for(int i=2; i<10; i++)
		{
		try {
			Matrix m2 = new Matrix(i);
			m2.start();
			m2.join();
			System.out.println("");
			}
		catch(InterruptedException e){
		}
		}
	}
}
