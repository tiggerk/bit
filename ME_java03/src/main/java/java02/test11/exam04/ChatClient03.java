package java02.test11.exam04;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatClient03 extends Frame {
	TextField tfServerAddr = new TextField(20);
	TextField tfName = new TextField(10);
	Button btnConnectBtn = new Button("연결");
	TextArea taContent = new TextArea();
	TextField tfInput = new TextField(30);
	Button btnSend = new Button("보내기");
	
	String username;
	String serverAddress;
	
	public ChatClient03() {
		// 윈도우 준비!!
		Panel toolbar = new Panel(new FlowLayout(FlowLayout.LEFT));
		toolbar.add(new Label("이름 : "));
		toolbar.add(tfName);
		toolbar.add(new Label("서버 : "));
		toolbar.add(tfServerAddr);
		toolbar.add(btnConnectBtn);
		
		this.add(toolbar, BorderLayout.NORTH);
		
		this.add(taContent, BorderLayout.CENTER);
		
		Panel bottom = new Panel(new FlowLayout(FlowLayout.LEFT));
		bottom.add(tfInput);
		bottom.add(btnSend);
		
		this.add(bottom, BorderLayout.SOUTH);

		// 리스너 등록!!
		// 1) 윈도우 이벤트를 처리할 리스너 객체 등록
		// WindowListener 인터페이스를 구현한 객체여야 한다.
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
		// ActionEvent는 버튼을 눌렀을 때 발생하는 이벤트이다.
		//connectBtn.addActionListener(new MyConnectListener());
		
		// 실무에서는 한번 밖에 안 쓸 객체라면 익명 이너 클래스로 정의한다. 
		btnConnectBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// 바깥 클래스의 인스턴스 변수를 사용할 때는
				// 정확하게 바깥 클래스의 this를 지정하거나 아니면 차라리 생략하라!
				// 단, 로컬 변수나 이너 클래스에 같은 이름을 가진 변수가 있다면 생략 불가하다.
				ChatClient03.this.username = tfName.getText();
				//ChatClient.this.  <== 생략 가능.
				serverAddress = tfServerAddr.getText();
				System.out.println("사용자 이름: " + username);
				System.out.println("서버 주소: " + serverAddress);
			}
		});
		
		// 보내기는 버튼을 눌렀을 때 발생하는 이벤트이다.
		//sendBtn.addActionListener(new MyConnectListener());
		
		btnSend.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("보내기 버튼 눌렀네..");
			}
		});
	}
	
	public static void main(String[] args) {
		ChatClient03 wnd = new ChatClient03();
		wnd.setSize(400, 600);
		wnd.setVisible(true);
	}
	
}
