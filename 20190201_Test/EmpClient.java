package com.ssafy.emp;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;



public class EmpClient extends Thread{
	public static ObjectInputStream ois;
	private List<Employee> emps;
	private String ip = "127.0.0.1";
	private int port = 6500;
	
	public EmpClient(List<Employee> e) throws Exception{

		Socket socket = new Socket(ip,port);
		InputStream inputstream = socket.getInputStream();
		ObjectInputStream ois = new ObjectInputStream(inputstream);
		OutputStream outputstream = socket.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(outputstream);
	}
	
	public void run() {
		try {
			String s = (String)ois.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
