//역할 : 계산기 역할을 수행한다.

package java01.test30;

public class Calculator {
	// 인스턴스 변수 만들기 => static 제거!
	// => 인스턴스 변수는 클래스 로딩할 때 준비되지 않는다.
	// => 별도의 명령을 내려야만 준비한다.
	// => 명령 내리는 법? new Calculator();
	//    해석: JVM 듣거라. Calculator 클래스에 선언된 인스턴스 변수를
	//         Heap메모리에 준비하라! 그리고 그 시작 주소를 리턴하라!
	private int result;

	// 인스턴스 변수를 사용하려면 그 인스턴스에 시작 주소를 알아야 한다.
	// 따라서, 메서드의 파라미터에 인스턴스 주소를 넘겨줘라!
	static int getResult(Calculator that) {
		return that.result;
	}
	
	static void plus(Calculator that, int value) {
		that.result += value;
	}
	
	static void minus(Calculator that,int value) {
		that.result -= value;
	}
	
	static void multiple(Calculator that, int value) {
		that.result *= value;
	}
	
	static void divide(Calculator that, int value) {
		that.result /= value;
	}
	
	
}

