/* 재귀 호출의 이해
 */

package java02.test02;

public class Test06_Ep02 {
	// Quiz: 1부터 50까지 더하라!
	
	// 함수 호출 사용
	public static void main(String[] args) {
		System.out.println(f(50));
	}
	
	public static int f(int no) {
		if (no == 1)
			return no;
		else
			return no + f(no - 1);
	}
	
	
	// 반복문 사용.
	public static void main01(String[] args) {
		for(int i = 0; i <= 50; i++) {
			System.out.println(i);
		}
			

	}

}
