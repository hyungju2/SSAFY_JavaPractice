package com.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClient {
	public static void main(String[] args) throws Exception {
	/**
	 *  1. Socket(ip, port)생성 // 서버로 접속해서 들어감.
	 	2. Socket 객체로 I/O스트림 생성
	 	3. 스트림으로 통신
	 	4. Close() 마무리
	 */
		
		Socket s1;
		InputStream s1in;
		DataInputStream dis;
		
		ServerSocket server;
		Socket s2;
		String sendString = "빵을 많이주네요.";
		OutputStream s1out;
		DataOutputStream dos;
		
		
		
		// 서버에서 메세지 수신
		s1 = new Socket("127.0.0.1",6500);
		s1in = s1.getInputStream();
		dis = new DataInputStream(s1in);
		
		String message = dis.readUTF(); //readUTF도 Block됨.
		System.out.println(message);
		
		
		
		//메세지 수신
		
		// 클라이언트에서 발신
		server = new ServerSocket(6500); //1. serversocket 생성.
		System.out.println("난 아직 열애중~~~");
		
		s2 = server.accept();	//2. 클라이언트가 접속하기를 기다렸다가 받음. Block이되는 특징.
		System.out.println("너와 이별하는중~~~");

		s1out = s2.getOutputStream(); //출력용 파이프. 출력용 스트림 얻어냄.
		dos = new DataOutputStream(s1out); //Filter
		dos.writeUTF(sendString);	
		
		dos.close();
		s1out.close();
		s1.close();
		server.close();
		//서버 종료.
	
		dis.close();
		s1in.close();
		s1.close();
		// 클라이언트 수신 종료.
	}
}
