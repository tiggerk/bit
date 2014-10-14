/* 변수 선언
 - 변수? 값을 저장하는 메모리
 - 문법: [변수의 유형] [변수명];
   예) byte b; int i;
   
 * 값 할당? 변수(메모리)에 값을 저장하기
   - 변수명 = 값;
   - '='? 할당(assignment)연산자
   - 주의: '=='? equal연산자
 */

package java01;

public class Test06 {

	public static void main(String[] args) {
		byte i;
		
		i = 20;
		
		// 같은 유형의 메모리를 여러 개 생성
		byte b1, b2, b3;
		
		
		// 초기화 문장 => 같은 유형의 메모리를 여러 개 생성 + 값 할당
		byte b4 = 20, b5 = 30, b6 = 50;
		
		// 변수의 값을 꺼내기 전에 반드시 초기화 해야 한다.
		byte b7;
		
		//System.out.println(b7); //초기화 되지 않은 변수를 사용하면 컴파일 오류!

	}

}
