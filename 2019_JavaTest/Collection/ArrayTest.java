package com.util;
/**
 * Arrays 클래스 : 배열 관련 유틸리티 클래스.
 * @author student
 *
 */
import java.util.Arrays;

public class ArrayTest {
	public static void main(String[] args) {

		int[] num = {10,30,5,90,50};
		
		//1.문자열로 표현
		System.out.println(Arrays.toString(num));
	
		//2. sort
		Arrays.sort(num);
		System.out.println(Arrays.toString(num));
		
		//3. binary search
		
		int key = 50;
		System.out.println(Arrays.binarySearch(num, key));
	
		//4. fill
		int[] a = new int[100];
		Arrays.fill(a, -1);
		
		//5. copy
		int[] a1 = {1,2,3,4,5};
		int[] a2 = Arrays.copyOf(a1,3);
		int[] a3 = Arrays.copyOf(a1,4);
		
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));
		System.out.println(Arrays.toString(a3));
		
		//6.equal
		int[] b1 = {1,2,3};
		int[] b2 = {1,2,3};
		System.out.println(Arrays.equals(b1, b2));
	}//end of main
}
