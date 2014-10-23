package java01.test53.step04;

public class Iterator {
  String[] list;
  int cursor;
  
  public Iterator() {}
  
  public Iterator(String[] list) {
    this.list = list;
  }
  
  public void setList(String[] list) {
    this.list = list;
  }
  
  public boolean hasNext() {
    if (cursor < list.length)
      return true;
    else 
      return false;
  }
  
  public String next() {
    return list[cursor++];
  }
}










