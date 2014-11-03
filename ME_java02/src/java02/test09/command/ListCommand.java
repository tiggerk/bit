package java02.test09.command;

import java.util.Map;

import java02.test09.Score;
import java02.test09.ScoreDao;
import java02.test09.annotation.Command;
import java02.test09.annotation.Component;

@Component("list")
public class ListCommand {
  // 총괄 관리자로부터 의존 객체를 주입 받고 싶으면, setter메서드를 준비하라.
  ScoreDao scoreDao;

  // 이 메서드는 Test01이 호출한다.
  public void setScoreDao(ScoreDao scoreDao) {
    this.scoreDao = scoreDao;
  }
 
  @Command
  public void doList(Map<String, Object> params) throws Exception {
    
    int index = 0;
    for (Score score : scoreDao.getList()) {
      System.out.printf("%-3d %-10s %3d %3d %3d\n", 
          index, score.getName(), score.getKor(), 
          score.getEng(), score.getMath());
      index++;
    }
  }
}


