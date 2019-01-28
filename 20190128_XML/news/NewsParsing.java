package com.news;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NewsParsing {
	
	private String title;
	private String category;
	
	NewsParsing(String title, String category){
		this.title = title;
		this.category = category;
	}
	
	NewsParsing(){
		
	}
	
	public static void main(String[] args) throws Exception {
		new NewsParsing().process();
	}

	private void process() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = factory.newDocumentBuilder();
		Document doc = parser.parse("xml/news.xml");
		
		
		NodeList items = doc.getElementsByTagName("item");
		int length = items.getLength();
	
		for(int i=0; i<length; i++)
		{
			Node item = items.item(i);
			NodeList child = item.getChildNodes();
			
			for( int j = 0; j<child.getLength(); j++)
			{
				Node child1 = child.item(j);
				String nodename = child1.getNodeName();
				
				if(nodename.equals("title"))
				{
					System.out.print(child1.getLastChild().getNodeValue()+" ");
				}
				else if(nodename.equals("pubDate"))
				{
					System.out.println(child1.getLastChild().getNodeValue());
				}
			}
			
		}
	}

}
