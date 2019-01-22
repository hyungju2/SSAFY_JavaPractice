package com.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleServer {
	
	public static void main(String[] args) throws Exception {
		/**
		 * 1. ServerSocket(port) 생성.
		 * 2. Server.accept() : 클라이언트가 접속해 오기를 기다렸다가 받는 메소드 
		 * 3. Socket 객체로 I/O 스트림 생성
		 * 4. 스트림으로 통신
		 * 5. close() : 마무리
		 */

		ServerSocket server;
		Socket s1;
		String sendString = "오늘 간식 샌드위치 포함 빵 4개 및 우유 3종";
		OutputStream s1out;
		DataOutputStream dos;
		
		InputStream s1in;
		DataInputStream dis;
		

		
		try {
			//서버에서 클라이언트로 보냄.
			server = new ServerSocket(6500); //1. serversocket 생성.
			System.out.println("난 아직 열애중~~~");
			
			s1 = server.accept();	//2. 클라이언트가 접속하기를 기다렸다가 받음. Block이되는 특징.
			System.out.println("너와 이별하는중~~~");

			s1out = s1.getOutputStream(); //출력용 파이프. 출력용 스트림 얻어냄.
			
			ObjectOutputStream oos = new ObjectOutputStream(s1out);
			oos.writeObject(new Book(1,"apple",300,2)); //Object를 보내는 필터.
			
			/*dos = new DataOutputStream(s1out); //Filter
			dos.writeUTF(sendString);
			*/
			
			//메세지 수신
			s1in = s1.getInputStream();
			dis = new DataInputStream(s1in);
			String message = dis.readUTF(); //readUTF도 Block됨.
			System.out.println(message);
			
			dis.close();
			s1in.close();			
			oos.close();
			//dos.close();
			s1out.close();
			s1.close();
			server.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
