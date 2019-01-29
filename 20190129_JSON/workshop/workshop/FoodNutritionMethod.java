package workshop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FoodNutritionMethod {

	List<FoodNutrition> list;

	public List<FoodNutrition> search() throws Exception {
	
		list = new ArrayList<>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = factory.newDocumentBuilder();
		Document doc = parser.parse("FoodNutritionInfo.xml");
		NodeList items = doc.getElementsByTagName("item");
		
		int length = items.getLength();
		
		for (int i = 0; i < length; i++) {
			Node item = items.item(i);
			NodeList child = item.getChildNodes();

			FoodNutrition f = new FoodNutrition();
			
				for(int j=0; j<child.getLength(); j++) {		
					Node child1 = child.item(j);
					String name = child1.getNodeName();
					if (name.equals("DESC_KOR")) {
						f.setDESC_KOR(child1.getLastChild().getNodeValue());
					}
					else if (name.equals("SERVING_WT")) {
						f.setSERVING_WT(child1.getLastChild().getNodeValue());
					} else if (name.equals("NUTR_CONT1")) {
						f.setNUTR_CONT1(child1.getLastChild().getNodeValue());
					} else if (name.equals("NUTR_CONT2")) {
						f.setNUTR_CONT2(child1.getLastChild().getNodeValue());
					} else if (name.equals("NUTR_CONT3")) {
						f.setNUTR_CONT3(child1.getLastChild().getNodeValue());
					} else if (name.equals("NUTR_CONT4")) {
						f.setNUTR_CONT4(child1.getLastChild().getNodeValue());
					} else if (name.equals("NUTR_CONT5")) {
						f.setNUTR_CONT5(child1.getLastChild().getNodeValue());
					} else if (name.equals("NUTR_CONT6")) {
						f.setNUTR_CONT6(child1.getLastChild().getNodeValue());
					} else if (name.equals("NUTR_CONT7")) {
						f.setNUTR_CONT7(child1.getLastChild().getNodeValue());
					} else if (name.equals("NUTR_CONT9")) {
						f.setNUTR_CONT8(child1.getLastChild().getNodeValue());
					} else if (name.equals("NUTR_CONT9")) {
						f.setNUTR_CONT9(child1.getLastChild().getNodeValue());
					}
					else
						continue;
				}
				list.add(f);
		}
		return list;
	} // end of function parsing.

}
