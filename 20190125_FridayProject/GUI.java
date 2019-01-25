package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GUI {
	
	public static void main(String[] args) {
		Frame f = new Frame("안녕 나는 창이에요"); //윈도우 창 생성 - 독립적인 컨테이너(컴포넌트): 레이아웃 매니저
		f.setBounds(300,200,500,600); //크기 x,y, 위치 x,y
		//	f.setSize(300, 200); //창 크기지정
		//	f.setLocation(500,0); //창의 위치지정
		f.setLayout(new FlowLayout());//레이아웃 매니저
//		null 레이아웃 매니저를 안씀.
//		new FlowLayout(); //위쪽줄부터 좌->우로 배치 후 우측 끝에 자리가 부족하면 아랫줄로
//		new BorderLayout(); //동서남북 센터로 배치
//		new CardLayout(); //0.0위치를 기준으로 한자리에 덮어씀
		
		Button b = new Button("메세지 전송"); //한글파일 깨질 때 -Dfile.encoding=MS949 추가
		b.setSize(500, 500);
		b.setLocation(50,  50);// 레이아웃 매니저를 사용하면 의미가 없음.
		
		f.add(b, BorderLayout.CENTER);
		f.add(new Button("버튼1입니다"), BorderLayout.NORTH);
		f.add(new Button("버튼2입니다"), BorderLayout.SOUTH);
		f.add(new Button("버튼3입니다"), BorderLayout.WEST);
		f.add(new Button("버튼4입니다"), BorderLayout.EAST);
		
		Panel p = new Panel(); //여러개의 레이아웃 매니저로 혼합해서 사용할 때 필요함.
		p.setLayout(new FlowLayout());
		
		p.add(new Button("Exit"), BorderLayout.NORTH);
		p.add(new Button("Send"), BorderLayout.CENTER);
		
		
		f.add(p, BorderLayout.EAST);
		
		
		//이벤트 처리
		//소스, 닫기, 처리 할 함수
		
		//버튼 누르면 찍힘. 
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = b.getLabel();
				System.out.println(str);
				b.setLabel("123");
			}
		});
		
		
		f.addWindowListener(new WindowAdapter() { //필요한 메서드만 오버라이딩 할 수 있도록
			public void windowClosing(WindowEvent e) {//닫기 버튼을 눌렀을대
				f.dispose();
			}
		});
		
		
		f.addWindowListener(new WindowListener() {
			public void windowOpened(WindowEvent e) { //창이 열렸을 때 호출
				// TODO Auto-generated method stub
				
			}
			public void windowIconified(WindowEvent e) {//최소화 되었을 때
				// TODO Auto-generated method stub
				
			}
			public void windowDeiconified(WindowEvent e) {//최소화 되었던 것이 원래 화면으로 뜰 떄
				// TODO Auto-generated method stub
				
			}
			public void windowDeactivated(WindowEvent e) {//비활성화 되었을 때
				// TODO Auto-generated method stub
				
			}
			public void windowClosing(WindowEvent e) {//닫기 버튼을 눌렀을 때
				//f.setVisible(false); //화면에만 안 보임 메모리엔 존재.
				f.dispose(); //창의 객체를 메모리에서 제거.
				//System.exit(0); //완전히 프로그램을 종료.
				
			}
			public void windowClosed(WindowEvent e) {//닫은 뒤에
				// TODO Auto-generated method stub
				
			}
			public void windowActivated(WindowEvent e) {//활성화 되었을 때
				// TODO Auto-generated method stub
				
			}
		});
		
		
		f.setVisible(true);//화면에 보이기
	}//end of main
}//end of class
