package com.ssafy.emp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EmpServer {

	private int port = 6500;
	public static ObjectInputStream ois;
	public static InputStream inputstream;
	public static ObjectOutputStream oos;
	public static OutputStream outputstream;
	public static String s;
	
	public EmpServer() throws Exception{
		
		System.out.println("ServerSocket ok. port=6500");
		ServerSocket svrsocket = new ServerSocket(port);
		
		Socket socket = svrsocket.accept();
		System.out.println("ServerReady");
	
		
		InputStream inputstream = socket.getInputStream();
		DataInputStream dis = new DataInputStream(inputstream);
		OutputStream outputstream = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(outputstream);
		
	}
	
	public static void main(String[] args) throws Exception {
		EmpServer e = new EmpServer();
			for(;;) {
			e.readSocket();
		}
	}
	
	public void readSocket() {
		try {
			String s = (String)ois.readObject();
			System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
