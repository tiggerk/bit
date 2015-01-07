package beautychu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beautychu.dao.StylePhotoDao;

@Service
public class StylePhotoService {
  @Autowired StylePhotoDao stylePhotoDao;
  
  public List<?> getList(int no) {
    return stylePhotoDao.getList(no); 
  }
}







