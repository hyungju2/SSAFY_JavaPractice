package com.util;

import java.util.ArrayList;

import com.abst.Circle;

/**
 * List 종류 : 데이터 순서 o, 중복 o
 * 세가지 컬렉션의 특징에 대해서 알아둬야 함.
 * @author student
 *
 */

public class ArrayListTest {
	public static void main(String[] args) {
		// <,> generic programming 기법이 적용된 클래스
		
		ArrayList<Circle> list3 = new ArrayList<>(); //ArrayList를 클래스 넣어서도 사용할 수 있음.
		list3.add(new Circle(5));
		list3.add(new Circle(6));
		list3.add(new Circle(7));
		System.out.println(list3.size());
		
		for(int index=0; index<list3.size(); index++)
		{
			Circle x = list3.get(index);
			System.out.println("면적:" +x.getArea());
			System.out.println("둘레:" +x.getCircum());
			System.out.println("==================");
		}
		
		for(Circle x :list3)
		{
			System.out.println("면적:" +x.getArea());
			System.out.println("둘레:" +x.getCircum());
			System.out.println("=======================");
		}
			
		ArrayList<String> list = new ArrayList<>();
		list.add("Spring");
		list.add("Summer");
				
		
		System.out.println(list.size());
		for(String season: list)
		{
			System.out.println(season);
		}
		
		System.out.println("=========");
		
		String x = list.get(1); //list안에서 index위치의 데이터를 꺼내옴.
		System.out.println(x);
		System.out.println(list.size());
		
		System.out.println("=========");
		System.out.println(list.size());
		for(String season: list)
		{
			System.out.println(season);
		}
		
	
		list.set(0,"꼽");
		for(String season: list)
		{
			System.out.println(season);
		}
		
	}
}
