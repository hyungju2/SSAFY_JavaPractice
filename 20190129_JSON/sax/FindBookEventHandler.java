package com.sax;

import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.util.*;

public class FindBookEventHandler extends DefaultHandler {
	/// Field
	private boolean isBook, istitle, isauthor, isPrice;
	private String condition, keyWord;
	private HashMap hash;
	private Attributes attributes;
	static int cnt;

	/// Constructor
	public FindBookEventHandler(String condition, String keyWord) {
		// 검색 엘리먼트
		this.condition = condition;
		// 검색 문자열
		this.keyWord = keyWord;
		// 검색 내용을 저장할 HashMap
		this.hash = new HashMap();
	}

	/// Method
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if (qName.equals("book")) {
			isBook = true;
			String isbn = attributes.getValue("kind");
			
			hash.put("kind", isbn);
			
		} else if (qName.equals("title")) {
			istitle = true;
		} else if (qName.equals("author")) {
			isauthor = true;
		} else if (qName.equals("price")) {
			isPrice = true;
		}
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		//System.out.println("characters:" + ++cnt);
		String str = new String(ch, start, length).trim();
		if (istitle) {
			hash.put("title", str);
			istitle = false;
			
		} else if (isauthor) {
			hash.put("author", str);
			isauthor = false;
			
		} else if (isPrice) {
			hash.put("price", str);
			isPrice = false;
		}
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		//System.out.println("endElement:" + ++cnt + ":" + qName);
		if (qName.equals("book")) {
			if (condition.equals("kind")) {
				String isbn = (String) hash.get("kind");
				if (isbn.indexOf(keyWord) != -1)
					displayBookInfo();
			} else if (condition.equals("title")) {
				String title = (String) hash.get("title");
				if (title.indexOf(keyWord) != -1)
					displayBookInfo();
			} else if (condition.equals("author")) {
				String author = (String) hash.get("author");
				if (author.indexOf(keyWord) != -1)
					displayBookInfo();
			}
			hash.clear();
			isBook = false;
		}
	}

	public void displayBookInfo() {
		System.out.println("title: " + (String) hash.get("title"));
		System.out.println("author: " + (String) hash.get("author"));
		System.out.println("price: " + (String) hash.get("price"));
		System.out.println("----------------------");
	}

	public void warning(SAXParseException exception) throws SAXException {
		throw new SAXException("warning �̺�Ʈ ó��");
	}

	public void error(SAXParseException exception) throws SAXException {
		System.out.println("DTD �Ǵ� XML Schema ���� ������ ����˴ϴ�.");
		System.out.println("��ȿ���� �ʴ� ���� �Դϴ�.");
		throw new SAXException("error �̺�Ʈ ó��");
	}

	public void fatalError(SAXParseException exception) throws SAXException {
		System.out.println("XML �ǰ���� ������ ��Ű�� �ʾҽ��ϴ�.");
		System.out.println("�� ¥���� XML ������ �ƴմϴ�.");
		throw new SAXException("fatalError �̺�Ʈ ó��");
	}
}