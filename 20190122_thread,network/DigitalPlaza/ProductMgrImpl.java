package DigitalPlaza;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;



public class ProductMgrImpl implements ProductMgr{

	ArrayList<Product> list;
	
	ServerSocket server;
	Socket socket = null;
	
	InputStream inputStream = null;
	OutputStream outputStream = null;
	ObjectOutputStream dis = null;
	DataOutputStream dos = null;

	Socket s1;
	OutputStream s1in;

	//내부 클래스 : Server로 Book 정보 전송.
	class ProductClient extends Thread  {
		public void run() { //thread가 작업할 내용이 있는 메소드 -> Server로 Book정보 전송.	
			try {
				s1 = new Socket("127.0.0.1",6500);
			 
			try {
				s1in = s1.getOutputStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				ObjectOutputStream dis = new ObjectOutputStream(s1in);
				System.out.println(list.size());
				dis.writeInt(list.size());
				for(Product bk: list)
					dis.writeObject(bk);
					
			}
			
			catch(Exception e)
			{
				
			}
		}
	}
	
	public void send() throws Exception {
		ProductClient bc = new ProductClient();
		bc.start();
	}
	
	
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
