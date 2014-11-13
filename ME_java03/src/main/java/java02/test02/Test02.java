/* Quiz
   - 파일을 복제하는 기능을 구현하시오.
   - $ Test02 /home/bit/javaide/workspace/ME_java02/img1.jpg (엔터)
     => img1.jpg 파일을 복제하여 img1-01.jpg 를 만드세용

   - 힌트: 출력은 FileOutputStream 클래스를 사용하라! 
 */
package java02.test02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test02 {

	public static void main(String[] args) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null; 

		try {
			in = new FileInputStream(args[0]);

			// args[0]가 img1.jpg라면 => img1-01.jpg
			// 확장자 앞의 문자열을 자른다 => x
			// x + "-01" + 확장자 뒤의 문자열을 붙인다.

			/*
			String arr[] = args[0].split("\\.");  // aaa.bbb.ccc.jpg 일 경우 앞부분은 자르지 못함.

			String newFileName = arr[arr.length-2] +"(사본)."+ arr[arr.length-1];
			 */
			
			int index = args[0].lastIndexOf('.');
			String newFileName = args[0].substring(0, index) + "(사본)" + args[0].substring(index);
			out = new FileOutputStream(newFileName);

			int b = 1;

			while((b = in.read()) != -1) {
				out.write(b);


			}

		} catch(FileNotFoundException ex) {
			System.out.println("img1.jpg 파일을 찾을 수 없당");

		} catch (IOException ex){
			System.out.println("읽기 오류!");

		} finally {
			try {in.close();} catch (IOException ex) {}
			try {out.close();} catch (IOException ex) {}
		}
	}

}
