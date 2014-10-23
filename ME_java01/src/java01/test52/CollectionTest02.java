/* Collection API
   - 목록 데이터를 다루는 클래스 라이브러리
   - 모든 Collection 관련 클래스들은 Collection 규칙에 따라서 클래스를 만든다.
   - 종류
     1) List : 데이터 중복 허용
     2) Set : 데이터 중복 불가
     3) Map : key-value 쌍으로 데이터 관리
 */
package java01.test52;

import java.util.ArrayList;
import java.util.Iterator;

/* 제네릭(Generic) 사용
   - 클래스에서 다룰 데이터의 타입을 지정하는 방법.
   - 지정된 타입이 아닌 데이터에 대해서는 오류 발생 시킴.
 */

public class CollectionTest02 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("Hello!");
		list.add("Hello!");
		list.add(new String("Hello!"));
		list.add(10); // new Integer(10) <== autoboxing(자동으로 값을 객체로 감싸고 저장함)

		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("Hello");
		list2.add(new String("Hello"));
		//list2.add(new Integer(10));

		/* local inner class
		   => 특정 메서드에서만 사용할 클래스라면 그 메서드에 선언하라.
		 */
		class Score {
			String name;
			int kor;
			int eng;
			int math;

			public Score(String n, int k, int e, int m) {
				name = n;
				kor = k;
				eng = e;
				math = m;
			}
		}

		ArrayList list3 = new ArrayList();
		list3.add(new Score("홍길동", 100, 100, 100));
		list3.add(new Score("임꺽정", 90, 90, 90));

		// 질문 : 목록에서 Score 객체를 꺼내 이름을 출력하라
		//        for(;;), for(:), Iterator

		/* Iterator
		Iterator<Score> i = list3.iterator();
		while(i.hasNext()) {
			Score score = i.next();
			System.out.println(score.name);
		}
		 */

		/* for(;;)
		Score score = null;
		for (int i = 0; i < list3.size(); i++) {
			score = (Score)list3.get(i);
			System.out.println(score.name);
		}
		 */
		
		//for(:)
		Score score = null;
		for (Object value:list3) {
			score = (Score)value;
			System.out.println(score.name);
		}
		
		
		
		System.out.println("---------------------");

		ArrayList<Score> list4 = new ArrayList<Score>();
		list4.add(new Score("홍길동", 100, 100, 100));
		list4.add(new Score("임꺽정", 90, 90, 90));
		// Generic 사용 이유1.
		// - 지정된 타입이 아닌 다른 타입의 데이터 입력 시 컴파일 오류!!
		//   => 잘못된 사용을 미연에 방지할 수 있다.
		//list4.add("Hello"); // 컴파일 오류!
		

		// 질문 : 목록에서 Score 객체를 꺼내 이름을 출력하라
		//        for(;;), for(:), Iterator
		for (int i = 0; i < list4.size(); i++) {
			// Generic 사용 이유2.
			// - 이미 목록에 저장된 데이터가 어떤 타입인지 컴파일러가 알기 때문에
			//   값을 꺼낼 때 타입 캐스팅(type casting)할 필요가 없다.
			score = list4.get(i);
			System.out.println(score.name);
		}
	}

}
