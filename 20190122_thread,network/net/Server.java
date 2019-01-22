package com.net;
import java.io.*;
import java.net.*;

public class Server{

  public ServerSocket svrSocket = null;
  public Socket socket = null;
  public InputStream inputStream = null;
  public OutputStream outputStream = null;
  public DataInputStream dis = null;
  public DataOutputStream dos = null;
  public String message = "Server!";

  public Server() {
    try {
     // ServerSocket생성 6500
     svrSocket = new ServerSocket(6500);
     System.out.println("서버와 연결중!");
   
    	//accept();
      socket = svrSocket.accept();
      System.out.println("\n클라이언트와 연결!\n");

	 //io stream
      
        inputStream = socket.getInputStream();
        dis = new DataInputStream(inputStream);
        outputStream = socket.getOutputStream();
		dos = new DataOutputStream(outputStream);
		
      
    }catch( Exception e ) {
		System.out.println("에러 : I/O 에러가 발생했습니다." + e); }
  }

  public void readSocket(){
	try {   
		message = dis.readUTF();
		System.out.println(message );		

    }catch( UnknownHostException e) {
		System.out.println("에러 : 서버를 찾을 수 없습니다." + e);

    }catch( IOException e ) {
		System.out.println("에러 : I/O 에러가 발생했습니다." + e);
		try{
			dis.close();
			dos.close();
			socket.close();
			svrSocket.close(); //*****
		}catch(Exception a){ }
		System.exit(0);
	}
  }

  public void writeSocket(){
    try {
      dos.writeUTF(message + "\n");
    }catch( UnknownHostException e) {
		System.out.println("에러 : 서버를 찾을 수 없습니다." + e);

    }catch( IOException e ) {
		System.out.println("에러 : I/O 에러가 발생했습니다." + e);		
    }
  }

  public static void main(String args[]) {
    Server svr = new Server();
    for(;;){
      svr.readSocket();
      svr.writeSocket();
	  }
  }
}




