package com.workshop;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class WeatherMain {
	JFrame f;
	JButton b ;
	JList li ;
	WeatherDAO dao;

	public WeatherMain() {
		try {
			dao = new WeatherDAO();
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
			List<Weather> data = dao.getNewsData();
			li.setListData(data.toArray()); //받아온 ArrayList 화면으로 뿌리기
		}
		catch(Exception e) {
			
		}
		
	}
	private void createGUI() {
		f = new JFrame("Weather Info");
		b = new JButton("call News");
		
		li = new JList();
		JScrollPane pane = new JScrollPane(li);
		Container c = f.getContentPane();
		c.add(b, "North");
		c.add(pane, "Center");
		
		f.setSize(600, 600);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new WeatherMain();
	}


}
