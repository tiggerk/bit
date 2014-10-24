package java01.test53.step06;

public class EvenIterator extends AbstractIterator {
  int cursor;
  
  public EvenIterator() {}
  
  public boolean hasNext() {
    if (cursor < list.length)
      return true;
    else 
      return false;
  }
  
  public String next() {
    String value = list[cursor];
    cursor += 2;
    return value;
  }
}










