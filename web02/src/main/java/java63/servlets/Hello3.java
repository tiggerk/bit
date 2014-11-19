package java63.servlets;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/* 애노테이션으로 서블릿 배치 하기
   - web.xml파일에서 metadata-complete를 false로 해줘야 함!!
 */


@WebServlet("/Hello3")
public class Hello3 extends GenericServlet{

  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    System.out.println("안뇽?ㅋㅋ");
    
  }

}
