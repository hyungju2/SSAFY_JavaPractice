package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Product;

public class ProductDAO {
	private Connection conn; // 데이터베이스와 통신하기위한 객체
	// BookDAO 을 싱글톤 패턴으로 사용해보자
	private ProductDAO() {

		try {
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

	private static ProductDAO instance;

	public static ProductDAO getInstance() {
		if (instance == null) {
			instance = new ProductDAO();
		}
		return instance;
	}

	/**
	 * 책 한권의 정보를 데이터베이스에 삽입하는 메서드
	 * 
	 * @param book
	 * @return
	 */
	public int insertProduct(Product product) {
		String sql = "INSERT INTO product VALUES(0,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getTitle());
			pstmt.setString(2, product.getKind());
			pstmt.setString(3, product.getMaker());
			pstmt.setInt(4, product.getPrice());
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

	public int updateProduct(Product product) {
		String sql = "UPDATE product SET title=?, kind=?, maker=?, price=? WHERE isbn=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareCall(sql);
			
			pstmt.setInt(5, product.getIsbn());
			pstmt.setString(1, product.getTitle());
			pstmt.setString(2, product.getKind());
			pstmt.setString(3, product.getMaker());
			pstmt.setInt(4, product.getPrice());
			
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

	public int deleteProduct(Product product) {
		String sql = "DELETE product WHERE isbn=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, product.getIsbn());
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
	public List<Product> selectAll() {
		List<Product> list = new ArrayList<>();
		String sql = "SELECT * FROM product";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // select할 때
			
			while (rs.next()) { // 다음 행의 데이터가 존재하면 true / 없으면 false
				Product product = new Product();
				product.setIsbn(rs.getInt(1));
				product.setTitle(rs.getString(2));
				product.setKind(rs.getString(3));
				product.setMaker(rs.getString(4));
				product.setPrice(rs.getInt(5));
				list.add(product);
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
	
	public Product selectOne(int isbn) {
		
		Product product = new Product();
		String sql = "SELECT * FROM product WHERE isbn=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,isbn);
			rs = pstmt.executeQuery(); // select할 때
			
			while (rs.next()) { // 다음 행의 데이터가 존재하면 true / 없으면 false
				product.setIsbn(rs.getInt(1));
				product.setTitle(rs.getString(2));
				product.setKind(rs.getString(3));
				product.setMaker(rs.getString(4));
				product.setPrice(rs.getInt(5));
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
		return product;
	}

}
