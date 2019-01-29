package workshop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FoodMethod {
	List<Food> list;
	
	public List<Food> search() throws Exception
	{
		list = new ArrayList<>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = factory.newDocumentBuilder();
		Document doc = parser.parse("foodInfo.xml");
		NodeList items = doc.getElementsByTagName("food");
		
		int length = items.getLength(); //food 길이만큼
		for (int i = 0; i <length; i++) {
				Node item = items.item(i); //food 밑에 item들.
				
				NodeList foods = item.getChildNodes();
				Food f = new Food();
				for(int j=0; j<foods.getLength(); j++)
				{
				Node child = foods.item(j);
				String nodename = child.getNodeName();
				
				if(nodename.equals("name"))
				{
					f.setName(child.getLastChild().getNodeValue());
				}
				else if(nodename.equals("material"))
				{
					f.setMaterial(child.getLastChild().getNodeValue());
				}
				else if(nodename.equals("maker"))
				{
					f.setCop(child.getLastChild().getNodeValue());
				}
				else 
					continue;
				}
				list.add(f);	
		}
		return list;
	} //food parsing.
}
