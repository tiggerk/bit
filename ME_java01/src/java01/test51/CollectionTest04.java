/* LinkedList 데이터 구조
 */
package java01.test51;


/* 버킷 관리 */
class MyLinkedList {
	class Bucket {
		// 값(인스턴스 주소)을 저장하기 위한 변수 선언
		Object value;
		
		// 다음 버킷의 주소 저장 : 링크 정보
		Bucket next;
	}
	
	Bucket start;
	Bucket end;
	int size;
	
	public MyLinkedList() {
		start = new Bucket();
		end = start;
	}
	
	public int add(Object value) {
		end.value = value;
		end.next = new Bucket();
		end = end.next;
		return ++size;
	}

	public int size() {
		return size;
	}
	
	public Object get(int index) {
		if (index < 0 || index >= this.size)
			return null;
		
		Bucket cursor = start;
		
		for (int i = 1; i <= index; i++) {
			cursor = cursor.next;
		} //for
		return cursor.value;
	}
}
	

public class CollectionTest04 {
	public static void printArray(MyLinkedList list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public static void main(String[] args) {
		MyLinkedList arr = new MyLinkedList();
		System.out.println("현재 크기: " + arr.add("0000"));
		System.out.println("현재 크기: " + arr.add("1111"));
		System.out.println("현재 크기: " + arr.add("2222"));
		System.out.println("현재 크기: " + arr.add("3333"));
		System.out.println("현재 크기: " + arr.add("4444"));
		System.out.println("현재 크기: " + arr.add("5555"));
		System.out.println("현재 크기: " + arr.add("6666"));
		System.out.println("현재 크기: " + arr.add("7777"));

		System.out.println("---------------------");
		printArray(arr);
	}

}
