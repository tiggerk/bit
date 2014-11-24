package java63.servlets.test04;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 공통으로 사용하는 자원은 보통 ServletContext에 보관한다.
 * 
 * ServletContext => 웹 애플리케이션 시작 시 생성되어 종료하면 제거된다.
 * HttpSession => 최초 요청 시 생성된다. 타임아웃 또는 무효화 명령 시 제거된다.
 * HttpServletRequest => 요청 때마다 생성된다. 응답 후 제거.
 * PageContext => JSP에서 사용된다.
 *                각 JSP 실행할 때마다 생성되고 실행 완료되면 제거된다.
 */

//@WebListener  // 현업에서는 어노테이션 잘 안씀..
public class ContextLoaderListener implements ServletContextListener {
  static ApplicationContext appCtx;
  
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    try {
      appCtx = new ClassPathXmlApplicationContext(
          new String[]{"java63/servlets/test04/application-context.xml"});
      
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    
  }

}
