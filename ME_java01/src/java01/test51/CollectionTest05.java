/* LinkedList 데이터 구조2
 * - insert()와 remove()를 구현하라
 */
package java01.test51;



/* 버킷 관리 */
class MyLinkedList2 {
	class Bucket {
		Object value;
		Bucket next;
	}

	Bucket start;
	Bucket end;
	int size;

	public MyLinkedList2() {
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

	public int insert(int index, Object value) {
		if (this.size > index && index > 0) {
			Bucket cursor = start;
			for (int i = 0; i < index - 1; i++) {
				cursor = cursor.next;
			}
			Bucket b = new Bucket();
			b.next = cursor.next;
			cursor.next = b;
			b.value = value;
			size++;
			return 0;
		} else if (index == 0) {
			Bucket b= new Bucket();
			b.next = start;
			b.value = value;
			start = b;
			size++;
			return 0;
		} else if (index == size) {
			Bucket cursor = end;
			Bucket b = new Bucket();
			b = end;
			cursor.next = end;
			b.value = value;
			size++;
			return 0;
		} else {
			return -1;
		}
	}

	public int remove(int index) {
		if (index < 0 || index >= this.size){
			return -1;
		} //if

		Bucket cursor = start;
		if(index == 0){
			start = start.next;

		} else{
			for(int i = 1; i <= index-1; i++){
				cursor = cursor.next; 
			} // for
			cursor.next = cursor.next.next;
		} //if
		size--;
		return 0;
	}

}


public class CollectionTest05 {
	public static void printArray(MyLinkedList2 list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	// LinkedList에 입력 테스트
	public static void main(String[] args) {
		MyLinkedList2 arr = new MyLinkedList2();
		arr.add("0000");
		arr.add("1111");
		arr.add("2222");
		arr.add("3333");
		arr.add("4444");
		arr.add("5555");
		arr.add("6666");
		arr.add("7777");

		System.out.println("---------------------");
		printArray(arr);

		System.out.println("-10에 입력:---------------------");
		arr.insert(-10, "-10의 입력");
		printArray(arr);

		System.out.println("30에 입력:---------------------");
		arr.insert(30, "30의 입력");
		printArray(arr);

		System.out.println("0에 입력:---------------------");
		arr.insert(0, "!!!!!!");
		printArray(arr);

		System.out.println("9에 입력:---------------------");
		arr.insert(9, "@@@@@@@@@");
		printArray(arr); 

		System.out.println("4에 입력:---------------------");
		arr.insert(4, "####");
		printArray(arr);



		System.out.println("-30번 삭제:---------------------");
		arr.remove(-30);
		printArray(arr);

		System.out.println("30번 삭제:---------------------");
		arr.remove(30);
		printArray(arr);

		System.out.println("0번 삭제:---------------------");
		arr.remove(0);
		printArray(arr);

		System.out.println("10번 삭제:---------------------");
		arr.remove(10);
		printArray(arr);

		System.out.println("4번 삭제:---------------------");
		arr.remove(4);
		printArray(arr);

	}

}
