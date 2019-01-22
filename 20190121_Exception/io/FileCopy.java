package com.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileCopy {
	public static void main(String[] args) {
		
		//byte Stream : 한글자의 정보를 1byte에 담아서 전송.
		
		FileInputStream fis;
		FileOutputStream fos;
		
		//args[0] 원본파일
		//args[1] 복사본 파일
		
		try {
			fis = new FileInputStream(args[0]);
			fos = new FileOutputStream(args[1]);
			
			for(int i; (i = fis.read()) != -1;) { //파일의 끝 = -1
				System.out.println(i);
				fos.write(i); //i에 해당하는 글자로 바꿔서 출력하는 메소드.
			}
			
			// 다 사용했으면, Stream을 반드시 close해야 함.
			fis.close();
			fos.close();
			
			System.out.println("file copied...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
