package com.ssafy.model.service;
import java.util.List;
import com.ssafy.model.dto.Book;

public interface BookService {
	public int insert(Book book);
	public int update(Book book);
	public int delete(String isbn);
	public Book select(String isbn);
	public List<Book> selectAll();
}
