package com.util;
import java.util.HashMap;
import java.util.Set;

/**
 * Map:(key,value)의 쌍으로 저장되는 구조. Key값으로 Value를 검색함.
 * Map은 루프로 꺼낼 수 없음. Key를 알아야 하기 때문.
 * 
 * @author student
 *
 */

public class HashMapTest {
	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<>();
		map.put("num", "1234");
		map.put("name","jane");
		map.put("address","seoul");
	
		String name = map.get("name");
		System.out.println(name);
		System.out.println(map.toString());
	
		Set<String> keys = map.keySet(); //map안에 들어있는 key만 추출
		for(String key: keys)
		{
			String value = map.get(key); // key를 기준으로 value를 알아냄
			System.out.print(value+",");
			
		}
		
	}
}
