package headFirstJava;

public class Test {
  Integer i = 0;
  int j;
  
  public static void main(String[] args) {
   Test t = new Test();
    t.go();
    String s = String.format("%x", 11);
    System.out.println(s);
  }
  
  public void go() {
    j = i;
    System.out.println(j);
    System.out.println(i);
  }

}
