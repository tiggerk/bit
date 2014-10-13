/*  패키지
 *  - 클래스 파일을 좀 더 조직적으로 관리하기 위한 디렉토리
 * 
 *  자바 소스에서 패키지 표현
 *  - 패키지명A.패키지명B.패키지명C
 *  
 *  패키지의 경로
 *  - $프로젝트/src/패키지명A/패키지명B/패키지명C
 *  
 *  패키지는 디렉토리로 표현한다.
 *  
 *  패키지 생성
 *  - 직접 src 디렉토리에 원하는 패키지를 생성하면 된다.
 *  
 *  패키지 이름
 *  - 중복되어서는 안되기 때문에 보통 도메인 주소를 사용한다.
 *  - 쉽게 관리하기 위해 도메인 이름을 거꾸로 사용한다.
 *  - 예)
 *     도메인명: java63.bitacademy.net
 *     패키지명: net.bitacademy.java63
 *     
 *  도메인명을 거꾸로 사용하는 이유 (= 폴더 관리가 쉽다)
 *  - 도메인 이름은 뒤로 갈수록 상위 그룹을 의미한다.
 *  - 그래서 디렉토리를 생성할 때 상위 그룹을 먼저 생성하는 것이 좋다.
 *    예)
 *      net/bitacademy/java63
 *      net/bitacademy/java64
 *      net/daum/dev1
 *      net/daum/dev2
 *      
 */

package java01;

public class Test04 {
	public static void main(String[] args) {
		System.out.println("okok3");
	}
}
