package java63.web03.control.json;

import java.io.File;
import java.util.HashMap;
import java63.web03.dao.MakerDao;
import java63.web03.dao.ProductDao;
import java63.web03.domain.Product;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("json.productControl")
@RequestMapping("/json/product")
public class ProductControl {
  static Logger log = Logger.getLogger(ProductControl.class);
  static final int PAGE_DEFAULT_SIZE = 5;

  @Autowired MakerDao makerDao;
  @Autowired ProductDao productDao;
  @Autowired ServletContext servletContext;

  @RequestMapping(value="/add", method=RequestMethod.POST)
  public Object add(Product product) throws Exception {
    
    productDao.insert(product);
    
    if (product.getPhotofile() != null
        && !product.getPhotofile().isEmpty()) {
      String fileuploadRealPath =
          servletContext.getRealPath("/fileupload");
      String filename = System.currentTimeMillis() + "_";
      File file = new File(fileuploadRealPath + "/" + filename);
      
      product.getPhotofile().transferTo(file);
      product.setPhoto(filename);
      
      productDao.insertPhoto(product);
    }
    
    
    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    
    return resultMap;
  }

  @RequestMapping("/delete")
  public String delete(int no) throws Exception {
    productDao.deletePhoto(no);
    productDao.delete(no);
    return "redirect:list.do";
  }
  
  @RequestMapping("/list")
  public Object list(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="5") int pageSize) throws Exception {

    if (pageSize <= 0)
      pageSize = PAGE_DEFAULT_SIZE;
    
    int totalSize = productDao.totalSize();
    int maxPageNo = totalSize / pageSize;
    if ((totalSize % pageSize) > 0) maxPageNo++;
    
    if (pageNo <= 0) pageNo = 1;
    if (pageNo > maxPageNo) pageNo = maxPageNo;
    
    
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", ((pageNo - 1) * pageSize));
    paramMap.put("pageSize", pageSize);

    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("currPageNo", pageNo);
    resultMap.put("maxPageNo", maxPageNo);
    resultMap.put("products", productDao.selectList(paramMap));
    
    return resultMap;
  }

  @RequestMapping("/update")
  public String update(Product product) throws Exception {
    productDao.update(product);

    return "redirect:list.do";
  }

  @RequestMapping("/view")
  public String view(int no, Model model) throws Exception {
    Product product = productDao.selectOne(no);
    model.addAttribute("product", product);
    model.addAttribute("photos", productDao.selectPhoto(product.getNo()));
    model.addAttribute("makers", makerDao.selectNameList());

    return "product/ProductView";
  }

}
