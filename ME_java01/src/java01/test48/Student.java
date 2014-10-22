/* Object 클래스
   - 자바 최상위 클래스이다.
   - 수퍼 클래스를 지정하지 않으면 자바 컴파일러는 
     자동으로 Object를 상속받게 한다.
   - 주요 메서드
     1) toString() : 인스턴스 정보 출력
        기본 리턴 값: 클래스명@해시값(4바이트 정수값)
        해시값 : (인스턴스 별로 고유 식별자 번호)
    => 모든 자바 클래스는 Object의 자손이다.
 */

package java01.test48;

public class Student /* extends Object*/ {
	String name;
	int age;
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name + "," + age;
	}

}
