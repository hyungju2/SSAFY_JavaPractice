package com.ssafy.model.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dto.Book;
import com.ssafy.model.repository.*;

@Service("bookService") // 서비스를 제공하는 경우
public class BookServiceImpl implements BookService {
	@Autowired
	
	private BookRepository bookRepo;
	
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
		System.out.println("bookRepo의 SelectAll() 메서드");
		bookRepo.selectAll();
		return null;
	}
}
