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

// 단계1: 메서드 도입 전
public class Test27_01 {
	// 3) switch 문을 사용하여 계산 결과를 result 변수에 담는다.
	//    그리고 그 결과를 입력 값과 함께 출력한다.
	public static void main(String[] args) {

		java.util.Scanner scanner = new java.util.Scanner(System.in);

		System.out.print("값1? ");
		int v1 = Integer.parseInt(scanner.nextLine());

		System.out.print("값2? ");
		int v2 = Integer.parseInt(scanner.nextLine());

		System.out.print("연산자? ");
		String op = scanner.nextLine();

		int result = 0;
		switch (op) {
		case "+": result = v1 + v2; break;
		case "-": result = v1 - v2; break;
		case "*": result = v1 * v2; break;
		case "/": result = v1 / v2;
		}

		System.out.println(v1 + op + v2 + "=" + result);


		/*
		// 2) java.util.Scanner 객체를 사용하여 사용자로부터 값을 입력받는다!
		public static void main(String[] args) {

			java.util.Scanner scanner = new java.util.Scanner(System.in);

			System.out.print("값1? ");
			int v1 = Integer.parseInt(scanner.nextLine());

			System.out.print("값2? ");
			int v2 = Integer.parseInt(scanner.nextLine());

			System.out.print("연산자? ");
			String op = scanner.nextLine();

			System.out.println(v1+op+v2+"="+(v1+v2)+"입니다. ");
		 */

		/*
		// 1) 단순한 출력문을 작성하라!
		public static void main(String[] args) {
			System.out.println("값1? 10");
			System.out.println("값2? 20");
			System.out.println("연산자? +");
			System.out.println("10 + 20 = 30 입니다. ");
		 */
	}

}
