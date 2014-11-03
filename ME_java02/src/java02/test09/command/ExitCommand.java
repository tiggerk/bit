package java02.test09.command;

import java.util.Map;

import java02.test09.ScoreDao;
import java02.test09.annotation.Command;
import java02.test09.annotation.Component;

@Component("exit")
public class ExitCommand{
  ScoreDao scoreDao;

  // 이 메서드는 Test01이 호출한다.
  public void setScoreDao(ScoreDao scoreDao) {
    this.scoreDao = scoreDao;
  }


  @Command
  public void doExit(Map<String, Object> params) throws Exception {
    try {
      scoreDao.save();
    } catch (Exception e) {
      System.out.println("데이터 저장 중 오류가 발생했습니다.");
    }
  }
}










