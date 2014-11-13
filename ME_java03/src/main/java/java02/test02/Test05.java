/* File 기본 사용법!
 */

package java02.test02;

import java.io.File;

public class Test05 {

	public static void main(String[] args) throws Exception {
		File f = new File("../../bit/ME_java01");

		// 결과: /home/bit/git/bit/ME_java02/../../bit/ME_java01
		System.out.println(f.getAbsolutePath());
		 
		// 결과: /home/bit/git/bit/ME_java01
		System.out.println(f.getCanonicalPath());
		
		// 결과: ../../bit/ME_java01
		System.out.println(f.getPath());
		
		// 결과: ME_java01
		System.out.println(f.getName());
		
		// 결과: ../../bit
		System.out.println(f.getParent());
		

	}

}
