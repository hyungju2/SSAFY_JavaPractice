package com.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class CharacterStreamTest {
	
	public static void main(String[] args) throws Exception {
		//character Stream: 한 글자의 정보를 2byte에 담아서 전송.
	
		//임시파일 생성
		File f = File.createTempFile("sample", "txt");
		System.out.println(f);
		
		//19~30 : 파일에 쓰기 (내용 저장)
		FileWriter fw = new FileWriter(f); //NodeStream(목적지에 직접 연결되어 쓰기작업 수행) 
										   //파일에 바로 생성해서 파이프 만듦.
							
		BufferedWriter bw = new BufferedWriter(fw); //filter stream. 가공작업. 버퍼기능 추가
		
		bw.write("안녕하세요");
		bw.newLine(); //줄 바꿈
		bw.write("빨리 집에 가고 싶다");
		bw.newLine();
		
		bw.close();
		fw.close();
		
		//33~40: 파일에서 읽어오기
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr); //필터는 반드시 노드스트림 있어야 함.
		
		for(String str; (str = br.readLine())!=null;) //줄 단위 읽음. 버퍼에만 있음
			System.out.println(str);
		
		br.close();
		fr.close();
	
		//InputStreamReader:InputStream 타입의 스트림을 Reader 타입의 스트림으로 변환시켜줌
		//(Byte Stream -> Char Stream)
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		//줄 단위로 한번에 읽어야 시간초과x
		
		
		
	}
}
