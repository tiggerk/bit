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

@WebServlet("/product/list")
public class ProductListServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;
  
  ProductDao productDao = null;
  
  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    productDao = new ProductDao();
    
    int pageNo = 0;
    int pageSize = 0;
    
    if (req.getParameter("pageNo") != null) {
      pageNo = Integer.parseInt(req.getParameter("pageNo"));
      pageSize = 3;
    }
    
    if (req.getParameter("pageSize") != null) {
      pageSize = Integer.parseInt(req.getParameter("pageSize"));
    }
    
    res.setContentType("text/html;charset=utf-8");
    PrintWriter out = res.getWriter();
    
    
    out.println("<html>");
    out.println("<body>");
    out.println("<h1>List</h1>");
    out.println("<table width=300 border=2 text-align=center>");
    out.println("<tr>"
        + "<td>No</td>"
        + "<td>Name</td>"
        + "<td>Quantity</td>"
        + "<td>MakerNo</td>"
        + "</tr>");
    for (Product product : productDao.selectList(pageNo,pageSize)) {
      out.println("<tr>");
      out.println("<td>" + product.getNo() + "</td>" + 
          "<td>" + product.getName() + "</td>" + 
          "<td>" + product.getQuantity() + "</td>" + 
          "<td>" + product.getMakerNo() + "</td>");
      out.println("</tr>");
    }
    out.println("</table>");
    out.println("</body>");
    out.println("</html>");
  }

}


/* 
    out.println(
    product.getNo() + 
    product.getName() + 
    product.getQuantity() + 
    product.getMakerNo());
*/
