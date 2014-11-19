package java63.servlets.test01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/* HTML 출력하기
 */

@WebServlet("/test01/Test03")
public class Test03 extends GenericServlet {

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<body>");
    out.println("<h1>안녕하세요</h1>");
    out.println("</body>");
    out.println("</html>");
  }

}

