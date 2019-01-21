package DigitalPlaza;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Book.Book;

public class ProductMgrImpl implements ProductMgr{

	ArrayList<Product> list;
	
	ProductMgrImpl() throws Exception{
		list = new ArrayList<>();
	/*	
		TV tv = new TV("Samsung","TV",1,3000000,2,47);
		FileOutputStream fos = new FileOutputStream("product.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(tv);
		oos.close();
		fos.close();
		*/
		open();
	}
	
	private int index = 0; // 제품 갯수 확인 
	
	
	
	@Override
	public void add(Product product) throws Exception {
		for(Product p: list)
		{
			if(p.getName().equals(product.getName()))
				throw new Exception();
		}
		
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
	public ArrayList<Product> search(int num) throws Exception {
		ArrayList<Product> tmp = new ArrayList<>();
		
		for(Product p: list)
		{
			if(p.getProductnum()==num)
			{
				tmp.add(p);
			}
		}
		if(tmp.isEmpty())
			throw new Exception();
		
		return tmp;
	} //제품 종류에 따른 검색 기능 

	


	@Override
	public ArrayList<Product> searchTv(int size) throws Exception {
		ArrayList<Product> tmp = new ArrayList<>();
		
		for(Product p: list)
		{
			if(p instanceof TV)
			{
				if(((TV) p).getSize()>=size)
					tmp.add(p);
			}
		}
		
		if(tmp.isEmpty())
			throw new Exception();
		return tmp;
	}

	@Override
	public ArrayList<Product> searchRef(int capacity) throws Exception {
		ArrayList<Product> tmp = new ArrayList<>();
		
		for(Product p: list)
		{
			if(p instanceof Refrigerator)
			{
				if(((Refrigerator) p).getCapacity()>=capacity)
					tmp.add(p);
			}
		}
		
		if(tmp.isEmpty())
			throw new Exception();
		return tmp;
	}

	@Override
	public void open() throws Exception {
		FileInputStream fis = new FileInputStream("product.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		try {
		for(Product p; (p=(Product)ois.readObject())!=null;)
				{
					add(p);
				}
	}catch (Exception e)
		{
		
		}
		
	}

	@Override
	public void close() throws Exception {
		FileOutputStream fos = new FileOutputStream("product.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		for(Product p : list)
		{
			oos.writeObject(p);
		}

		oos.close();
		fos.close();
	}
	


}//end of class 
