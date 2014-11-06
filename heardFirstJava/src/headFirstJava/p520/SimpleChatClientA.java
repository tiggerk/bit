package headFirstJava.p520;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleChatClientA {
	
	JTextField outgoing;
	PrintWriter writer;
	Socket sock;
	
	public void go() {
		// GUI를 만들고 send 버튼에 대한 리스너를 등록합니다.
		// setUpNetWorking() 메소드를 호출합니다.
		JFrame frame = new JFrame("Ludicrously Simple Chat Client");
		JPanel mainPanel = new JPanel();
		outgoing = new JTextField(20);
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new SendButtonListener());
		mainPanel.add(outgoing);
		mainPanel.add(sendButton);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		setUpNetworking();
		frame.setSize(400, 500);
		frame.setVisible(true);
	}  // go 메소드 
	
	public void setUpNetworking() {
		// Socket을 만들고 PrintWriter를 만듭니다.
		// 그 PrintWriter를 writer 인스턴스 변수에 대입합니다.
		try {
			sock = new Socket("127.0.0.1", 5000);
			writer = new PrintWriter(sock.getOutputStream());
			System.out.println("networking established");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}  // setUpNetworking 끝
	
	public class SendButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			// 텍스트 필드로부터 텍스트를 알아낸 다음
			// writer(PrintWriter 객체)를 써서 서버로 보냅니다.
			try {
				writer.println(outgoing.getText());
				writer.flush();
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			outgoing.setText("");
			outgoing.requestFocus();
		}
	}   // SendButtonListener 내부 클래스 끝

	public static void main (String[] args) {
		new SimpleChatClientA().go();
	}
}   // 외부 클래스 끝
