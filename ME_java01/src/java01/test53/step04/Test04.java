/* 4단계
   - Iterator 변경을 자유롭게 하기
     => Test04가 사용할 Iterator를 대체하기 쉽게 하자!
   - 해결책
     1) Iterator 클래스 이름을 외부에서 받자!
     2) 외부에서 받은 클래스로 Iterator 객체를 생성하자!
     3) 그 객체를 사용하여 값을 꺼내자!

   - 어떤 값을 외부에서 받는 방법
     1) 프로그램 파라미터(아규먼트) 이용
     2) JVM 파라미터(아규먼트)
      예) java -D이름=값 -D이름=값 Test04 파라미터값 파라미터값 파라미터값 ...
          그러면 VM에게 전달된 값을 어떻게 알아내는가? 소스 보세요. main01() 참고!!
 */

package java01.test53.step04;

import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Properties;

public class Test04 {
	public static void main(String[] args) throws Exception {
		String iteratorClassName = System.getProperty("iterator");
		
		//System.out.println(iteratorClassName);
		
		// 클래스 이름(패키지명 포함)으로 객체 생성하기
		// 1) 클래스를 로딩하라
		Class clazz = Class.forName(iteratorClassName);
		
		// 2) Class객체를 사용하여 인스턴스 생성
		Iterator iterator = (Iterator)clazz.newInstance();
		
		// 3) Iterator를 사용하기 전에 필요한 값을 설정한다.
		iterator.setList(args);
		
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println("--------------------------");
		// Iterator 클래스의 메서드 이름을 출력
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			System.out.println(method.getName());  //public 메서드
		}
		
		
		// 안타깝게도 다른 Iterator는 사용할 수 없다.
		// 다음 단계를 보기 바람!!
	}




	// JVM 프로퍼티 값 꺼내기 예제
	public static void main01(String[] args) {
		// -D 옵션으로 전달된 값을 꺼낼 때,
		// System.getProperty(파라미터명) 사용하라!
		System.out.println(System.getProperty("iterator"));
		System.out.println(System.getProperty("name"));
		System.out.println(System.getProperty("age"));

		System.out.println("--------------------------");

		// -D 옵션으로 전달된 값을 담고 있는 객체를 왕창 꺼낸다.

		Properties props = System.getProperties();
		Enumeration keyList = props.keys();

		String key = null;
		while(keyList.hasMoreElements()) {
			key = (String)keyList.nextElement();
			System.out.println(key+ " ==> " + props.getProperty(key));
		}

	}

}



