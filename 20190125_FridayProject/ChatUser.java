package GUI;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ChatUser {

	Socket socket;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	ChatUser(Socket socket, ObjectInputStream ois, ObjectOutputStream oos)
	{
		this.socket = socket;
		this.ois = ois;
		this.oos = oos;
	}
	
	public Socket getsocket() {
		return socket;
	}
	
	public ObjectInputStream getois() {
		return ois;
	}
	
	public ObjectOutputStream getoos() {
		return oos;
	}
}

