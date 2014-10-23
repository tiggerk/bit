package java01.test53.step03;

public class ReverseIterator {
  String[] list;
  int cursor;
  
  public ReverseIterator(String[] list) {
    this.list = list;
    cursor = list.length - 1; // 배열의 끝 인덱스 가리킴.
  }
  
  public boolean hasNext() {
    if (cursor >= 0)
      return true;
    else 
      return false;
  }
  
  public String next() {
    return list[cursor--];
  }
}










