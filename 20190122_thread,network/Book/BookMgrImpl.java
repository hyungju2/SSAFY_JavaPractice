package Book;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class BookMgrImpl implements IBookMgr{

	ArrayList<Book> list;
	 
	ServerSocket server;
	Socket socket = null;
	
	InputStream inputStream = null;
	OutputStream outputStream = null;
	ObjectOutputStream dis = null;
	DataOutputStream dos = null;

	Socket s1;
	OutputStream s1in;

	
	
	//내부 클래스 : Server로 Book 정보 전송.
	class BookClient extends Thread  {
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
				for(Book bk : list)
					dis.writeObject(bk);
					
			}
			catch(Exception e)
			{
				
			}
		}
	}
	
	public void send() throws Exception {
		BookClient bc = new BookClient();
		bc.start();
	}
	
	
	
	BookMgrImpl() throws Exception{
		list = new ArrayList<>();
		/*Book book = new Book(1, "books", 30000, 2);
		FileOutputStream fos = new FileOutputStream("book.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(book);
		oos.close();
		fos.close();*/
		
		open();
	}
	
	private int index = 0;
	
	@Override
	public void add(Book b) {
		list.add(b);
		index++;
	} //도서 추가

	@Override
	public ArrayList<Book> search() {
		return list;
	} //전체 리스트 출력

	@Override
	public void sell(int isbn, int quantity) throws Exception {
	int num = -1;
		int ind = 0;
		for(Book b : list)
		{
			num++;
			if(b.getIsbn()==isbn)
			{
				ind = num;
			}
		}
		if(ind==0)
			throw new Exception();
		
		if(list.get(ind).getQuantity()-quantity<0)
			throw new Exception();
	
		list.get(ind).setQuantity(list.get(ind).getQuantity()-quantity);
	} //물품 판매

	@Override
	public void buy(int isbn, int quantity) throws Exception {
		int num = -1;
		int ind = 0;
		for(Book b : list)
		{
			num++;
			if(b.getIsbn()==isbn)
			{
				ind = num;
			}
		}
		if(ind==0)
			throw new Exception();
		
		list.get(ind).setQuantity(list.get(ind).getQuantity()+quantity);
	} //제고 추가

	@Override
	public int getTotalAmount() {
		int money = 0;
		for(int i=0; i<index; i++)
		{
			money+=list.get(i).getPrice();
		}
		return money;
	} //전체 금액 합계

	@Override
	public void open() throws Exception {
		FileInputStream fis = new FileInputStream("book.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		try {
		for(Book b; (b=(Book)ois.readObject())!=null;)
				{
					add(b);
				}
	}catch (Exception e)
		{
		
		}
	}
	
	@Override
	public void close() throws Exception {
		FileOutputStream fos = new FileOutputStream("book.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		for(Book bks : list)
		{
			oos.writeObject(bks);
		}

		oos.close();
		fos.close();
	}

	
	
}
