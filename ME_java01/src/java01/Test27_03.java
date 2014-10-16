/* 메서드(함수)
   - 특정 기능을 수행하는 명령어를 묶어 놓은 것.
   - 파라미터 : 기능을 수행하는데 필요한 정보를 전달
   - 리턴 값 : 기능을 수행한 후 결과를 전달
   - 문법
     공개범위 스태틱여부 리턴타입 메서드명(타입 변수명, 타입 변수명, ...) {
     	return 값;
     }
     예)
     int plus(int i, int b) {
     	return i + b;
     }
 */

package java01;

// 주제 : 사용자로부터 두 개의 값과 연산자를 입력 받아 계산한 후
//       그 결과를 출력한다.
// 실행 예:
// $ 값1? 10
// $ 값2? 20
// $ 연산자? +
// $ 10 + 20 = 30 입니다.

// 단계3: 메서드 도입 => 값을 계산하는 명령어를 별도의 메서드로 분리하라!
// 메서드명: compute
// 파라미터는: v1, v2, op
// 리턴: v1과 v2의 연산결과

public class Test27_03 {
	// void : 리턴하는 결과가 없다는 의미.
	static void displayResult(int v1, int v2, String op, int result) {
		System.out.println("**********************");
		System.out.printf("%d %s %d = %d\n", v1, op ,v2, result);
		System.out.println("**********************");
	}

	static int compute(int v1, int v2, String op) {
		int result = 0;
		switch (op) {
		case "+": result = v1 + v2; break;
		case "-": result = v1 - v2; break;
		case "*": result = v1 * v2; break;
		case "/": result = v1 / v2;
		}
		return result;
	}

	public static void main(String[] args) {

		java.util.Scanner scanner = new java.util.Scanner(System.in);

		System.out.print("값1? ");
		int v1 = Integer.parseInt(scanner.nextLine());

		System.out.print("값2? ");
		int v2 = Integer.parseInt(scanner.nextLine());

		System.out.print("연산자? ");
		String op = scanner.nextLine();

		int result = compute(v1, v2, op);

		// 메서드 호출 : 반드시 호출할 때 정확하게 파라미터를 넘겨야 한다.
		displayResult(v1, v2, op, result);

	}

}
