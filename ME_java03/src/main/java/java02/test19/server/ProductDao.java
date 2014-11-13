/* 페이징 처리
 * => DBMS마다 처리하는 방법이 다르다. 
 */
package java02.test19.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java02.test19.server.util.DBConnectionPool;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ProductDao {
  SqlSessionFactory sqlSessionFactory;

  DBConnectionPool dbConnectionPool;
  
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }
  
  public void setDbConnectionPool(DBConnectionPool dbConnectionPool) {
    this.dbConnectionPool = dbConnectionPool;
  }

  public ProductDao() {}

  public Product selectOne(int no) {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      con = dbConnectionPool.getConnection();
      stmt = con.createStatement();
      rs = stmt.executeQuery(
          "SELECT PNO,PNAME,QTY,MKNO FROM PRODUCTS"
          + " WHERE PNO=" + no);
      if (rs.next()) {
        Product product = new Product();
        product.setNo(rs.getInt("PNO"));
        product.setName(rs.getString("PNAME"));
        product.setQuantity(rs.getInt("QTY"));
        product.setMakerNo(rs.getInt("MKNO"));
        return product;
      } else {
        return null;
      }
      
    } catch (Exception ex) {
    //RuntimeException을 던지면 받는 곳에서 굳이 try/catch나 throws를 할 필요가 없다.
      throw new RuntimeException(ex);
      
    } finally {
      try {rs.close();} catch (Exception ex) {}
      try {stmt.close();} catch (Exception ex) {}
      dbConnectionPool.returnConnection(con);
    }
  }
  
  public void update(Product product) {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      con = dbConnectionPool.getConnection();
      stmt = con.prepareStatement(
          "UPDATE PRODUCTS SET PNAME=?,QTY=?,MKNO=? WHERE PNO=?");
      stmt.setString(1, product.getName());
      stmt.setInt(2, product.getQuantity());
      stmt.setInt(3, product.getMakerNo());
      stmt.setInt(4, product.getNo());
      
      stmt.executeUpdate();
      
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException(ex);
      
    } finally {
      try {stmt.close();} catch (Exception ex) {}
      dbConnectionPool.returnConnection(con);
    }
  }
  
  public void delete(int no) {
    Connection con = null;
    Statement stmt = null;
    
    try {
      con = dbConnectionPool.getConnection();
      stmt = con.createStatement();
      stmt.executeUpdate("DELETE FROM PRODUCTS"
          + " WHERE PNO=" + no);

    } catch (Exception ex) {
      ex.getStackTrace();
      throw new RuntimeException(ex);

    } finally {
      try {stmt.close();} catch (Exception ex) {}
      dbConnectionPool.returnConnection(con);
    }
  }

  public List<Product> selectList(int pageNo, int pageSize) {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", ((pageNo - 1) * pageSize));
    paramMap.put("pageSize", pageSize);
    try {
      return sqlSession.selectList(
          // 네임스페이스 + SQL문 아이디
          "java02.test19.server.ProductDao.selectList",  
          paramMap /* SQL문을 실행할 때 필요한 값 전달 */);
    } finally {
      sqlSession.close();
    }
  }

  public void insert(Product product) {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      con = dbConnectionPool.getConnection();
      stmt = con.prepareStatement(
          "INSERT INTO PRODUCTS(PNAME,QTY,MKNO) VALUES(?,?,?)");
      
      // 용어정리: ?를 in-parameter라고 부른다.
      // 인-파라미터의 인덱스는 1부터 시작한다.
      // 순서대로 설정할 필요는 없지만, 프로그래밍의 일관성을 위해 순서대로 입력하라!
      
      stmt.setString(1, product.getName());
      stmt.setInt(2, product.getQuantity());
      stmt.setInt(3, product.getMakerNo());
      
      stmt.executeUpdate();
      
    } catch (Exception ex) {
      throw new RuntimeException(ex);
      
    } finally {
      try {stmt.close();} catch (Exception ex) {}
      dbConnectionPool.returnConnection(con);
    }
  }
}


















