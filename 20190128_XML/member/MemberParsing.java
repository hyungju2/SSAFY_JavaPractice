package com.member;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;


public class MemberParsing {
	
	public static void main(String[] args) throws Exception {
	
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder parser = factory.newDocumentBuilder();
	
	//dom tree 제일 위에 있는 가상 노드를 기리킴
	Document doc = parser.parse("xml/member.xml");
	
	/*
	 * DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	   DocumentBuilder parser = factory.newDocumentBuilder();
	   Document doc = parser.parse("xml/member.xml");
	      세 줄은 처음 사용할 때 무조건 사용.
	 */
	
	//root 앨리먼트를 기리킴
	Element root = doc.getDocumentElement();
	System.out.println("well=formed xml!!");
	
	//태그 이름 기준으로 검색
	NodeList names = root.getElementsByTagName("name");
	NodeList Address = root.getElementsByTagName("address");
	int length = names.getLength();
	for (int i = 0; i < length; i++) {
		Node name = names.item(i); //name element 한개 <name>tomy</tommy> 이렇게 나옴.
		Node text = name.getFirstChild(); //Text node인 태그 사이에 있는 것은 Child임. 
		System.out.println(text.getNodeValue()); //Text Node에서 값을 뽑아야 함으로 getNodeValue()
	}
	
	for (int i =0; i< length; i++)
	{
		Node address = Address.item(i);
		Node text = address.getFirstChild();
		System.out.println(text.getNodeValue());
	}
}
}
