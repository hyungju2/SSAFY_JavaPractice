package com.homework;

import java.awt.Container;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class NewsMain extends MouseAdapter implements ActionListener  {
	JFrame f;
	JButton b ;
	JList li ;
	TextArea li2;
	List<News> data;
	
	
	NewsDAODOMImpl dao;
	String url = "http://rss.etnews.com/Section902.xml";
	
	public NewsMain() {
		try {
			dao = new NewsDAODOMImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
		createGUI();
		addEvent();
	}

	private void addEvent() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showList();
			}
		});
	}
	protected void showList() {
		try{
			data = dao.getNewsList(url);
			li.setListData(data.toArray()); //받아온 ArrayList 화면으로 뿌리기
		}
		catch(Exception e) {
		}
		
	}
	private void createGUI() {
		f = new JFrame("News Info");
		b = new JButton("call News");
		
		li = new JList();
		li.addMouseListener(this);
		
		li2 = new TextArea();
		li2.setEditable(false);
		JScrollPane pane = new JScrollPane(li);
		JScrollPane pane2 = new JScrollPane(li2);
		Container c = f.getContentPane();
		
		c.add(b, "North");
		c.add(pane, "Center");
		c.add(pane2, "South");
		
		f.setSize(600, 600);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new NewsMain();
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		li2.setText(null);
		int index = li.getSelectedIndex();
		li2.append(dao.search(index).getDesc()+"\n");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
