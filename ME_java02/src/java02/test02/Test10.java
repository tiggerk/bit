/* 문자 데이터의 출력
 */
package java02.test02;

import java.io.FileWriter;

public class Test10 {

	public static void main(String[] args) throws Exception {
		FileWriter out = new FileWriter("test10.dat");
		char[] str = {'A', 'B', 'C', '가', '각', '간'};
		String s = new String(","); 
		for (char c : str) {
			out.write(c);
		}
		out.close();
	}
}
