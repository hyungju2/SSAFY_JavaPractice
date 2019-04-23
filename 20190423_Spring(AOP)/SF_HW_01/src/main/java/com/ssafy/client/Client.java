package com.ssafy.client;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ssafy.model.repository.BookRepository;

public class Client {

	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("config/ApplicationContext.xml");
		BookRepository bookRepository = context.getBean("bookReq", BookRepository.class);
		try {
			bookRepository.selectAll(); 
			}catch(Exception e) {
			
		}
	
	}//end of main
} //end of class
