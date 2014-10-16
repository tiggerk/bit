/* 클래스 변수
   - 클래스를 로딩할 때 준비되는 변수
   - (중요)Method Area 영역에 준비됨!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
   - JVM이 실행을 종료할 때까지 유지
   
 * 로컬변수
   - 함수가 호출될 때 준비되는 변수
   - Stack 영역에 준비됨.
   - 함수 호출이 끝나면 제거된다.

 * 인스턴스 변수
   - 인스턴스가 생성될 때 준비되는 변수
   - Heap 영역에 준비됨.
   - 가비지 컬렉터에 의해 해제되기 전까지 존재한다.
   
 */

package java01;

// 주제 : 사용자로부터 두 개의 값과 연산자를 입력 받아 계산한 후
//       그 결과를 출력한다.
// 실행 예:
// $ 값1? 10
// $ 값2? 20
// $ 연산자? +
// $ 10 + 20 = 30 입니다.

// 단계4: 클래스 변수 도입
//     => compute()와 displayResult()에서 공유할 값을 보관

public class Test27 {
	// 클래스 변수 선언
	static int v1;
	static int v2;
	static String op;
	static int result;
	
	
	static void displayResult() {
		System.out.println("**********************");
		System.out.printf("%d %s %d = %d\n", v1, op ,v2, result);
		System.out.println("**********************");
	}

	static void compute() {
		switch (op) {
		case "+": result = v1 + v2; break;
		case "-": result = v1 - v2; break;
		case "*": result = v1 * v2; break;
		case "/": result = v1 / v2;
		}
	}

	public static void main(String[] args) {

		java.util.Scanner scanner = new java.util.Scanner(System.in);

		System.out.print("값1? ");
		v1 = Integer.parseInt(scanner.nextLine());

		System.out.print("값2? ");
		v2 = Integer.parseInt(scanner.nextLine());

		System.out.print("연산자? ");
		op = scanner.nextLine();

		compute();

		// 메서드 호출 : 반드시 호출할 때 정확하게 파라미터를 넘겨야 한다.
		displayResult();

	}

}
