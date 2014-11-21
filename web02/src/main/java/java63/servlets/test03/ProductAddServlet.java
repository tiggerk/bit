package java63.servlets.test03;

import java.io.IOException;
import java63.servlets.test03.domain.Product;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

/* POST 요청 처리
 * => 한글이 깨지는 문제 해결
 * => 처음 getParameter()를 호출하기 전에
 *    request.setCharacterEncoding("UTF-8") 호출하라!
 *    => 클라이언트가 보내는 데이터의 문자 집합을 알려줘라!
 */

@WebServlet("/test03/product/add")
public class ProductAddServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    
    Product product = new Product();
    product.setName(request.getParameter("name"));
    product.setQuantity(Integer.parseInt(request.getParameter("qty")));
    product.setMakerNo(Integer.parseInt(request.getParameter("mkno")));
    
    AppInitServlet.productDao.insert(product);

    HttpServletResponse orginResponse = (HttpServletResponse)response;
    orginResponse.sendRedirect("list");
  
  
  }

}
