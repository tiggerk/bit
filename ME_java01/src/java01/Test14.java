/* garbage와 garbage collector
   - Garbage? 참조하는 변수가 없는 메모리
   - Garbage Collector? 가비지의 메모리를 해제하는 객체
 */

package java01;

public class Test14 {

	public static void main(String[] args) {
		int[] p = new int[5]; // 예) 배열의 주소가 100번지라고 하자!
		int[] p2 = new int[3]; // 예) 200번지
		int[] p3 = p; // 100번지
		
		
		p3[2] = 100;
		System.out.println(p[2]);
		
		p2 = p; // p2는 100번지 => 200번지의 주소를 잃어버렸기 때문에
           		// 해당 배열은 가비지가 된다.
		
		// 200번지 배열의 주소는 누가 갖고 있는가?
		// 갖고 있는 변수가 없다! => 200번지 배열은 쓰레기(garbage)가 되었다.
		
		// 가비지는 언제 청소하는가?(사용될 수 없는 메모리 해제 시점)
		// 1) idle time
		// 2) 메모리가 부족할 때
		// 3) 가비지 컬렉터가 관리하는 메모리 영역은 Heap이다.
		// * 잠깐 실행하는 경우는 가비지 컬렉터가 동작하지 않는다.
		//   가비지가 생겼다고 가비지 컬렉터가 즉시 동작하는 것이 아니다!!!!
		// 실무에서는 가비지 생성을 최소화 하도록 프로그래밍을 한다.
		
	}

}
