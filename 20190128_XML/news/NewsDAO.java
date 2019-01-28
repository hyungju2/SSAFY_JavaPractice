package com.news;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NewsDAO {
	List<News> list; //파싱된 결과가 저장되어있는 리스트 
	String url = "http://api.newswire.co.kr/rss/industry/600";
	
	Document doc;
	NewsDAO() throws Exception {
		list = new ArrayList<>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = factory.newDocumentBuilder();
		InputStream in = new URL(url).openConnection().getInputStream();
		doc = parser.parse(in);
	}
	
	public List<News> getNewsData()
	{
		NodeList items = doc.getElementsByTagName("item");
		int length = items.getLength();
	
		for(int i=0; i<length; i++)
		{
			Node item = items.item(i);
			NodeList child = item.getChildNodes();
			
			for( int j = 0; j<child.getLength(); j++)
			{
				News n = new News();
				
				Node child1 = child.item(j);
				String nodename = child1.getNodeName();
				
				if(nodename.equals("title"))
				{
					n.setTitle(child1.getLastChild().getNodeValue());
				}
				else if(nodename.equals("pubDate"))
				{
					n.setPubDate(child1.getLastChild().getNodeValue());
				}
				else
					continue;
				list.add(n);
			}
		}
		return list;
	}
}
