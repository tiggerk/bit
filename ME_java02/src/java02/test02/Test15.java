/* Deserialize => 바이트 배열을 인스턴스로 복원하는 것.
 */
package java02.test02;

import java.io.FileInputStream;

public class Test15 {
	/* Test14.java 소스에서 생성한 Score 클래스 사용 */	

	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("test12.dat");
		//DataInputStream in2 = new DataInputStream(in);

		class Score {
			String name;
			int kor;
			int eng;
			int math;
			int sum;
			float average;

			public Score() {}

			public Score(String n, int k, int e, int m) {
				name = n;
				kor = k;
				eng = e;
				math = m;
				sum = k + e + m;
				average = sum / 3.0f;
			}
		}

		Score obj = new Score();

		int length = (in.read() << 8) | in.read();

		byte[] buf = new byte[length];

		for (int i = 0; i < length; i++) {
			buf[i] = (byte)in.read();
		}

		obj.name = new String(buf, "UTF-8");
		obj.kor = (in.read() << 24) | (in.read() << 16) | (in.read() << 8) | in.read();
		obj.eng = (in.read() << 24) | (in.read() << 16) | (in.read() << 8) | in.read();
		obj.math = (in.read() << 24) | (in.read() << 16) | (in.read() << 8) | in.read();
		obj.sum = (in.read() << 24) | (in.read() << 16) | (in.read() << 8) | in.read();
		obj.average = (in.read() << 24) | (in.read() << 16) | (in.read() << 8) | in.read();
		// obj.name = in2.readUTF();


		System.out.println(obj.name);
		System.out.println(obj.kor);
		System.out.println(obj.eng);
		System.out.println(obj.math);
		System.out.println(obj.sum);
		System.out.println(obj.average);


		// 닫을 때 거꾸로 닫는다.
		//in2.close();
		in.close();
	}
}

