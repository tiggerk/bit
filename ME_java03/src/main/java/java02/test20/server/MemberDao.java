/* 페이징 처리
 * => DBMS마다 처리하는 방법이 다르다. 
 */
package java02.test20.server;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MemberDao {
  
  SqlSessionFactory sqlSessionFactory;
  
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }
  
  public MemberDao() {}

  public Member selectOne(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    try {
      return sqlSession.selectOne(
          "java02.test20.server.MemberDao.selectOne",
          no /* new Integer(no) => autoboxing */);
    } finally {
      sqlSession.close();
    }
  }
  
  public void update(Member member) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      sqlSession.update(
          "java02.test20.server.MemberDao.update", member);
      sqlSession.commit();
    } finally {
      sqlSession.close();
    }
  }
  
  public void delete(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      sqlSession.delete(
          "java02.test20.server.MemberDao.delete", no);
      sqlSession.commit();
    } finally {
      sqlSession.close();
    }
  }

  public List<Member> selectList(int pageNo, int pageSize) {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", ((pageNo - 1) * pageSize));
    paramMap.put("pageSize", pageSize);
    try {
      return sqlSession.selectList(
          // 네임스페이스 + SQL문 아이디
          "java02.test20.server.MemberDao.selectList",  
          paramMap /* SQL문을 실행할 때 필요한 값 전달 */);
    } finally {
      sqlSession.close();
    }
  }

  public void insert(Member member) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      sqlSession.insert(
          "java02.test20.server.MemberDao.insert", member);
      sqlSession.commit();
    } finally {
      sqlSession.close();
    }
  }
}




