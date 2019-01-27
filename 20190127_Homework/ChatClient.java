package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



/**
 * 채팅화면 만들기
 * @author student
 *
 */
public class ChatClient implements ActionListener{
	  static OutputStream outputStream = null;
	  static InputStream inputStream = null;
	  static ObjectOutputStream oos;
	  static ObjectInputStream ois;
	  static DataOutputStream dos = null;
	  static DataInputStream dis = null;
	  static Socket socket = null;
	  static String msg;
	  public static String str;
	  static Frame f = new Frame("phone Book");
	  
	  static TextArea ta = new TextArea(); //여러줄의 글자를 입력, 출력하는 컴포넌트.
	  static TextField tf = new TextField(15); //한 줄의 글자를 입력 출력하는 컴포넌트.
	  static TextField tf2 = new TextField(15);
	  static TextField tf3 = new TextField(15);
	  static int index = 0;

	  static String ip;
	  static int port;
	  static String name;
	  static ChatConnect cc;

	  static ArrayList<Directory> list;
	  
	  
	  public ChatClient(String ip, int port) throws Exception
	  {
		  /*	Directory directory = new Directory("lee","010","Incheon");
			Directory dir = new Directory("kim","010","seoul");
		  	
			FileOutputStream fos = new FileOutputStream("directory.dat");
			
		  	ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(directory);
			oos.writeObject(dir);
		  	oos.close();
			fos.close();
			*/
			list = new ArrayList<>();
		 	open(); 
		
		 	cc = new ChatConnect(ip,port,this);
			socket = new Socket("127.0.0.1",6571);
			inputStream = socket.getInputStream();
			dis = new DataInputStream(inputStream);
			outputStream = socket.getOutputStream();
			dos = new DataOutputStream(outputStream);
			
			//cc.go();
		
	  }
	  
	  public void open() throws Exception {
			FileInputStream fis = new FileInputStream("directory.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			try {
			for(Directory d; (d=(Directory)ois.readObject())!=null;)
					{
						add(d);
					}
		}catch (Exception e)
			{
			
			}
		}

	  public static void add(Directory d) {
			list.add(d);
			index++;
		} //도서 추가

	  
	  public static void main(String[] args) {
		 try { 
		  ChatClient client = new ChatClient("127.0.0.1", 6571);
		  createGUI();
		  client.cc.go();
		 }
		 catch (Exception e){
			 
		 }
	  } //end of main
	
	public void connect(String ip, int port)
	{
		try {
			socket = new Socket(ip,port);
			inputStream = socket.getInputStream();
			dis = new DataInputStream(inputStream);
			outputStream = socket.getOutputStream();
			dos = new DataOutputStream(outputStream);
		}catch(Exception e)
		{
			
		}
	}
	
	public void show(String str) {
		ta.append(str+" ");
		tf.setText("");
	}
	
