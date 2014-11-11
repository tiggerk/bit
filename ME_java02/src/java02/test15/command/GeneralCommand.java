package java02.test15.command;

import java.util.Map;
import java02.test15.annotation.Command;
import java02.test15.annotation.Component;
import java02.test15.ProductDao;

@Component
public class GeneralCommand {
  ProductDao productDao;
  
  public void setProductDao(ProductDao productDao) {
    this.productDao = productDao;
  }

  @Command("exit")
  public void doExit(Map<String, Object> params) throws Exception {
      System.out.println("ㅃㅇ");
  }
  
  @Command("help")
  public void doHelp(Map<String, Object> params) throws Exception {
    System.out.println("list");
    System.out.println("view 제품번호");
    System.out.println("add");
    System.out.println("delete 제품번호");
    System.out.println("update 제품번호");
    System.out.println("exit");
  }
  
  
}
