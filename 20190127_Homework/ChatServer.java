package GUI;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

	public static ServerSocket svrSocket = null;
    public static Socket socket = null;
	public static InputStream inputStream = null;
	public static OutputStream outputStream = null;
	public static DataInputStream dis = null;
	public static DataOutputStream dos = null;
	public static String message;
	int port;
	
	public ChatServer() {
		try {
			svrSocket = new ServerSocket(6571);
			System.out.println("서버 연결중~");
			
			socket = svrSocket.accept();
			System.out.println("클라이언트와 연결");
			
			inputStream = socket.getInputStream();
			dis = new DataInputStream(inputStream);
			outputStream = socket.getOutputStream();
			dos = new DataOutputStream(outputStream);
			
		}catch(Exception e)
		{
			
		}
	}
	
	
	public static void main(String[] args)  {
		
			ChatServer cs = new ChatServer();
		
			System.out.println("소켓생성");
			
			for(;;) {
				cs.readSocket();
				cs.writeSocket();
			}
	}
	
	public void readSocket() {
		try {
			message = dis.readUTF();
			System.out.print(message);
		}catch(Exception e)
		{
			
		}
	}
	  public void writeSocket(){
		    try {
		      dos.writeUTF(message);
		    }catch(Exception e) {

		    }
		  }

	
	class ChatServerThread extends Thread{
		
		private ObjectInputStream ois;
		
		public ChatServerThread(ObjectInputStream ois) {
			this.ois = ois;
		}
		
		@Override
		public void run() {
			try {
				while(true) {
						String str = (String)ois.readUTF();
				}
			}  catch (Exception e) {
			}
		}
		
	}
}


