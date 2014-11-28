package java63.web03.servlets;

import java.io.IOException;
import java63.web03.dao.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/* Redirect하기
 * => 클라이언트에게 콘텐츠를 보내지 않는다.
 * => 응답 헤더에 다시 요청할 주소를 보낸다.
 * 
 */
@WebServlet("/product/delete.do")
public class ProductDeleteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int no = Integer.parseInt(request.getParameter("no"));
    
    // 스프링의 ContextLoaderListener가 준비한 ApplicationContext 객체 꺼내기
    ApplicationContext appCtx = WebApplicationContextUtils.getWebApplicationContext(
        this.getServletContext());
    ProductDao productDao = (ProductDao)appCtx.getBean("productDao");
    
    productDao.delete(no);
    

    /* Redirect는 클라이언트에 재요청 URL만 보낸다.
     * 따라서 이전에 출력한 콘텐츠는 취소한다.
     * => 버퍼에 출력된 내용은 클라이언트로 보내지 않고 버린다.
     * => 위의 출력문은 작성할 필요가 없다.
     */
    response.sendRedirect("list.do");
    
    /* Redirect의 응답 내용 => Location 헤더에 재요청 URL이 있다.
       => 클라이언트에 어떤 내용을 출력하지 않고
          페이지를 바로 전환하는 효과를 내고 싶을 때.
       
     */
  }

}
