/**
 * Set: 중복x, 순서x
 * TreeSet은 오름차순으로 정렬됨.
 */
package com.util;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class HashSetTest {
	public static void main(String[] args) {
		//내용물이 정렬이 되는 set = TreeSet!
		
		TreeSet<String> set2 = new TreeSet<>();
		set2.add("apple");
		set2.add("banana");
		set2.add("caramel");
		set2.add("air");
		set2.add("carame");
		System.out.println(set2);
		System.out.println(set2.toString());
		
		
		
		
		System.out.println("HashSet");
		//내용물이 정렬되지 않는 HashSet
		HashSet<String> set = new HashSet<>();
		set.add("apple");
		set.add("banana");
		set.add("caramel");
		set.add("air");
		
		Iterator<String> iter = set.iterator(); //Iterator은 set이나 list에 있는 모든 데이터를 꺼내는 것.
		while(iter.hasNext()) //iterator안에 데이터가 있다면, boolean값임.
		{
			String val = iter.next();
			System.out.println(val);
		}
		
		
			
	}//end of main
}//end of class
