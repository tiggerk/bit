/* 다형성: 다형적 변수(Polymorphic variables)
 */

package java01.test44;

public class Test44_2 {

	public static void main(String[] args) {
		Tank obj1 = new Tank();
		Soldier obj2 = new Soldier();
		Vulture obj3 = new Vulture();
		
		// 다형적 변수 : 변수의 쓰임이 달라지는 것.
		// obj4 변수는 Vehicle 객체를 가리킬 때도 사용될 수 있다.
		// Vehicle의 서브 클래스의 객체를 가리킬 때도 사용될 수 있다.
		Vehicle obj4 = new Tank();
		Vehicle obj5 = new Vulture();
		
		// 어떤 참조변수(레퍼런스)는 해당 클래스 또는 서브 클래스의 객체를 가리킬 수 있다.
		// 단 수퍼 클래스의 객체는 가리킬 수 없다.
		// 수퍼 클래스는 서브 클래스보다 기능이 적을 수 있기 때문이다.
		//Vehicle obj6 = new Soldier();  //오류!!
		
		// 퀴즈
		// Tank와 Vulture, Soldier 객체를 저장할 수 있는
		// 참조변수 배열을 선언하시오.
		Mover[] m = new Mover[3];
		Unit[] u = new Unit[10];
		
		// 퀴즈
		// 수퍼 클래스의 참조 변수로 서브 클래스를 가리킬 때는
		// 비록 수퍼 클래스의 메서드를 호출하더라도,
		// 서브 클래스의 오버라이딩 메서드가 있다면 그 메서드가 호출된다.
		Vehicle v1 = new Tank();
		v1.move(0);
		
		

	}

}
