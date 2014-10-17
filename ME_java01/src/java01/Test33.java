/* boxing and unboxing
   - boxing : 기본 형 값을 가지고 랩퍼 객체를 자동으로 만드는 것.
   - unboxing : 랩퍼 객체에서 기본 형 값을 자동으로 추출하는 것.
   - 이 두가지가 자동으로 이루어지는 것 => autoboxing (JDK 1.5이상)
   
 */

package java01;

public class Test33 {

	public static void main(String[] args) {
		// boxing
		Integer i = 10; // new Integer(10)과 같다.
		
		// unboxing
		int j = i; // i.intValue()와 같다.
	}

}
