import java.util.List;

public class BookDAOTest_WS {
	public static void main(String[] args) {
		BookDAO_WS dao = BookDAO_WS.getInstance(); // 외부에서 생성 못함
		BookVO_WS book = new BookVO_WS();
		/*book.setTitle("This is JDBC");
		book.setPublisher("this is");
		book.setYear("2080");
		book.setPrice(10000);
		
		int result = dao.insertBook(book);
		System.out.println("Insert 결과 : "+ result + "개의 행이 삽입되었습니다.");
		
		book.setTitle("This is NEW JDBC");
		book.setPublisher("this is new");
		book.setYear("1234");
		book.setPrice(50000);
		book.setBookid(16); // 몇번째 col을 변경할 건지 
		*/
		//result = dao.updateBook(book);
		List<BookVO_WS> list = dao.selectAll();
		
		for(BookVO_WS b : list) {
			System.out.println(b);
		}
		
		BookVO_WS b = dao.selectOne(6);
		System.out.println(b);
	} //end of main
}//end of class
