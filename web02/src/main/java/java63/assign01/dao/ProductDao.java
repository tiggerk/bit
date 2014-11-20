/* 페이징 처리
 * => DBMS마다 처리하는 방법이 다르다. 
 */
package java63.assign01.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java63.assign01.domain.Product;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

@Component
public class ProductDao {
  
  String resource = "java63/assign01/dao/mybatis-config.xml";
  public ProductDao() {}

  public Product selectOne(int no) throws IOException {
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    
    SqlSession sqlSession = sqlSessionFactory.openSession();

    try {
      return sqlSession.selectOne(
          "java63.assign01.dao.ProductDao.selectOne",
          no /* new Integer(no) => autoboxing */);
    } finally {
      sqlSession.close();
    }
  }
  
  public void update(Product product) throws IOException {
    String resource = "java63/assign01/dao/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      sqlSession.update(
          "java63.assign01.dao.ProductDao.update", product);
      sqlSession.commit();
    } finally {
      sqlSession.close();
    }
  }
  
  public void delete(int no) throws IOException {
    String resource = "java63/assign01/dao/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      sqlSession.delete(
          "java63.assign01.dao.ProductDao.delete", no);
      sqlSession.commit();
    } finally {
      sqlSession.close();
    }
  }

  public List<Product> selectList(int pageNo, int pageSize) throws IOException {
    String resource = "java63/assign01/dao/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    
    SqlSession sqlSession = sqlSessionFactory.openSession();

    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", ((pageNo - 1) * pageSize));
    paramMap.put("pageSize", pageSize);
    try {
      return sqlSession.selectList(
          // 네임스페이스 + SQL문 아이디
          "java63.assign01.dao.ProductDao.selectList",  
          paramMap /* SQL문을 실행할 때 필요한 값 전달 */);
    } finally {
      sqlSession.close();
    }
  }

  public void insert(Product product) throws IOException {
    String resource = "java63/assign01/dao/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      sqlSession.insert(
          "java63.assign01.dao.ProductDao.insert", product);
      sqlSession.commit();
    } finally {
      sqlSession.close();
    }
  }
}




