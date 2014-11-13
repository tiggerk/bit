package java02.test16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
  public MemberDao() {}

  public Member selectOne(String id) {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/studydb", 
          "study", 
          "study");
      stmt = con.createStatement();
      rs = stmt.executeQuery(
          "SELECT * FROM MEMBERS"
          + " WHERE UID='" + id + "'");
      
      if (rs.next()) {
        Member member = new Member();
        member.setId(rs.getString("UID"));
        member.setPwd(rs.getString("PWD"));
        member.setEmail(rs.getString("EMAIL"));
        member.setName(rs.getString("UNAME"));
        member.setTel(rs.getString("TEL"));
        member.setFax(rs.getString("FAX"));
        member.setAddr(rs.getString("DET_ADDR"));
        member.setPhoto(rs.getString("PHOT"));
        member.setAddrNo(rs.getInt("ANO"));
        return member;
      } else {
        return null;
      }
      
    } catch (Exception ex) {
      throw new RuntimeException(ex);
      
    } finally {
      try {rs.close();} catch (Exception ex) {}
      try {stmt.close();} catch (Exception ex) {}
      try {con.close();} catch (Exception ex) {}
    }
  }
  
  public void update(Member member) {
    Connection con = null;
    Statement stmt = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/studydb" + 
            "?useUnicode=true&characterEncoding=utf8", 
          "study",
          "study");
      stmt = con.createStatement();
      stmt.executeUpdate("UPDATE MEMBERS SET"
          + " PWD='" + member.getPwd()
          + "', EMAIL='" + member.getEmail()
          + "', UNAME='" + member.getName()
          + "', TEL='" + member.getTel()
          + "', FAX='" + member.getFax()
          + "', DET_ADDR='" + member.getAddr()
          + "', PHOT='" + member.getPhoto()
          + "', ANO=" + member.getAddrNo()
          + " WHERE UID='" + member.getId() + "'");
      
    } catch (Exception ex) {
      throw new RuntimeException(ex);
      
    } finally {
      try {stmt.close();} catch (Exception ex) {}
      try {con.close();} catch (Exception ex) {}
    }
  }
  
  public void delete(String id) {
    Connection con = null;
    Statement stmt = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/studydb" + 
            "?useUnicode=true&characterEncoding=utf8", 
          "study",
          "study");
      stmt = con.createStatement();
      stmt.executeUpdate("DELETE FROM MEMBERS"
          + " WHERE UID='" + id + "'");
      
    } catch (Exception ex) {
      throw new RuntimeException(ex);
      
    } finally {
      try {stmt.close();} catch (Exception ex) {}
      try {con.close();} catch (Exception ex) {}
    }
  }
  
  public List<Member> selectList() {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/studydb", 
          "study", 
          "study");
      stmt = con.createStatement();
      rs = stmt.executeQuery(
          "SELECT UID,UNAME,EMAIL,TEL FROM MEMBERS");
      
      ArrayList<Member> list = new ArrayList<Member>();
      Member member = null;
      
      while (rs.next()) {
        member = new Member();
        member.setId(rs.getString("UID"));
        member.setName(rs.getString("UNAME"));
        member.setEmail(rs.getString("EMAIL"));
        member.setTel(rs.getString("TEL"));
        list.add(member);
      }
      
      return list;
      
    } catch (Exception ex) {
      throw new RuntimeException(ex);
      
    } finally {
      try {rs.close();} catch (Exception ex) {}
      try {stmt.close();} catch (Exception ex) {}
      try {con.close();} catch (Exception ex) {}
    }
  }
  
  public void insert(Member member) {
    Connection con = null;
    Statement stmt = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/studydb" + 
            "?useUnicode=true&characterEncoding=utf8", 
          "study",
          "study");
      stmt = con.createStatement();
      stmt.executeUpdate("INSERT INTO MEMBERS(UID, PWD, EMAIL, UNAME, TEL, FAX, DET_ADDR, PHOT, ANO)" +
        " VALUES('" + member.getId()
        + "','" + member.getPwd()
        + "','" + member.getEmail()
        + "','" + member.getName()
        + "','" + member.getTel()
        + "','" + member.getFax()
        + "','" + member.getAddr()
        + "','" + member.getPhoto()
        + "'," + member.getAddrNo() + ")");
    } catch (Exception ex) {
      throw new RuntimeException(ex);
      
    } finally {
      try {stmt.close();} catch (Exception ex) {}
      try {con.close();} catch (Exception ex) {}
    }
  }
}








