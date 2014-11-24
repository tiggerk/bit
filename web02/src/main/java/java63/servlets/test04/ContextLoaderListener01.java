package java63.servlets.test04;

import java.io.InputStream;
import java63.servlets.test04.dao.ProductDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/* 공통으로 사용하는 자원은 보통 ServletContext에 보관한다.
 * 
 * ServletContext => 웹 애플리케이션 시작 시 생성되어 종료하면 제거된다.
 * HttpSession => 최초 요청 시 생성된다. 타임아웃 또는 무효화 명령 시 제거된다.
 * HttpServletRequest => 요청 때마다 생성된다. 응답 후 제거.
 * PageContext => JSP에서 사용된다.
 *                각 JSP 실행할 때마다 생성되고 실행 완료되면 제거된다.
 */

//@WebListener  // 현업에서는 어노테이션 잘 안씀..
public class ContextLoaderListener01 implements ServletContextListener {
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    try {
      ServletContext ctx = sce.getServletContext();
      InputStream inputStream = Resources.getResourceAsStream(
          ctx.getInitParameter("mybatisConfig"));
      SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream);
      
      ProductDao productDao = new ProductDao();
      productDao.setSqlSessionFactory(sqlSessionFactory);
      
      // ServletContext 보관소에 객체 저장!
      ctx.setAttribute("productDao", productDao);
      
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  /* 웹 애플리케이션이 종료할 때 호출됨
     => 서블릿이 사용한 자원을 해제할 때
   */
  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    
  }

}
