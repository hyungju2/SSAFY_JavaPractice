package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.BookVO;

public class BookDAO {
	private Connection conn; // 데이터베이스와 통신하기위한 객체
	// BookDAO 을 싱글톤 패턴으로 사용해보자

	private BookDAO() {

		try {
			//웹 어플리케이션에서는 클래스 네임 적재 생략 불가
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); //드라이버 적재
			
			String url = "jdbc:mysql://127.0.0.1/" + "mydb"; // 데이터베이스명
			url += "?characterEncoding=UTF-8&serverTimezone=UTC";
			String dbName = "mydb";
			String user = "root";
			String password = "tiger";

			conn = DriverManager.getConnection(url, user, password);
			System.out.println(!conn.isClosed() + " : DB 연결 성공여부");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static BookDAO instance;

	public static BookDAO getInstance() {
		if (instance == null) {
			instance = new BookDAO();
		}
		return instance;
	}

	/**
	 * 책 한권의 정보를 데이터베이스에 삽입하는 메서드
	 * 
	 * @param book
	 * @return
	 */
	public int insertBook(BookVO book) {
		String sql = "INSERT INTO books VALUES(0,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getPublisher());
			pstmt.setString(3, book.getYear());
			pstmt.setInt(4, book.getPrice());
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

	public int updateBook(BookVO book) {
		String sql = "UPDATE books SET title=?, publisher=?, year=?, price=? WHERE book_id=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getPublisher());
			pstmt.setString(3, book.getYear());
			pstmt.setInt(4, book.getPrice());
			pstmt.setInt(5, book.getBookid());

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

	public int deleteBook(BookVO book) {
		String sql = "DELETE books WHERE book_id=?";
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
	public List<BookVO> selectAll() {
		List<BookVO> list = new ArrayList<>();
		String sql = "SELECT * FROM books";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery(); // select할 때
			
			while (rs.next()) { // 다음 행의 데이터가 존재하면 true / 없으면 false
				BookVO book = new BookVO();
				book.setBookid(rs.getInt(1));
				book.setTitle(rs.getString(2));
				book.setPublisher(rs.getString(3));
				book.setYear(rs.getString(4));
				book.setPrice(rs.getInt(5));
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
	
	public BookVO selectOne(int bookid) {
		
		BookVO book = new BookVO();
		String sql = "SELECT * FROM books WHERE book_id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,bookid);
			rs = pstmt.executeQuery(); // select할 때
			
			while (rs.next()) { // 다음 행의 데이터가 존재하면 true / 없으면 false
				
				book.setBookid(rs.getInt(1));
				book.setTitle(rs.getString(2));
				book.setPublisher(rs.getString(3));
				book.setYear(rs.getString(4));
				book.setPrice(rs.getInt(5));
				
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
