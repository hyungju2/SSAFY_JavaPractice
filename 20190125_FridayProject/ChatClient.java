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
import java.util.Scanner;

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
	  static Frame f = new Frame("kakaotalk");
	  static TextArea ta = new TextArea(); //여러줄의 글자를 입력, 출력하는 컴포넌트.
	  static TextField tf = new TextField(); //한 줄의 글자를 입력 출력하는 컴포넌트.
	  static String ip;
	  static int port;
	  static String name;
	  static ChatConnect cc;

	  
	  
	  public ChatClient(String ip, int port, String name)
	  {
		  	this.name = name;
			cc = new ChatConnect(ip,port,name,this);
	  }
	  
	  
	  public static void main(String[] args) {
		  Scanner sc = new Scanner(System.in);
		  System.out.println("사용자 이메일 입력");
		
		  String name = sc.nextLine();
		 
		  ChatClient client = new ChatClient("127.0.0.1", 6571, name);
		  createGUI();
		  ta.append("서버 접속 대기중\n");
		  ta.append("서버 연결 성공!\n");
		  ta.append("스트림 생성 성공!\n");
		  client.cc.go();
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
		ta.append(str+"\n");
		tf.setText("");
	}
	
	public static void createGUI() {
		
			f.setBounds(600,100,300,400); //크기 지정
			f.setLayout(new BorderLayout());//안해도 됨. 원래 프레임의 기본 매니저는 BorderLayout

			f.add(ta, BorderLayout.CENTER);
			f.add(tf, BorderLayout.SOUTH); 
			
			Panel p = new Panel(); //동쪽 영역에 들어갈 묶음.
			p.setLayout(new BorderLayout());
			
			Button bSend = new Button("Send");
			Button bExit = new Button("Exit");
			p.add(bSend, BorderLayout.NORTH);
			p.add(bExit);
			
			
			f.add(p, BorderLayout.EAST);
			ta.setEditable(false);
			//이벤트 처리
			//Send 버튼 누르면, TextField의 값을 읽어서 서버에 전송. (TextArea에 값을 작성)
			//TextField의 값을 지워라. 공백으로 초기화.
			
			//Exit 버튼 클릭시 : 창을 닫기. Frame의 닫기 버튼.
			//TextField 엔터키 입력 : Send와 동일한 기능. 
		
			bSend.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = tf.getText(); //문자 열을 읽어옴
					try {
						cc.send(name+":"+str);
						//ta.append("\n"+name+":" +str); //문자 추가됨
						tf.setText("");//글자 지우기
					} catch (Exception e1) {
					}
				}
			});
			
			bExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					f.dispose();
				}
			}); //Exit버튼 누를 때 종료
			
			tf.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {//텍스트에 엔터키 입력시 호출되는 콜백 메서드
						String str = tf.getText(); //문자 열을 읽어옴
						try {
							cc.send(name+":"+str);
							//ta.append("\n"+name+":" +str); //문자 추가됨
							tf.setText("");//글자 지우기
						} catch (Exception e1) {
						}
				}
			});
			f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}}); //X버튼 누를 때 창 꺼짐.
			
			f.setVisible(true);	
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}//end of class
