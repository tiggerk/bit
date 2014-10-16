// 역할 : 계산기 역할을 수행한다.

package java01.test29;

public class Calculator {
	// 클래스 멤버만 접근 가능하도록 제한한다.
	private static int result;

	// 단, 결과를 알 수 있도록 메서드 제공
	// 내부 변수의 값을 리턴하는 매서드는 get이란 접두어를 붙인다.
	// => getter(게터) 메서드 (get이라는 접두어가 붙은 메서드)
	static int getResult() {
		return result;
	}
	
	static void plus(int value) {
		result += value;
	}
	
	static void minus(int value) {
		result -= value;
	}
	
	static void multiple(int value) {
		result *= value;
	}
	
	static void divide(int value) {
		result /= value;
	}
	
	
}