package Swing;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;

public class SwingTest {
	
	//JTextArea, JList, JTable는 JScrollPane에 올려야 함. 
	
	//field
	JFrame f; //창 구성 -> MenuBar+ContentPane(이곳에 내용 붙여야 함)
	JButton ok, cancel; 
	JLabel la; //글자
	JTextArea ta;
	JTextField tf;
	JList list; //리스트
	
	
	
	public SwingTest() {
		//화면 만들기 작업
		f = new JFrame("swing Test");
		f.setLayout(new FlowLayout()); //layout manager지정
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창 닫기시 프로그램 종료		
		ok = new JButton("ok");
		cancel = new JButton("cancel");
		
		ta = new JTextArea(5,30);
		JScrollPane pane = new JScrollPane(ta); //Scroll 만듦.
		
		tf = new JTextField(30);
		String[] season = {"Spring","Summer","Fall", "Winter"};
		list = new JList<>(season);
		JScrollPane pane2 = new JScrollPane(list);
		
		Container c = f.getContentPane();
		c.add(ok);
		c.add(cancel);
		c.add(pane);
		c.add(tf);
		c.add(pane2);
		
		f.setSize(500, 500);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new SwingTest();
		
	}//end of main
}//end of class
