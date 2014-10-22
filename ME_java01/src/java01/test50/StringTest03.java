/* String 클래스의 유용한 메서드
 * replace():
 *  1) 원본 데이터를 변경하지 못한다. => String은 immutable 객체다.
 *  2) 특정 문자열을 대체하여 새 스트링 객체를 힙에 생성한다.
 *  
 * intern():
 *  1) 현재 스트링 객체의 내용을 복제하여 String Pool에 만든다.
 *  2) 상수 문자열을 만든다. 
 */

package java01.test50;

public class StringTest03 {
	public static void main(String[] args) {
		String str1 = new String("Hello");
		String str2 = str1.intern();
		String str3 = "Hello";
		
		if (str1 == str2) System.out.println("str1 == str2");
		if (str2 == str3) System.out.println("str2 == str3");
	}
	
	public static void main01(String[] args) {
		String str1 = "Hello";
		String str2 = str1.replace('l', 'x');
		String str3 = str1.replace("ell", "ohoho");
		String str4 = str1.replace('l', 'x');
		
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);
		
		if (str2 == str4) System.out.println("str2 == str4");
	}

}

