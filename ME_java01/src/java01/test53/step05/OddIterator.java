package java01.test53.step05;

public class OddIterator extends Iterator {
  int cursor;
  
  public OddIterator() {
	  cursor = 1;
  }
  
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










