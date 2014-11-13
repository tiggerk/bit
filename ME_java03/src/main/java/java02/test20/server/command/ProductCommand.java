package java02.test20.server.command;

import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;
import java02.test20.server.Member;
import java02.test20.server.MemberDao;
import java02.test20.server.annotation.Command;
import java02.test20.server.annotation.Component;

@Component
public class MemberCommand {
  MemberDao memberDao;
  Scanner scanner;
  
  public void setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
  }
  
  public void setScanner(Scanner scanner) {
    this.scanner = scanner;
  }
  
  @Command("add")
  public void add(Map<String, Object> params) {
    PrintStream out = (PrintStream)params.get("out");
    
    try {
      Member member = new Member();
      member.setName((String)params.get("name"));
      member.setQuantity(Integer.parseInt((String)params.get("qty")));
      member.setMakerNo(Integer.parseInt((String)params.get("mkno")));
      
      memberDao.insert(member);
      out.println("저장하였습니다.");
      out.println();
      
    } catch (Exception e) {
      e.printStackTrace();
      out.println("서버가 바쁩니다. 잠시 후 다시 시도하세요.");
      out.println();
    }
  }
  
  @Command("delete")
  public void delete(Map<String, Object> params) {
    PrintStream out = (PrintStream)params.get("out");
    
    Member member = memberDao.selectOne(Integer.parseInt((String)params.get("no")));
    
    if (member == null) {
      System.out.println("해당 번호의 제품 정보를 찾을 수 없습니다.");
      return;
    }
    
    memberDao.delete(Integer.parseInt((String)params.get("no")));
    out.println("삭제하였습니다.");
    out.println();
  }
  
  @Command("list")
  public void list(Map<String, Object> params) {
    int pageNo = 0;
    int pageSize = 0;
    
    if (params.get("pageNo") != null) {
      pageNo = Integer.parseInt((String)params.get("pageNo"));
      pageSize = 3;
    }
    
    if (params.get("pageSize") != null) {
      pageSize = Integer.parseInt((String)params.get("pageSize"));
    }
    
    PrintStream out = (PrintStream)params.get("out");
    
    for (Member member : memberDao.selectList(pageNo, pageSize)) {
      out.printf("%-3d %-20s %7d %-3d\n", 
          member.getNo(), 
          member.getName(), 
          member.getQuantity(), 
          member.getMakerNo());
    }
    out.println();
  }
  
  @Command("update")
  public void update(Map<String, Object> params) {
    PrintStream out = (PrintStream)params.get("out");
    

    try {
      Member member = new Member();
      member.setNo(Integer.parseInt((String)params.get("no")));
      member.setName((String)params.get("name"));
      member.setQuantity(Integer.parseInt((String)params.get("qty")));
      member.setMakerNo(Integer.parseInt((String)params.get("mkno")));

      memberDao.update(member);
      out.println("변경하였습니다.");
      out.println();

    } catch (Exception e) {
      e.printStackTrace();
      out.println("서버가 바쁩니다. 잠시 후 다시 시도하세요.");
      out.println();
    }
  }
  
  @Command("view")
  public void view(Map<String, Object> params) throws Exception {
    PrintStream out = (PrintStream)params.get("out");
    
    Member member = memberDao.selectOne(Integer.parseInt((String)params.get("no")));
    
    if (member == null) {
      out.println("해당 번호의 제품 정보를 찾을 수 없습니다.");
      out.println();
      return;
    }
    
    out.println("제품번호: " + (String)params.get("no"));
    out.println("제품명: " + member.getName());
    out.println("수량: " + member.getQuantity());
    out.println("제조사 번호: " + member.getMakerNo());
    out.println();
  }
}








