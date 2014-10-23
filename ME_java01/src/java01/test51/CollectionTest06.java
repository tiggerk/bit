/* LinkedList 데이터 구조 3
   - 인덱스로 버킷을 알아내는 코드를 별도의 메서드로 정의함.
   - getBucketByIndex()
   - 이 메서드는 클래스 내부에서만 사용할 것이므로 private으로
     접근을 제한한다.
 */
package java01.test51;



/* 버킷 관리 */
class MyLinkedList3 {
  class Bucket {
    Object value;
    Bucket next;
  }
  
  Bucket start;
  Bucket end;
  int size;
  
  public MyLinkedList3() {
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
  
  private Bucket getBucketByIndex(int index) {
    Bucket cursor = start;
    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    } //for
    return cursor;
  }
  
  public Object get(int index) {
    if (index < 0 || index >= this.size) 
      return null;
    
    //Bucket cursor = getBucketByIndex(index);
    //return cursor.value;
    
    return getBucketByIndex(index).value;
  }
  
  public int insert(int index, Object value) {
    if (index < 0 || index >= this.size) 
      return -1;
    
    Bucket temp = new Bucket();
    temp.value = value;
    
    if (index == 0){
      temp.next = start;
      start = temp;
      
    } else {
      Bucket cursor = getBucketByIndex(index - 1);
      temp.next = cursor.next;
      cursor.next = temp;
    }
    size++;
    return 0;
  }
  
  public int remove(int index) {
    if (index < 0 || index >= this.size){
      return -1;
    } //if

    if(index == 0){
      start = start.next;

    } else{
      Bucket cursor = getBucketByIndex(index - 1);
      cursor.next = cursor.next.next;
    } //if
    size--;
    return 0;
  }
}

public class CollectionTest06 {
  public static void printArray(MyLinkedList3 list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }// for
  }

  /* LinkedList 삭제 테스트*/
  public static void main(String[] args) {
    MyLinkedList3 arr = new MyLinkedList3();
    arr.add("00000");
    arr.add("11111");
    arr.add("22222");
    arr.add("33333");
    arr.add("44444");
    arr.add("55555");
    arr.add("66666");
    arr.add("77777");

    System.out.println("-----------------");
    printArray(arr);
    
    System.out.println("-30번 삭제: -------------");
    arr.remove(-30);
    printArray(arr);
    
    System.out.println("30번 삭제: -------------");
    arr.remove(30);
    printArray(arr);
    
    System.out.println("0번 삭제: -------------");
    arr.remove(0);
    printArray(arr);
    
    System.out.println("6번 삭제: -------------");
    arr.remove(6);
    printArray(arr);
    
    System.out.println("2번 삭제: -------------");
    arr.remove(2);
    printArray(arr);
    
  }
  
  /* LinkedList에 입력 테스트*/
  public static void main01(String[] args) {
    MyLinkedList3 arr = new MyLinkedList3();
    arr.add("00000");
    arr.add("11111");
    arr.add("22222");
    arr.add("33333");
    arr.add("44444");
    arr.add("55555");
    arr.add("66666");
    arr.add("77777");

    System.out.println("-----------------");
    printArray(arr);
    
    System.out.println("-10에 입력: -----------------");
    arr.insert(-10, "-10에 입력");
    printArray(arr);
    
    System.out.println("30에 입력: -----------------");
    arr.insert(30, "30에 입력");
    printArray(arr);
    
    System.out.println("0번에 입력: -----------------");
    arr.insert(0, "!!!!!!");
    printArray(arr);
    
    System.out.println("8번에 입력: -----------------");
    arr.insert(8, "@@@@@@@");
    printArray(arr);
    
    System.out.println("4번에 입력: -----------------");
    arr.insert(4, "######");
    printArray(arr);
    
  }
}












