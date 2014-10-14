/* 부동 소수점
   - 상수의 표현
     30f 또는 30F <= 4byte 부동소수점을 의미
     30.0 또는 40.0 <= 8byte 부동소수점을 의미
     
   - 부동소수점? 소수점이 움직인다.
     3.14 = 31.4 * 10^-1 = 314 * 10^-2 = 0.314 * 10^1 =...
     
 * 부동 소수점을 메모리에 저장하려면?
   - 부동 소수점을 정수 부분과 지수 부분을 분리하여 저장한다.
   - 3.14 => 314(정수) * 10E-2(지수)
   
   float => 24비트(정수부) + 8비트(지수부) => 유효자릿수: 6자리, 단정도 변수
   double => 53비트(정부수) + 11비트(지수부) => 유효자릿수: 15자리(약 2배 정밀하다), 배정도 변수
   
 */


package java01;

public class Test09 {

	public static void main(String[] args) {
	 // 부동소수점 표기 예
		float f = 3.14f;
		float f2 = 3.14F;
		float f3 = 31.4E-1f;
		float f4 = 314E-2f;
		float f5 = 0.314E1f;
		
		// 다음 값은 저장할 수는 있지만
		// 정수부 메모리 크기를 넘는 값은 반올림한다.(그 이후값은 0으로 취급)
		// 그래서, 정확한 값이 저장되지 않는다.
		// 오류가 발생하지 않는다하더라도 주의하라!
		float f6 = 321354654351321324354354354f;
		
		// 부동소수점 변수에 값을 저장할 때는
		//float x = 소수점을 뗀 6자리;
		//double y = 소수점을 뗀 15자리;
		
		// 주의해야할 예
		float i = 3.14159f;
		float j = 15654.7f;
		float result = i + j; // 조심! 두 값의 더한 결과는 유효 자릿수를 넘는다!!
		// result = 15657.84159 오류는 안뜨지만 저장된 결과는 다르다.(짤리기 때문에)
		
		System.out.println(result); // 실제 출력결과 => 15657.842
		
	}

}
