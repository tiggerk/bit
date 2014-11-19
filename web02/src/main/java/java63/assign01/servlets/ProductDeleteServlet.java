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

@WebServlet("/product/delete")
public class ProductDeleteServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;
  ProductDao productDao = null;
  
  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    productDao = new ProductDao();
    
    res.setContentType("text/html;charset=utf-8");
    PrintWriter out = res.getWriter();
    
    Product product = productDao.selectOne(Integer.parseInt((String)req.getParameter("no")));
    
    if (product == null) {
      out.println("<h1>해당 번호의 제품 정보를 찾을 수 없습니다.</h1>");
      return;
    }
    
    productDao.delete(Integer.parseInt((String)req.getParameter("no")));
    out.println("<h1>");
    out.print(product.getNo() + "번 ");
    out.print(product.getName());
    out.println("를 삭제하였습니다. </h1>");
    
  }

}
