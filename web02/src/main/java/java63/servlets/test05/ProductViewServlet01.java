package java63.servlets.test05;

import java.io.IOException;
import java63.servlets.test05.dao.ProductDao;
import java63.servlets.test05.domain.Product;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

//@WebServlet("/test05/product/view")
public class ProductViewServlet01 extends GenericServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    int no = Integer.parseInt(request.getParameter("no"));
    
    // 스프링의 ContextLoaderListener가 준비한 ApplicationContext 객체 꺼내기
    ApplicationContext appCtx = WebApplicationContextUtils.getWebApplicationContext(
        this.getServletContext());
    
    ProductDao productDao = (ProductDao)appCtx.getBean("productDao");
    Product product = productDao.selectOne(no);
    request.setAttribute("product", product);
    
    // include를 수행할 때는 여기에서 콘텐츠 타입을 설정해야 한다.
    response.setContentType("text/html;charset=UTF-8");

    
    // 결과를 출력하기 위해 JSP에게 위임한다.
    RequestDispatcher rd = request.getRequestDispatcher("/test05/product/ProductView.jsp");
    rd.include(request, response);
  }

}
