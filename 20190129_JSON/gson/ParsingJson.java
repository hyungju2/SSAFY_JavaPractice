package com.gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ParsingJson {
	public static void main(String[] args) throws Exception {
		
		//school.json을 읽어와서 parsing.


	
		//1. school.json 읽어오기(BufferedReader br)
		BufferedReader br = new BufferedReader(new FileReader("json/school.json"));

		//2. JsonParser 생성 후 parsing --> JsonObject
		JsonParser parser = new JsonParser();
		JsonObject obj = parser.parse(br).getAsJsonObject();
		JsonArray jsonArray = (JsonArray) obj.getAsJsonArray("records");
	
		//3. 교육지원청코드, 학구명, 시도교육청명, 교육지원청명 뽑아서 화면에 출력.
		for (int i = 0; i < jsonArray.size(); i++) {
			JsonObject o = (JsonObject) jsonArray.get(i);
			String code = o.get("교육지원청코드").getAsString();
			String name = o.get("학구명").getAsString();
			String name2 = o.get("시도교육청명").getAsString();
			String name3 = o.get("교육지원청명").getAsString();
			System.out.println("코드:"+code+", 학구명:"+name+", 시도교육청명:"+name2+", 교육지원청명:"+name3);
		}
	}
}
