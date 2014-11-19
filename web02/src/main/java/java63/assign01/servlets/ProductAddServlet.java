package java63.assign01.servlets;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import java63.assign01.dao.ProductDao;
import java63.assign01.domain.Product;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/product/add")
public class ProductAddServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;
  ProductDao productDao = null;
  
  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    productDao = new ProductDao();
    
    res.setContentType("text/html;charset=utf-8");
    PrintWriter out = res.getWriter();
    
    try {
      Product product = new Product();
      product.setName((String)req.getParameter("name"));
      product.setQuantity(Integer.parseInt((String)req.getParameter("qty")));
      product.setMakerNo(Integer.parseInt((String)req.getParameter("mkno")));
      
      productDao.insert(product);
      out.println("<h1>");
      out.print(product.getName());
      out.println("를 저장하였습니다.");
      out.println("</h1>");
      
    } catch (Exception e) {
      e.printStackTrace();
      out.println("서버가 바쁩니다. 잠시 후 다시 시도하세요.");
    }
    
  }

}
