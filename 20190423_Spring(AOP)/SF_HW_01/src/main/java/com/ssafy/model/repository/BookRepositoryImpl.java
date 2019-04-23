package com.ssafy.model.repository;
import java.util.List;

import com.ssafy.model.dto.Book;
/**
 * @Component 어노테이션의 자식 3개
 * 
 * @Repository : Persistence Layer, 영속성을 갖고 있을 떄 사용. 파일에 저장하거나, DB에 저장하는 경우에 사용.
 * @Service : Service Layer
 * @Controller : Presentation Layer
 * 
 *
 */
public class BookRepositoryImpl implements BookRepository {
	public int insert(Book book) {
		return 0;
	}
	public int update(Book book) {
		return 0;
	}
	public int delete(String isbn) {
		return 0;
	}
	public Book select(String isbn) {
		return null;
	}
	public List<Book> selectAll() {
		System.out.println("BookRepositoryImpl의 SelectAll()메서드");
		return null;
	}
}
