// 역할 : 계산기 역할을 수행한다.

package java01.test28;

public class Calculator {
	static int result;
	
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
