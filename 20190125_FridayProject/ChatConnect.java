package GUI;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import com.net.Server;

public class ChatConnect {

	  public Socket socket = null;
	  public ObjectInputStream ois;
	  public ObjectOutputStream oos;
	  ChatConnectThread ct;
	  ChatClient c;
	  String ip;
	  int port;
	  String name;
	  public ChatConnect(String ip, int port, String name, ChatClient c)
	  {
		  this.ip = ip;
		  this.port = port;
		  this.name = name;
		  this.c = c;
	  }
	  public void go()
		  {
		  try{
			 socket = new Socket(ip,port);
			 OutputStream outputStream = socket.getOutputStream();
			 oos = new ObjectOutputStream(outputStream);
			 InputStream inputStream = socket.getInputStream();
			 ois = new ObjectInputStream(inputStream);
			 ct = new ChatConnectThread(ois);
			 ct.start();			 
		  }catch(Exception e)
			  {
				  
			  }
		  } 
	  public void send(String str) {
		  try {
			  oos.writeObject(str);
			  oos.flush();
		  }catch(Exception e)
		  {
			    
		  }
	  }
	  
	  public class ChatConnectThread extends Thread{
		ObjectInputStream ois;
		
		public ChatConnectThread(ObjectInputStream ois)
		{
			this.ois = ois;
	  	}
		
		public void run(){
			try {
				while(true) {
					String str = (String)ois.readObject();
					c.show(str);
				}
			} catch (Exception e) {
			}
		}
	  }
	  }//end of class