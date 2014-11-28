package java63.web03.servlets;

import java.io.IOException;

import java63.web03.dao.MakerDao;
import java63.web03.dao.ProductDao;
import java63.web03.domain.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebServlet("/product/view.do")
public class ProductViewServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int no = Integer.parseInt(request.getParameter("no"));
    
    // 스프링의 ContextLoaderListener가 준비한 ApplicationContext 객체 꺼내기
    ApplicationContext appCtx = WebApplicationContextUtils.getWebApplicationContext(
        this.getServletContext());
    
    ProductDao productDao = (ProductDao)appCtx.getBean("productDao");
    Product product = productDao.selectOne(no);
    request.setAttribute("product", product);
    request.setAttribute("photos",
        productDao.selectPhoto(product.getNo()));
    
    MakerDao makerDao = (MakerDao)appCtx.getBean("makerDao");
    request.setAttribute("makers", makerDao.selectNameList());
    
    response.setContentType("text/html;charset=UTF-8");
    
    RequestDispatcher rd = request.getRequestDispatcher("/product/ProductView.jsp");
    rd.include(request, response);
  }

}
