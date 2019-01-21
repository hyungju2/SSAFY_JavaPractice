package Book;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BookMgrImpl implements IBookMgr{

	ArrayList<Book> list;
	
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
