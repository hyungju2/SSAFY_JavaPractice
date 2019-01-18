package Book;

import java.util.ArrayList;

public interface IBookMgr {

	public void add(Book data);
	public ArrayList<Book> search();

	public ArrayList<Book> search(int num);
	public ArrayList<Book> search(String name);
	public ArrayList<Book> searchBook();
	public ArrayList<Book> searchMagazine();
	public ArrayList<Book> searchPublisher(String publisher);
	public ArrayList<Book> searchPrice(int price);
	public ArrayList<Book> searchYear(int year);
	public int getSum();
	public int getAvg();
	public int getSize();
	
}
