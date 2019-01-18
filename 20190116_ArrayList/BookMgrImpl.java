package Book;

import java.util.ArrayList;
import java.util.Arrays;


public class BookMgrImpl implements IBookMgr{

	ArrayList<Book> list;
	
	BookMgrImpl(){
		list = new ArrayList<>();
	}
	
	
	private int index = 0;
	
	public void add(Book data)
	{
		list.add(data);
	} //데이터 입력기능

	public ArrayList<Book> search() {
		return list;
	} //데이터 전체 검색기능
	
	public ArrayList<Book> search(int num) {
		
		ArrayList<Book> tmp = new ArrayList<>();
		
		for(Book p: list)
		{
			if(p.getIsbn() == num)
				tmp.add(p);
		}
		return tmp;
	} //isbn으로 검색하는 기능
	
	public ArrayList<Book> search(String name)
	{
		ArrayList<Book> tmp = new ArrayList<>();
		
		for(Book p: list)
		{
			if(p.getTitle().equals(name))
				tmp.add(p);
		}
		return tmp;
	} //Title로 정보를 검색하는 기능.
	
	
	public ArrayList<Book> searchBook()
	{
		
		ArrayList<Book> tmp = new ArrayList<>();
		
		for(Book p: list)
		{
			if(p instanceof Book)
				tmp.add(p);
		}
		return tmp;
		
	} //Book만 검색하는 기능
	

	public ArrayList<Book> searchMagazine()
	{
		ArrayList<Book> tmp = new ArrayList<>();
		
		for(Book p: list)
		{
			if(p instanceof Magazine) {
				tmp.add(p);
			}
		}
		return tmp;
	} //magazine만 검색하는 기능

	
	public ArrayList<Book> searchPublisher(String publisher)
	{
		ArrayList<Book> tmp = new ArrayList<>();
		
		for(Book p: list)
		{
			if(p.getPublisher().equals(publisher))
				tmp.add(p);
		}
		return tmp;
	} //출판사로 정보를 검색하는 기능.
	
	
	public ArrayList<Book> searchPrice(int price)
	{
		ArrayList<Book> tmp = new ArrayList<>();
		
		for(Book p: list)
		{
			if(p.getPrice()<=price)
				tmp.add(p);
		}
		return tmp;
	} //가격으로 검색기능(주어진 파라메터보다 가격 낮은 도서)
	

	public ArrayList<Book> searchYear(int year) {
		
		ArrayList<Book> tmp = searchMagazine();
		ArrayList<Book> b = new ArrayList<>();
		
		for(Book p: tmp)
		{
			if(((Magazine)p).getYear()==year)
				b.add(p);
		}

		return b;
	}
	
	
	public int getSum()
	{
		int count=0;
		for(Book p: list)
		{
			count+=p.getPrice();
		}
		return count;
	} //도서의 총 합계
	
	public int getAvg()
	{
		return getSum()/list.size();
	} //도서의 평균
	
	public int getSize()
	{
		return list.size();
	}


}
