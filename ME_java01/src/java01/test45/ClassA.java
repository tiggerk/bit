/* static 블록
   - 클래스가 로딩 => 클래스 변수 준비 => static 블록 실행
   - 클래스가 로딩된 후 클래스 변수를 초기화하는 용도로 사용
   - 클래스 로딩은 단 한 번만 수행된다. 따라서 static 블록도 단 한 번만 실행된다.  
 */

package java01.test45;

public class ClassA {
	static int value = 100;
	
	static {
		System.out.println("ClassA의 static 블록 실행");
		value = 200;
	}
	
	static {
		System.out.println("static 블록이 여러 개일 경우 순차적으로 실행.");
	}
	

}
