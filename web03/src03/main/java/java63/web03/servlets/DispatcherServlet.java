package java63.web03.servlets;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

//ProductListServlet 복사한거임!

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  public void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      ApplicationContext appCtx = WebApplicationContextUtils.getWebApplicationContext(
          this.getServletContext());

      // 스프링 사용
      // 1. 서블릿 URL을 알아낸다.  예) /product/list.do
      String servletPath = request.getServletPath();
      
      // 2. 서블릿 경로로 컨트롤 객체를 꺼낸다.  예) ProductListControl 객체
      Object controller = appCtx.getBean(servletPath);
      
      // 3. controller의 execute() 메소드 꺼내기
      Method execute = controller.getClass().getMethod(
          "execute", HttpServletRequest.class);
      
      // 4. execute 메소드 호출
      String viewUrl = (String)execute.invoke(controller, request);
      
      // 5. cookie 추가하기
      @SuppressWarnings({ "unchecked", "rawtypes" })
      ArrayList<Cookie> cookieList = 
          (ArrayList)request.getAttribute("cookieList");
      if (cookieList != null) {
        for (Cookie cookie : cookieList) {
          response.addCookie(cookie);
        }
      }
      
      // 6. 뷰 컴포넌트로 보내기
      if (viewUrl.startsWith("redirect:")) {
        response.sendRedirect(viewUrl.substring(9));
        
      } else {   // viewUrl을 인클루딩한다.
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
        rd.include(request, response);
      }
      
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/common/Error.jsp");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }
  }

}
