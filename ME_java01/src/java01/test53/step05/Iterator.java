package java01.test53.step05;

abstract public class Iterator {
  String[] list;
    
  public void setList(String[] list) {
    this.list = list;
  }
  
  abstract public boolean hasNext();
  
  abstract public String next();
}










