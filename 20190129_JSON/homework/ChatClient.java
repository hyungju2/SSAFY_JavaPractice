package homework;

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

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



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
	  static Label ta2 = new Label();
	  static TextField tf = new TextField(10); //한 줄의 글자를 입력 출력하는 컴포넌트.
	  static TextField tf2 = new TextField(10);
	  static TextField tf3 = new TextField(10);
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
			
			JLabel lab = new JLabel();
			JLabel name = new JLabel();
			JLabel phone = new JLabel();
			JLabel Address = new JLabel();
			JLabel Errors = new JLabel();
			
			lab.setText("Phone Book");
			name.setText("Name");
			phone.setText("Phone");
			Address.setText("Address");
			Errors.setText("null");
			JPanel p = new JPanel(); //Title		
			JPanel p2 = new JPanel(); // Text Area
			JPanel p3 = new JPanel(); //Button+ TextField+ Button
			JPanel p4 = new JPanel(); // Button
			JPanel p5 = new JPanel(); //name+phone+address = TextField
			JPanel p9 = new JPanel(); // Upload Button
			JPanel p6 = new JPanel(); // name
			JPanel p7 = new JPanel(); // Phone
			JPanel p8 = new JPanel(); // Address
			JPanel p10 = new JPanel();
			JPanel p11 = new JPanel();
			JButton Insert = new JButton("INSERT");
			JButton Delete = new JButton("DELETE");
			JButton Update = new JButton("UPDATE");
			JButton Search = new JButton("SEARCH");
			JButton Upload = new JButton("UPLOAD");
			JButton Clear = new JButton("CLEAR");
			JButton Exit = new JButton("EXIT");
			
			p.add(lab,BorderLayout.NORTH); //라벨 추가
			p2.add(ta,BorderLayout.CENTER); // Text Area 추
			p2.add(ta2,BorderLayout.SOUTH);
			p11.add(Errors);
			p3.add(p,BorderLayout.NORTH);
			p3.add(p2,BorderLayout.CENTER);
			
			
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
			p10.add(Errors);
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
					String []namefield = new String[50];
					int index = 0;
					boolean flag = true;
					
					for(Directory d: list)
					{
						namefield[index] = d.getName();
						index++;
					}
					try {
							for(int i=0; i<index; i++)
							{
								if(namefield[i].equals(str))
								{
									Errors.setText("Exist");
									flag = false;
								}
							}
							
							 if(str.equals(""))
							{
								Errors.setText("Empty");
							}
							if(flag)
							{
								ta.append(str+" ");
								ta.append(str2+" ");
								ta.append(str3+" "+"\n");
								ChatClient.add(new Directory(str,str2,str3));
							}
						tf.setText("");//글자 지우기
						tf2.setText("");
						tf3.setText("");
					} catch (Exception e1) {
						Errors.setText(e1.getMessage());
					}
				}
			}); //추가기능.
			
			Delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = tf.getText(); //문자 열을 읽어옴
					int i=0;
					int empty = i;
					try {
						Errors.setText("Delete");
						for(Directory d : list) {
							if(d.getName().equals(str))
							{
							 list.remove(i);
							 i--;
							}
							i++;
						}
						if(i!=empty)
						{
							Errors.setText("Error");
						}
						
						ta.setText(null);
						for(Directory d: list)
						{
							ta.append(d.getName()+" ");
							ta.append(d.getPhone()+" ");
							ta.append(d.getAddress()+" "+"\n");
						}
					} catch (Exception e1) {
						Errors.setText(e1.getMessage());
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
						Errors.setText(e1.getMessage());
					}
					Errors.setText("Update");
				}
			}); //업데이트 기능  
			
			Search.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = tf.getText(); //문자 열을 읽어옴
					int count = 0;
					try {
						ta.setText(null);
						for(Directory d : list) {
							
							if(d.getName().equals(str))
							{
								ta.append(d.getName()+" ");
								ta.append(d.getPhone()+" ");
								ta.append(d.getAddress()+" "+"\n");
								count++;
							}
						}
						if(count==0)
							Errors.setText("Not Search!!");
						else
							Errors.setText("Succes");
						tf.setText("");//글자 지우기
					} catch (Exception e1) {
						Errors.setText(e1.getMessage());
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
						Errors.setText(e1.getMessage());
					}
					Errors.setText("Upload");
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
						Errors.setText(e1.getMessage());
					}
					Errors.setText("Clear");
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
