import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO_WS {
	private Connection conn; // 데이터베이스와 통신하기위한 객체
	// BookDAO 을 싱글톤 패턴으로 사용해보자
	private BookDAO_WS() {

		try {
			String url = "jdbc:mysql://127.0.0.1/" + "mydb"; // 데이터베이스명
			url += "?characterEncoding=UTF-8&serverTimezone=UTC";
			String dbName = "mydb";
			String user = "root";
			String password = "tiger";
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(!conn.isClosed() + " : DB 연결 성공여부");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static BookDAO_WS instance;

	public static BookDAO_WS getInstance() {
		if (instance == null) {
			instance = new BookDAO_WS();
		}
		return instance;
	}

	/**
	 * 책 한권의 정보를 데이터베이스에 삽입하는 메서드
	 * 
	 * @param book
	 * @return
	 */
	public int insertBook(BookVO_WS book) {
		String sql = "INSERT INTO books VALUES(?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(0,book.getIsbn());
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getPublisher());
			pstmt.setInt(4, book.getPrice());
			pstmt.setString(5, book.getDescription());
			return pstmt.executeUpdate(); // 삽입, 삭제, 수정
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1; // 쿼리수행중 에러발생
	} // end of insert book

	/**
	 * book 하나의 정보를 받아서 id에 해당하는 레코드를 나머지 필드값으로 변경하기
	 */

	public int updateBook(BookVO_WS book) {
		String sql = "UPDATE books SET isbn=?, title=?, autor=?, publisher=?, price=?, description=? WHERE book_id=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(0,book.getIsbn());
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getPublisher());
			pstmt.setInt(4, book.getPrice());
			pstmt.setString(5, book.getDescription());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return -1;
	} // end of update

	public int deleteBook(BookVO_WS book) {
		String sql = "DELETE books WHERE isbn=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, book.getTitle());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return -1;
	}

	/**
	 * select * from books 실행해서 조회된 모든 책의 정보를 리스트로 만들어서 리턴.
	 */
	public List<BookVO_WS> selectAll() {
		List<BookVO_WS> list = new ArrayList<>();
		String sql = "SELECT * FROM books";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery(); // select할 때
			
			while (rs.next()) { // 다음 행의 데이터가 존재하면 true / 없으면 false
				BookVO_WS book = new BookVO_WS();
				pstmt.setInt(0,book.getIsbn());
				pstmt.setString(1, book.getTitle());
				pstmt.setString(2, book.getAuthor());
				pstmt.setString(3, book.getPublisher());
				pstmt.setInt(4, book.getPrice());
				pstmt.setString(5, book.getDescription());
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	} // select All
	
	public BookVO_WS selectOne(int isbn) {
		
		BookVO_WS book = new BookVO_WS();
		String sql = "SELECT * FROM books WHERE isbn=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,isbn);
			rs = pstmt.executeQuery(); // select할 때
			
			while (rs.next()) { // 다음 행의 데이터가 존재하면 true / 없으면 false
				pstmt.setInt(0,book.getIsbn());
				pstmt.setString(1, book.getTitle());
				pstmt.setString(2, book.getAuthor());
				pstmt.setString(3, book.getPublisher());
				pstmt.setInt(4, book.getPrice());
				pstmt.setString(5, book.getDescription());
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return book;
	}

}
