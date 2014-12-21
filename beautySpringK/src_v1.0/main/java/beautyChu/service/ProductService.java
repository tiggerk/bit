package beautyChu.service;

import java.util.HashMap;
import java.util.List;
import beautyChu.dao.ProductDao;
import beautyChu.domain.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/* Service 컴포넌트의 역할
 * => 비즈니스 로직 수행
 * => 트랜잭션 관리
 */

@Service
public class ProductService {
  @Autowired
  ProductDao productDao;
  
 /* public List<?> getList(int pageNo, int pageSize) {
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", ((pageNo - 1) * pageSize));
    paramMap.put("pageSize", pageSize);
    
    return productDao.selectList(paramMap);
  }
  
  public int getMaxPageNo(int pageSize) {
    int totalSize = productDao.totalSize();
    int maxPageNo = totalSize / pageSize;
    if ((totalSize % pageSize) > 0) maxPageNo++;
    
    return maxPageNo;
  }
  
   @Transactional 선언
   * => 메서드 안의 입력/변경/삭제(manipluation) 작업을 하나의 작업을 묶는다.
   * => 모든 작업이 성공했을 때만 서버에 반영한다. 
   
  @Transactional(
      rollbackFor=Exception.class, 
      propagation=Propagation.REQUIRED)
  public void add(Product product) {
    productDao.insert(product);
    
    if (product.getPhoto() != null) {
      productDao.insertPhoto(product);
    }
  }
  
  @Transactional(
      rollbackFor=Exception.class, 
      propagation=Propagation.REQUIRED)
  public void update(Product product) {
    productDao.update(product);
  }
  
  @Transactional(
      rollbackFor=Exception.class, 
      propagation=Propagation.REQUIRED)
  public void delete(int productNo) {
    productDao.deletePhoto(productNo);
    productDao.delete(productNo);
  }
  
  public Product get(int productNo) {
    Product product = productDao.selectOne(productNo);
    product.setPhotoList( productDao.selectPhoto(productNo));
    return product;
  }*/
}
















