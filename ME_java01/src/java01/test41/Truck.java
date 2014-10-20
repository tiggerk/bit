/* 호출할 수퍼 클래스의 생성자를 지정하기
   - 서브 클래스에서 어떤 수퍼 클래스 생성자를 호출할지 지정하지 않으면,
     수퍼 클래스의 기본 생성자를 호출한다.
   - 문법 : super(호출할 생성자의 파라미터 값)
   
 */
package java01.test41;

public class Truck extends Car {
	float weight = 1000; 
	boolean autoDump;
	
	public Truck() {
		// 수퍼 클래스의 기본 생성자가 없으면 다음과 같이 다른 수퍼 클래스의
		// 생성자를 명시적으로 호출해야 한다.
		super("미정", "미정", 800);
		autoDump = true;
	}
}
