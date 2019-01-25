package GUI;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatServer {
	
	ArrayList<ChatUser> users = new ArrayList<>();
	int port;

	public void alluser(String str) {
		for(ChatUser user : users) {
			ObjectOutputStream oos = user.getoos();
			try {
				oos.writeObject(str);
				oos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	private void removeClient(ObjectInputStream ois) {
		int a = 0;
		try {
			for(ChatUser user : users) {
				if(user.getois() == ois) {
					user.getois().close();
					user.getoos().close();
					user.getsocket().close();
					break;
				}
				a++;
			}
			users.remove(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args)  {
		System.out.println("서버 연결중~");
		Scanner sc = new Scanner(System.in);

		try {
			ChatServer cs = new ChatServer();
			ServerSocket ss = new ServerSocket(6571);
			Socket s;
			InputStream in;
			ObjectInputStream ois;
			OutputStream out;
			ObjectOutputStream oos;
			ChatServerThread cst;
			while(true) {
				s = ss.accept();
				out = s.getOutputStream();
				oos = new ObjectOutputStream(out);
				in = s.getInputStream();
				ois = new ObjectInputStream(in);
				cs.users.add(new ChatUser(s, ois, oos));
				System.out.println("신규 유저 접속, (현재 유저수 : " + cs.users.size() + ")");
				oos.writeObject("로그인 하셨습니다.");
	
				oos.flush();
				cst = cs.new ChatServerThread(ois);
				cst.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
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
						String str = (String)ois.readObject();
						alluser(str);
				}
			}  catch (Exception e) {
				removeClient(ois);
				System.out.println("유저 접속 종료, (현재 유저수 : " + users.size() + ")");
			}
		}
		
	}
}


