package com.workshop;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WeatherDAO {
	List<Weather> list; //파싱된 결과가 저장되어있는 리스트 
	String url = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1168064000";
	
	Document doc;
	WeatherDAO() throws Exception {
		list = new ArrayList<>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = factory.newDocumentBuilder();
		InputStream in = new URL(url).openConnection().getInputStream();
		doc = parser.parse(in);
	}
	
	public List<Weather> getNewsData()
	{
		NodeList items = doc.getElementsByTagName("data");
		int length = items.getLength();
	
		for(int i=0; i<length; i++)
		{
			Node item = items.item(i);
			NodeList child = item.getChildNodes();
			Weather n = new Weather();
			for( int j = 0; j<child.getLength(); j++)
			{
				
				Node child1 = child.item(j);
				String nodename = child1.getNodeName();
				
				if(nodename.equals("hour"))
				{
					n.setHour(Integer.parseInt(child1.getLastChild().getNodeValue()));
				}
				else if(nodename.equals("wfKor"))
				{
					n.setWfkor(child1.getLastChild().getNodeValue());
				}
				else if(nodename.equals("temp"))
				{
					n.setTemp(Double.parseDouble(child1.getLastChild().getNodeValue()));
				}
				else if(nodename.equals("reh"))	
				{
					n.setReh(Integer.parseInt(child1.getLastChild().getNodeValue()));
				}
				else {
					continue;
				}
				
			}
				list.add(n);
		}
		return list;
	}
}
