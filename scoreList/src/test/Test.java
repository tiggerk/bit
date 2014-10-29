
package test;

import java.io.FileOutputStream;

public class Test {

	public static void main(String[] args) throws Exception {
		FileOutputStream out = new FileOutputStream("score.dat");
		char[] str = {'A', 'B', 'C', '가', '각', '간'};
		for (char c : str) {
			out.write(c);			
		}
		out.close();
	}
}
