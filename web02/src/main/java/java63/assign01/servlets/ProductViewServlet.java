package java63.assign01.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java63.assign01.dao.ProductDao;
import java63.assign01.domain.Product;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/product/view")
public class ProductViewServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;
  
  ProductDao productDao = null;
  
  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    productDao = new ProductDao();
    
    res.setContentType("text/html;charset=utf-8");
    PrintWriter out = res.getWriter();
    
    Product product = productDao.selectOne(Integer.parseInt((String)req.getParameter("no")));
    
    out.println("<h1> View </h1>");
    if (product == null) {
      out.println("<h2> 해당 번호의 제품 정보를 찾을 수 없습니다.</h2>");
      return;
    }
    out.println("<h2> 제품번호: " + (String)req.getParameter("no") + "</h2>");
    out.println("<h2> 제품명: " + product.getName() + "</h2>");
    out.println("<h2> 수량: " + product.getQuantity() + "</h2>");
    out.println("<h2> 제조사 번호: " + product.getMakerNo() + "</h2>");
    out.println();
    
  }

}
