package DigitalPlaza;

import java.util.ArrayList;

public class ProductMgrImpl implements ProductMgr{

	ArrayList<Product> list;
	
	ProductMgrImpl(){
		list = new ArrayList<>();
	}
	
	private int index = 0; // 제품 갯수 확인 
	
	
	
	@Override
	public void add(Product product) {
		
		list.add(product);
		index++;
	} //제품 추가하는 함수 

	@Override
	public void delete(int productnum) {
		list.remove(productnum-1);
		index--;
	} //등록된 순번으로 삭제. 

	@Override
	public ArrayList<Product> search() {
		return list;
	}//전체 검색 

	@Override
	public ArrayList<Product> search(String name) {
		ArrayList<Product> tmp = new ArrayList<>();
		
		for(Product p: list)
		{
			if(p.getKind().equals(name))
			{
				tmp.add(p);
			}
		}
		return tmp;
	} //제품 종류에 따른 검색 기능 

	@Override
	public ArrayList<Product> search(int price) {
		// TODO Auto-generated method stub
		ArrayList<Product> tmp = new ArrayList<>();
		
		for(Product p : list)
		{
			if(p.getPrice()<=price)
			{
				tmp.add(p);
			}
		}
		return tmp;
	} //이하 가격의 제품 출력  


	@Override
	public void ProductOrder(String productName) {
		int num=0;
		int ind=0;
		for(Product p : list)
		{
			if(p.getName().equals(productName))
			{
				ind = num;
			}
			num++;
		}
		list.get(ind).setAmout(list.get(ind).getAmout()-1);
		
	}

}//end of class 
