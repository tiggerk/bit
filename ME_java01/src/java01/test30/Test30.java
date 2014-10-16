/* 인스턴스 변수
   - 값을 개별적으로 관리할 필요가 있을 때 사용.
   
 */

package java01.test30;

// 주제 : Calculator의 기능을 이용하여 다음 계산을 수행하라!
// 단, 계산은 순차적으로 실행하라.(즉, 연산자 우선순위 적용No!!)
// 다음 두 개의 식을 동시에 계산하라!


// 10 + 2 * 7 - 4 / 2 = ?
// 20 * 3 + 76 - 5 = ?

// 단계7: result변수를 개별적으로 유지 => 인스턴스(instance) 변수

public class Test30 {

	public static void main(String[] args) {
		// 10 + 2 * 7 - 4 / 2 = ?
		// 20 * 3 + 76 - 5 = ?
		
		// Calculator 클래스의 명령에 따라 준비된 메모리 => 인스턴스
		// 그 인스턴스 메모리의 주소를 저장하는 변수 => 레퍼런스(주소 변수)
		Calculator c1 = new Calculator();
		Calculator c2 = new Calculator();
		
		Calculator.plus(c1, 10);
		Calculator.plus(c2, 20);
		
		Calculator.plus(c1, 2);
		Calculator.multiple(c2, 3);
		
		Calculator.multiple(c1, 7);
		Calculator.plus(c2, 76);
		//Calculator.result = -100; //메롱 <= 접근 불가!!(private이라서!)
		
		Calculator.minus(c1, 4);
		Calculator.minus(c2, 5);
		
		Calculator.divide(c1, 2);
		
		System.out.println("결과는 = " + Calculator.getResult(c1));
		System.out.println("결과는 = " + Calculator.getResult(c2));
	}

}
