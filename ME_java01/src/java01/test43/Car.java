/* 추상 클래스
   - 그 자체로 사용하지 않는 클래스.
   - 단지 서브 클래스에게 공통 속성이나 메서드를 물려주기 위해 만든 클래스
   - 인스턴스를 생성할 수 없다.
   - 문법: abstract class 클래스명 {}
   
 * 추상화
   - 역할을 정의하는 것/명령어를 분류하는것/사용자가 새로운 데이터타입을 정의하는 것
   - 역할을 식별해서 분류(정의)하는 과정
   
 * 용어정리!
   - 일반 클래스(concrete class)
     1) 패키지 멤버 클래스 : package member class
     2) 중첩 클래스(내부 클래스) : inner class
        i) top level inner class
        ii) member inner class
        iii) local inner class
        iv) anonymous inner class
   - 추상 클래스(abstract class)
 */

package java01.test43;


// public(access modifier)와 abstract 키워드는 순서에 상관없다.
//public abstract class Car {   //가능
abstract public class Car {
	String maker;
	String model;
	int cc;
	int capacity;
	java.util.Date releaseDate;

}
