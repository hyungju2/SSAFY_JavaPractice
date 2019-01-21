package Book;

import java.util.ArrayList;

public interface IBookMgr {

		public void add(Book b);
		public ArrayList<Book> search();
		public void sell(int isbn, int quantity) throws Exception;
		public void buy(int isbn, int quantity) throws Exception;
		public int getTotalAmount();
		public void open() throws Exception;
		public void close() throws Exception;
}
