package headFirstJava.p515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DailyAdviceClient {
	
	public void go() {
		// 잘못될 수 있는 부분이 많기 때문에 try/catch를 써야 한다.
		try {
			// 이 코드가 실행되는 것과 같은 호스트("localhost")의 4242번 포트에서
			// 실행중인 애플리케이션에 대한 Socket 연결을 만든다.
			Socket s = new Socket("127.0.0.1", 4242);	
			
			InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
			BufferedReader reader = new BufferedReader(streamReader);
			
			String advice = reader.readLine();
			System.out.println("Today you should: " + advice);
			
			reader.close();  // 이렇게 하면 모든 스트림이 닫힙니다.
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DailyAdviceClient client = new DailyAdviceClient();
		client.go();

	}

}
