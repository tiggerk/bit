package java02.test21.spring.exam12;

/* 스프링 설정
 * => 호출할 생성자 지정하기
 */


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

  public static void main(String[] args) {
    // Car c = new Car();
    ApplicationContext ctx = new ClassPathXmlApplicationContext(
        new String[]{"java02/test21/spring/exam12/application-context.xml"});
    
    Tire t01 = (Tire)ctx.getBean("t01");
    System.out.println(t01);
    
    Tire t02 = (Tire)ctx.getBean("t02");
    System.out.println(t02);
    
  }

}
