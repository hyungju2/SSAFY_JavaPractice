package com.inter;

import com.basic.MainTest;

public class ShapeMakerTest {
	ShapeMaker maker;
	public ShapeMakerTest()
	{
		maker = new ShapeMaker();
	}
	
	public void test() {
		IShape x = maker.makeShape(); //데이터의 타입에 딱 맞게 쓰는 것이 아닌, 더 큰 타입인 Interface로 작성하는 것이 좋음.
										//상호 결합도를 줄여야 함.
		System.out.println(x.getArea());
	}
	
	public static void main(String[] args) {
		new ShapeMakerTest().test();
	}
	
}
