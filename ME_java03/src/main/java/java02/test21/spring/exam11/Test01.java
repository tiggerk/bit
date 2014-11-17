package java02.test21.spring.exam11;

/* 스프링 설정
 * => 호출할 생성자 지정하기
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

  public static void main(String[] args) {
    // Car c = new Car();
    ApplicationContext ctx = new ClassPathXmlApplicationContext(
        new String[]{"java02/test21/spring/exam11/application-context.xml"});
    
    Engine e01 = (Engine)ctx.getBean("engine");
    Engine e02 = (Engine)ctx.getBean("engine");
    
    if(e01 != e02) System.out.println("e01 != e02");
    
  }

}