	public static void createGUI() {
		
			f.setBounds(500,200,600,500); //크기 지정
			f.setLayout(new BorderLayout());//안해도 됨. 원래 프레임의 기본 매니저는 BorderLayout
			ta.setBounds(500,200,300,200);
			
			Label lab = new Label();
			Label name = new Label();
			Label phone = new Label();
			Label Address = new Label();
			
			lab.setText("Phone Book");
			name.setText("이 름");
			phone.setText("핸드폰");
			Address.setText("주 소");
			
			Panel p = new Panel(); //Title		
			Panel p2 = new Panel(); // Text Area
			Panel p3 = new Panel(); //Button+ TextField+ Button
			Panel p4 = new Panel(); // Button
			Panel p5 = new Panel(); //name+phone+address = TextField
			Panel p9 = new Panel(); // Upload Button
			Panel p6 = new Panel(); // name
			Panel p7 = new Panel(); // Phone
			Panel p8 = new Panel(); // Address
			Panel p10 = new Panel();

			Button Insert = new Button("INSERT");
			Button Delete = new Button("DELETE");
			Button Update = new Button("UPDATE");
			Button Search = new Button("SEARCH");
			Button Upload = new Button("UPLOAD");
			Button Clear = new Button("CLEAR");
			Button Exit = new Button("EXIT");
			
			p.add(lab,BorderLayout.CENTER); //라벨 추가
			p2.add(ta,BorderLayout.CENTER); // Text Area 추
			
			p3.add(p,BorderLayout.NORTH);
			p3.add(p2,BorderLayout.SOUTH);
			
			p4.add(Insert);
			p4.add(Delete);
			p4.add(Update);
			p4.add(Search);
			p5.add(name);
			p5.add(tf);
			p6.add(phone);
			p6.add(tf2);
			p7.add(Address);
			p7.add(tf3);
			
			p8.add(p5,BorderLayout.NORTH);
			p8.add(p6,BorderLayout.CENTER);
			p8.add(p7,BorderLayout.SOUTH);
			
			p9.add(p4,BorderLayout.NORTH);
			p9.add(p8,BorderLayout.SOUTH);
			
			p10.add(Upload);
			p10.add(Clear);
			p10.add(Exit);
			
			f.add(p3,BorderLayout.NORTH);
			f.add(p9,BorderLayout.CENTER);
			f.add(p10,BorderLayout.SOUTH);

			for(Directory d: list)
			{
				ta.append(d.getName()+" ");
				ta.append(d.getPhone()+" ");
				ta.append(d.getAddress()+" "+"\n");
			}
			
			ta.setEditable(false);
			//이벤트 처리
			//Send 버튼 누르면, TextField의 값을 읽어서 서버에 전송. (TextArea에 값을 작성)
			//TextField의 값을 지워라. 공백으로 초기화.
			
			//Exit 버튼 클릭시 : 창을 닫기. Frame의 닫기 버튼.
			//TextField 엔터키 입력 : Send와 동일한 기능. 

			Insert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = tf.getText(); //문자 열을 읽어옴
					String str2 = tf2.getText();
					String str3 = tf3.getText();
					try {
						ta.append(str+" ");
						ta.append(str2+" ");
						ta.append(str3+" "+"\n");
						ChatClient.add(new Directory(str,str2,str3));
						tf.setText("");//글자 지우기
						tf2.setText("");
						tf3.setText("");
					} catch (Exception e1) {
					}
				}
			}); //추가기능.
			
			Delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = tf.getText(); //문자 열을 읽어옴
					int i=0;
					try {
						for(Directory d : list) {
						
							if(d.getName().equals(str))
							{
							 list.remove(i);
							 i--;
							}
							i++;
						}
						ta.setText(null);
						for(Directory d: list)
						{
							ta.append(d.getName()+" ");
							ta.append(d.getPhone()+" ");
							ta.append(d.getAddress()+" "+"\n");
						}
					} catch (Exception e1) {
					}
				}
			}); //삭제기능.
			

			Update.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = tf.getText(); //문자 열을 읽어옴
					String str2 = tf2.getText();
					String str3 = tf3.getText();
					
					try {
						for(Directory d : list) {
							
							if(d.getName().equals(str))
							{
							 d.setName(str);
							 d.setPhone(str2);
							 d.setAddress(str3);
							}
						}
						ta.setText(null);
						
						for(Directory d: list)
						{
							ta.append(d.getName()+" ");
							ta.append(d.getPhone()+" ");
							ta.append(d.getAddress()+" "+"\n");
						}
						tf.setText("");//글자 지우기
						tf2.setText("");
						tf3.setText("");
					} catch (Exception e1) {
					}
				}
			}); //업데이트 기능  
			
			Search.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = tf.getText(); //문자 열을 읽어옴
					try {
						ta.setText(null);
						
						for(Directory d : list) {
							
							if(d.getName().equals(str))
							{
								ta.append(d.getName()+" ");
								ta.append(d.getPhone()+" ");
								ta.append(d.getAddress()+" "+"\n");
							}
						}
						tf.setText("");//글자 지우기
					} catch (Exception e1) {
					}
				}
			}); //Search 기능 
			
			
			Upload.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						for(Directory d : list) {
							String s1 = d.getName();
							String st2 = d.getPhone();
							String st3 = d.getAddress();
							dos.writeUTF(s1+" "+st2+" "+st3+" "+"\n");
						}
						tf.setText("");//글자 지우기
						tf2.setText("");
						tf3.setText("");
					} catch (Exception e1) {
					}
				}
			}); //Upload  기능 
			
			
				Clear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						
						tf.setText("");
						tf2.setText("");
						tf3.setText("");
						ta.setText(null);
						
						for(Directory d: list)
						{
							ta.append(d.getName()+" ");
							ta.append(d.getPhone()+" ");
							ta.append(d.getAddress()+" "+"\n");
						}
						
					} catch (Exception e1) {
					}
				}
			}); //Clear  기능 
			
			Exit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				
					try {
					FileOutputStream  fos = new FileOutputStream("directory.dat");
					
					ObjectOutputStream oos = new ObjectOutputStream(fos);

					for(Directory d : list)
					{
						oos.writeObject(d);
					}

					oos.close();
					fos.close();
					f.dispose();
					}
					catch (Exception ez)
					{
						
					}
				
				}
				}); //Exit버튼 누를 때 종료
			
		
			f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}}); //X버튼 누를 때 창 꺼짐.
			
			f.setVisible(true);	
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void close() throws Exception {
		
	}
}//end of class
