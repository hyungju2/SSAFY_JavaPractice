package com.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileTest {
	public static void main(String[] args) {
		new FileTest().go();
	}

	private void go() {
		hello();
}

	private void hello() {
		//파일로부터 읽어들이는 입력 파이프
		try {
			FileInputStream fis = new FileInputStream("data.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
