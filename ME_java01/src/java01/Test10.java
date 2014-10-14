/* 2진수, 8진수, 10진수, 16진수 표현
   2진수 : 표현 불가!
   8진수 : 0으로 시작
   10진수 : ..알고 있잔항!!
   16진수 : 0X 또는 0x로 시작!
 */


package java01;

public class Test10 {

	public static void main(String[] args) {
		int i = 13;
		int i2 = 015;
		int i3 = 0xd; // 두 번째로 많이 사용.
		int i4 = 0Xd;
		int i5 = 0xD; //가장 많이 사용.
		int i6 = 0XD;
		
		System.out.println(i);
		System.out.println(i2);
		System.out.println(i3);
		System.out.println(i4);
		System.out.println(i5);
		System.out.println(i6);
		
	}

}
