package beautyChu.service;

import java.util.List;
import beautyChu.dao.MakerDao;
import beautyChu.domain.Maker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MakerService {
  @Autowired MakerDao makerDao;
  
/*  public List<Maker> getList() {
    return makerDao.selectNameList(); 
  }*/
}







