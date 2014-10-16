/* import
   - 다른 패키지에 있는 클래스를 사용하려면 반드시 패키지 이름을 지정해야 한다.
      예) java.util.ArrayList
       
   - 그러나 import 문을 사용하여 미리 클래스의 정보를
     컴파일러에게 알려 줄 수 있다.
      예) import java.util.Array;
       
   - 또는 클래스가 소속되어 있는 패키지 이름을 알려줄 수 있다.
      예) import java.util.*;	(*:와일드카드)
       
   - 가능한 클래스 이름까지 알려주는게 소스 코드 해석에 도움이 된다.
     컴파일 속도도 더 빠르다.
    
 */
package java01;

// import문은 컴파일러가 참조하는 명령어다.
// 컴파일 후 제거된다.
import java.util.ArrayList;

public class Test26 {

	public static void main(String[] args) {
		int[] scores = new int[]{100, 90, 80};
		// 배열에서 값을 순차적으로 꺼낸다.
		for (int value : scores) {
			System.out.println(value);
		}
		System.out.println("----------------");

		ArrayList list = new ArrayList();
		list.add("홍길동");
		list.add(100);
		list.add(90);
		list.add(80);
		// Collection 객체에 저장된 값을 순차적으로 하나씩 꺼낸다.
		for (Object value : list) {
			System.out.println(value);
		}

	}
}
