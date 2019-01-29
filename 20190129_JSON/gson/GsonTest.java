package com.gson;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GsonTest {
	public static void toJson() {
		//1. java object --> Json String
		Person p = new Person(123,"Dahyun","seoul");
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();

		String str = gson.toJson(p);
		System.out.println(str);
	}
	public static void fromJson() {
		//2. json String --> java object
		String json = "{'num':'500', 'name':'harry', 'address':'london'}";
		Gson gson = new Gson();
		Person p = gson.fromJson(json, Person.class);
		System.out.println(p);
	}
	
	public static void makeJson() {
		//3. JsonObject --> jason String
		Gson gson = new Gson();
		JsonObject obj = new JsonObject();
		obj.addProperty("num", 900);
		obj.addProperty("name", "kane");
		obj.addProperty("address", "tottenham");
		
		String json = gson.toJson(obj);
		System.out.println(json);
	}
	
	public static void parseJson() {
		//4. json parsing
		
		String json = "{'num':123,'name':'Dele','address':'England'}";
		JsonParser parser = new JsonParser(); //parser생성
		JsonObject obj = parser.parse(json).getAsJsonObject(); //파싱 후 JsonObject타입으로 결과받음.
		
		int num = obj.get("num").getAsInt(); //get Method로 원하는 것 뽑음.
		String name = obj.get("name").getAsString();
		String address = obj.get("address").getAsString();
		System.out.println(num+" : "+ name+" : "+ address);
	}
	
	public static void parseJsonArray() {
	
		String str1 = "{'client':'localhost', 'servers':['10.0.11, '127.0.0.100', '34.56.78.90', '256.67.881.78']'}";
		String str2 = "{winners':['queen','king','prince','eugine','princess']}";
		String str3 = "['red','blue','yellow',green']";
		JsonParser parser = new JsonParser();
		JsonObject obj = parser.parse(str1).getAsJsonObject();
		JsonArray arr = obj.getAsJsonArray("servers");
		Gson gson = new Gson();
		ArrayList list = gson.fromJson(arr,ArrayList.class);
		for(int i=0; i<list.size(); i++)
		{
			System.out.println(list.get(i));
		}
		System.out.println();
		
		JsonObject obj2 = parser.parse(str2).getAsJsonObject();
		JsonArray ar2 = obj2.getAsJsonArray("winners");
		ArrayList list2 = gson.fromJson(str2, ArrayList.class);
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println();
		
		JsonArray arr3 = parser.parse(str3).getAsJsonArray();
		ArrayList list3 = gson.fromJson(arr3, ArrayList.class);
		for (int i = 0; i < arr3.size(); i++) {
			System.out.println(list3.get(i));
		}
		System.out.println();
	
	}
	
	public static void main(String[] args) {
		toJson(); //1. javaobject
		fromJson(); //2. json String
		makeJson(); //3. JsonObject --> jason String
		parseJson(); //4. json parsing
		
		parseJsonArray();

	}
}
