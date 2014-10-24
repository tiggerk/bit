/* Iterator를 클래스에서 자격을 의미하는 인터페이스로 바꾼다.
   - 인터페이스란? 자격, 규칙을 정의하는 문법이다.
   - 인터페이스 문법:
     자격, 규칙에 대한 메서드를 선언.
     상수 클래스 변수가 올 수 있다.
     
     메서드: 반드시 abstract public 이어야 한다.
     변수: 반드시 public static final 이어야 한다.
 */

package java01.test53.step06;

// 자격을 갖추기 위해서 가져야할 메서드를 선언.
public interface Iterator {
	/* public static final */ int i = 10;
	/* abstract public */ void setList(String[] list);
	/* abstract public */ boolean hasNext();
	abstract public String next();  // abstract public 생략 가능
}
