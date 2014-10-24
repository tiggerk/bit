/* HashMap 사용
   - key-value의 쌍으로 데이터를 관리한다.
   - key로 사용할 클래스는 hashCode(), equals()를 재정의해야 한다.
     => 인스턴스가 다르더라도 값이 같으면 같은 해시코드를 리턴한다.
     => 값이 같으면 equals()가 true를 리턴한다.
   - 기존에 자바에서 제공하는 클래스들 중에서 Stirng과 래퍼 클래스들은
     hashCode()와 equals()를 재정의했기 때문에 키로 사용할 수 있다.
 */


package java01.test52;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class CollectionTest04 {
	/* member inner class
	   - 인스턴스 메서드나 같은 멤버 이너 클래스만이 이 클래스를 사용할 수 있다.
	   - 클래스 멤버란? 클래스를 구성하고 있는 원소. 변수, 메서드, 이너 클래스 
	 */

	/* top level inner class
	   - member inner class에 static을 붙인 클래스
	   - 클래스 메서드나 static 블록에서 사용할 수 있다.
	 */
	static class Score {
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

	/* 스태틱 블록에서는 오로지 클래스 변수 및 클래스 메서드만 사용할 수 있다.
	   - 이유?
	     static이 붙으면 클래스 이름으로 직접 접근할 수 있다.
	     static이 안붙으면 인스턴스 없이 호출할 수 없다.
	     따라서 인스턴스를 먼저 생성해야한다.
	     
	     class A {
	      int value;

	      void print() { System.out.println(value); }  // 인스턴스 주소 없이는 호출이 불가능하다.

	      static void test() { // static 메소드는 this라는 히든변수가 없다.
	      	print(); // 호출가능하다면 어떤 일이 벌어질까?
	      }
	     } 
	     

	 */
	public static void main(String[] args) {
		HashMap<String,Score> map = new HashMap<String,Score>();
		map.put("1111", new Score("홍길동", 100, 100, 100));

		// key는 중복될 수 없다. 따라서 임꺽정은 기존 데이터를 덮어버린다.
		// => 홍길동 데이터는 날아감.
		map.put("1111", new Score("임꺽정", 100, 100, 100));
		map.put("2222", new Score("유관순", 100, 100, 100));

		System.out.println(map.get("1111").name);
		System.out.println(map.get("2222").name);


		// 질문: 키를 모른다고 가정하고 map에 저장된 값을 모두 출력하시오!
		// 힌트: API 문서를 보시오.

		// 방법1: EntrySet 활용
		// Set<Map.Entry<K,V>>	entrySet()
		//                      Returns a Set view of the mappings contained in this map.
		System.out.println("--------------------------");
		Set<Entry<String,Score>> kvSet = map.entrySet();
		for (Entry<String,Score> entry:kvSet) {
			System.out.println(entry.getKey() + ":" + entry.getValue().name);
		}

		// 방법2: 먼저 key 목록을 얻은 다음에, 그 키를 사용하여 값을 꺼내기
		// Set<K>	keySet()
		//          Returns a Set view of the keys contained in this map.
		System.out.println("--------------------------");
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			System.out.println(key + ":" + map.get(key).name);
		}

		// 방법3: key값을 알 필요가 없다면, 값만 꺼내기
		// Collection<V>	values()
		//                  Returns a Collection view of the values contained in this map.
		System.out.println("--------------------------");
		Collection<Score> valueList = map.values();
		for (Score value : valueList) {
			System.out.println(value.name);
		}


	}

}
