package com.member;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MemberParsing2 {
	public static void main(String[] args) throws Exception {
	MemberParsing2 m = new MemberParsing2();
	m.process();
	}
	
	private void process() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = factory.newDocumentBuilder();
		Document doc = parser.parse("xml/member.xml");
	
		NodeList members = doc.getElementsByTagName("member");
		int length = members.getLength();
		
		for (int i = 0; i < length; i++) {
			Node member = members.item(i); //멤버 한 사람
			NodeList child = member.getChildNodes(); //모든 자식노드
			
			for (int j = 0; j < child.getLength(); j++) {
				Node child1 = child.item(j);
				String nodename = child1.getNodeName(); //노드 이동
				
				if(nodename.equals("name"))
				{
					System.out.print(child1.getLastChild().getNodeValue()+" ");
				} else if(nodename.equals("address"))
				{
					System.out.println(child1.getLastChild().getNodeValue());
				}
				
			}
		}
	}
}
