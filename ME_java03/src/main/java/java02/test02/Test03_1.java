/* Quiz_ 예외 처리 강화
   - 파일을 읽을 때
     1) 파일이 존재하지 않으면, 다음 문장 출력 xxxx.xxx 파일이 존재하지 않습니다.
     2) 디렉토리라면 xxxx.xxx 는 파일이 아니라 디렉토리입니다.

   - 파일을 쓸때
     1) 파일이 이미 존재한다면, xxxx.xxx 파일이 이미 존재합니다. 덮어쓰시겠습니까? (y/n) y
        xxxx.xxx 파일을 출력하였습니다.
     2) 파일이 존재하지 않는다면, xxxx.xxx 파일을 출력하였습니다.
 */
package java02.test02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test03_1 {

	public static void main(String[] args) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null; 
		File f1 = new File(args[0]);
		
		try {
			boolean is_exist = f1.exists();
			/*if (is_exist == false)
			else
				System.out.println(f1 + " 파일이 이미 존재합니다.");*/
			boolean is_dir = f1.isDirectory();
			/*if (is_dir == true)
				System.out.println(f1 + "는 파일이 아니라 디렉토리입니다.");*/
			out = new FileOutputStream(f1, false);

			/*BufferedWriter file = new BufferedWriter(new FileWriter(f1)); */
			//파일이 없으면 새로 생성
			//false일 경우 덮어쓰기
			//true일 경우 이어쓰기
			

		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
			System.out.println(f1 + " 파일이 존재하지 않습니다.");
			System.out.println(f1 + " 파일을 출력하였습니다.");
			

		} catch (IOException ex) {
			System.out.println("읽기 오류!");

		} finally{
			try {out.close();} catch (IOException ex) {}
			/*try {in.close();} catch (IOException ex) {}*/
		}
	}

}
