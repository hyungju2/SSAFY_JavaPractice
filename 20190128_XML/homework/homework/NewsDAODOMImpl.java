package com.homework;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NewsDAODOMImpl implements INewsDAO {
	List<News> list;
	private static String url;
	
	public static String getUrl() {
		return url;
	}


	public static void setUrl(String url) {
		NewsDAODOMImpl.url = url;
	}

	static Document doc;
	
	@Override
	public List<News> getNewsList(String url) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = factory.newDocumentBuilder();
		InputStream in = new URL(url).openConnection().getInputStream();
		doc = parser.parse(in);
		NodeList items = doc.getElementsByTagName("item");
		int length = items.getLength();
		for(int i=0; i<length; i++)
		{
			Node item = items.item(i);
			NodeList child = item.getChildNodes();
			News n = new News();
			
			for( int j = 0; j<child.getLength(); j++)
			{
			
				
				Node child1 = child.item(j);
				String nodename = child1.getNodeName();
				
				if(nodename.equals("title"))
				{
					n.setTitle(child1.getLastChild().getNodeValue());
				}
				else if(nodename.equals("description"))
				{
					n.setDesc(child1.getLastChild().getNodeValue());
				}
				else if(nodename.equals("link"))
				{
					n.setLink(child1.getLastChild().getNodeValue());
				}
				else
					continue;
			}
			list.add(n);
		}
		return list;
	}
		

	@Override
	public News search(int index) {
		return list.get(index);
	}

	public NewsDAODOMImpl() throws Exception {
		list = new ArrayList<>();
		
	}

	
	
	
}
