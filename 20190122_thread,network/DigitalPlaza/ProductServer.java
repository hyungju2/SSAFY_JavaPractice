package DigitalPlaza;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ProductServer {

		ServerSocket server;
		Socket s1;
		String sendString = "오늘 간식 샌드위치 포함 빵 4개 및 우유 3종";
		InputStream s1out;
		DataOutputStream dos;
		
		InputStream s1in;
		DataInputStream dis;
		

		  
		  public ProductServer() {
			connect();
		  }

		  public void connect(){
				try {
					server = new ServerSocket(6500); //1. serversocket 생성.
					System.out.println("서버 켜짐");
					
					s1 = server.accept();	//2. 클라이언트가 접속하기를 기다렸다가 받음. Block이되는 특징.
					System.out.println("접속됨");

					s1out = s1.getInputStream(); //출력용 파이프. 출력용 스트림 얻어냄.
					ObjectInputStream oos = new ObjectInputStream(s1out);
					
					int num = oos.readInt();
					System.out.println(num);
					for(int i=0; i<num; i++){
						Product k = (Product)oos.readObject();
						System.out.println(k.toString());
					}
					

				}catch(Exception e) {
					e.printStackTrace();
				}
			 } 

		 
		  public static void main(String args[]) {
			  ProductServer bs = new ProductServer();			  
}
	}
