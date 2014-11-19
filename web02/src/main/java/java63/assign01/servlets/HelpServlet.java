package java63.assign01.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/help")
public class HelpServlet extends GenericServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    
    res.setContentType("text/html;charset=utf-8");
    PrintWriter out = res.getWriter();
    out.println("<html>");
    out.println("<body>");
    out.println("<h1> Help </h1>");
    out.println("<ul>");
    out.println("<li> list </li>");
    out.println("<li> view 제품번호 </li>");
    out.println("<li> add </li>");
    out.println("<li> delete 제품번호 </li>");
    out.println("<li> update 제품번호 </li>");
    out.println("</ul>");
    out.println("</body>");
    out.println("</html>");
    
  }

}
