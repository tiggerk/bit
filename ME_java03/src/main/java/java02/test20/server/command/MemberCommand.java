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
      member.setId((String)params.get("id"));
      member.setPwd((String)params.get("pwd"));
      member.setEmail((String)params.get("email"));
      member.setName((String)params.get("name"));
      member.setTel((String)params.get("tel"));
      member.setFax((String)params.get("fax"));
      member.setAddr((String)params.get("addr"));
      member.setPhoto((String)params.get("photo"));
      member.setAddrNo(Integer.parseInt((String)params.get("addrNo")));
      
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
    
    Member member = memberDao.selectOne((String)params.get("id"));
    
    if (member == null) {
      System.out.println("해당 아이디의 정보를 찾을 수 없습니다.");
      return;
    }
    
    memberDao.delete((String)params.get("id"));
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
      out.printf("%-5s %-5s %10s %-10s\n", 
          member.getId(), 
          member.getName(), 
          member.getEmail(), 
          member.getTel());
    }
    out.println();
  }
  
  @Command("update")
  public void update(Map<String, Object> params) {
    PrintStream out = (PrintStream)params.get("out");
    

    try {
      Member member = new Member();
      member.setId((String)params.get("id"));
      member.setPwd((String)params.get("pwd"));
      member.setEmail((String)params.get("email"));
      member.setName((String)params.get("name"));
      member.setTel((String)params.get("tel"));
      member.setFax((String)params.get("fax"));
      member.setAddr((String)params.get("addr"));
      member.setPhoto((String)params.get("photo"));
      member.setAddrNo(Integer.parseInt((String)params.get("addrNo")));

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
    
    Member member = memberDao.selectOne((String)params.get("id"));
    
    if (member == null) {
      out.println("해당 아이디의 정보를 찾을 수 없습니다.");
      out.println();
      return;
    }
    
    out.println("아이디: " + params.get("id"));
    out.println("비밀번호: " + member.getPwd());
    out.println("이메일: " + member.getEmail());
    out.println("이름: " + member.getName());
    out.println("전화번호: " + member.getTel());
    out.println("팩스: " + member.getFax());
    out.println("주소: " + member.getAddr());
    out.println("사진: " + member.getPhoto());
    out.println("우편번호: " + member.getAddrNo());
    out.println();
  }
}








