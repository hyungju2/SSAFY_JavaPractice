package Swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

//1. 클래스 선언시에 listener implements표시
//ActionListner : 버튼 클릭 감지
public class SwingTest2 extends MouseAdapter implements ActionListener{ 
	
	//JTextArea, JList, JTable는 JScrollPane에 올려야 함. 
	//field
	JFrame f; //창 구성 -> MenuBar+ContentPane(이곳에 내용 붙여야 함)
	JButton ok, cancel; 
	JLabel la; //글자
	JTextArea ta;
	JTextField tf;
	JList list; //리스트
	
	public SwingTest2() {
		//화면 만들기 작업
		f = new JFrame("swing Test2");
		f.setLayout(new BorderLayout()); //layout manager지정
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창 닫기시 프로그램 종료		
		ok = new JButton("ok");
		la = new JLabel("실험", JLabel.CENTER); //화면에서 글자 표시
		Font font = new Font("맑은  고딕",Font.BOLD,50);
		la.setFont(font);
		la.setForeground(Color.gray);
		cancel = new JButton("cancel");
		
		//2. ActionListener 사건 발생 대상에 Listener 등록.
		ok.addActionListener(this); //ActionPerformed를 갖고 있는 곳을 넣어야 함.
		cancel.addActionListener(this);
		
		ta = new JTextArea(5,30);
		JScrollPane pane = new JScrollPane(ta); //Scroll 만듦.
		
		tf = new JTextField(30);
		String[] season = {"Spring","Summer","Fall", "Winter"};
		list = new JList<>(season);
		JScrollPane pane2 = new JScrollPane(list);
		list.addMouseListener(this);
		
		JPanel panel = new JPanel(new FlowLayout()); //JFrame 보다 작은 컨테이너(내부에 다른 화면 구성요소를 담을 수 있음)
		panel.add(ok,BorderLayout.NORTH);
		panel.add(cancel,BorderLayout.SOUTH);
		
		Container c = f.getContentPane();
		
		c.add(la, "North");
		c.add(pane,"Center");
		c.add(pane2, "East");
		c.add(panel,"South");
		
		f.setSize(500, 500);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new SwingTest2();
		
	}//end of main

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource(); //Source:사건이 발생한 대상.
		if(o==ok)
		{
			System.out.println("ok press");
		}
		else
		System.out.println("cancel "
				+ "me!");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		int index = list.getSelectedIndex();
		System.out.println(index);
		}

}//end of class
