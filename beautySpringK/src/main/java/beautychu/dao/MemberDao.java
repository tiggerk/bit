package beautychu.dao;

import java.util.Map;

import beautychu.domain.Member;

public interface MemberDao {
	
	Member existUser(Map<String, String> params);
	void insertUser(Member member);
	
	/* Member selectOne(int no); */
	
	  /*Product selectOne(int no);
	  void update(Product product);
	  void delete(int no);
	  List<?> selectList(Map<String,Object> params);
	  void insert(Product product);
	  void insertPhoto(Product product);
	  List<?> selectPhoto(int productNo);
	  void deletePhoto(int productNo);
	  int totalSize();*/

}
