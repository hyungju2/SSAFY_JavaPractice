package com.sax;

import java.io.IOException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class BookSaxParsing extends DefaultHandler {
	public BookSaxParsing() {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			// this:parsing 도중 발생하는 사건처리를 담당할 객체
			//parser.parse("xml/book.xml", this); // 사건을 처리하는 핸들러가 필요함.
			parser.parse("xml/book.xml", new FindBookEventHandler("author","이규미")); // 사건을 처리하는 핸들러가 필요함.
		
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		new BookSaxParsing();
	}// end of main

	// 문서의 시작인 경우
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Document 시작!");
	}

	// 문서의 끝인 경우
	@Override
	public void endDocument() throws SAXException {
		System.out.println("Document 끝!");
	}

	// 문서 시작하는 Element를 만나는 경우 호출됨
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equals("booklist")) {
			System.out.println("<bookList>");
		} else if (qName.equals("book")) {
			
			System.out.println("<book kind>="+attributes.getValue("kind"));
		} else if (qName.equals("title")) {
			System.out.println("<title>");
		} else if (qName.equals("author")) {
			System.out.println("<author>");
		} else if (qName.equals("publisher")) {
			System.out.println("<publisher>");
		} else if (qName.equals("price")) {
			System.out.println("<price>");
		}
	}

	// 문서 중간에 끝나는 Element를 만나는 경우 호출됨
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("booklist")) {
			System.out.println("<bookList>");
		} else if (qName.equals("book")) {
			System.out.println("<book>");
		} else if (qName.equals("title")) {
			System.out.println("<title>");
		} else if (qName.equals("author")) {
			System.out.println("<author>");
		} else if (qName.equals("publisher")) {
			System.out.println("<publisher>");
		} else if (qName.equals("price")) {
			System.out.println("<price>");
		}
	}

	// 문서 중간에 text node 만나는 경우 호출됨
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String str = new String(ch, start, length);
		System.out.println(str);
	}
}// end of classl
