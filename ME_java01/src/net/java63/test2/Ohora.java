/* Quiz 2
 * 1) net.java63.test 패키지를 생성하라!
 * 2) 이 패키지에 Ohora 이름을 갖는 클래스를 생성하라!
 * 3) 클래스를 실행하면 다음과 같이 출력되게 작성하라!
 *    > 1 + 3 = 4 이다.
 *    조건: 다음 코드를 main()에 삽입하고,
 *          v1, v2 변수를 이용하여 그 결과를 출력하라!
 *     int v1 = 1;
 *     int v2 = 3;
 *         
 * 4) 터미널을 사용하여 Ohora 클래스를 실행하라!
 */

package net.java63.test2;

public class Ohora {
	public static void main(String[] args) {
		int v1 = 1;
		int v2 = 3;
		
		System.out.print(v1 + "+" + v2 + "=" + (v1+v2));
	}

}
