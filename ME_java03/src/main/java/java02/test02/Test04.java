/* Quiz_ 예외 처리 강화
   - Test04 읽어들일파일명 출력할디렉토리명
   - 출력할 파일명이 다음과 같을 경우
     예) Test04 img1.jpg aaa
   - aaa 폴더를 먼저 생성하고 그 폴더 아래에 읽어들인 파일(img1.jpg)를 출력한다.
 */
package java02.test02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test04 {

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
