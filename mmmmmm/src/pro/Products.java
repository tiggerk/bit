package pro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Products {
  Connection con = null;
  Scanner scanner;
  Statement stmt = null;
  
  public void init() {
    try {
      Class.forName("com.mysql.jdbc.Driver");

      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/studydb", 
          "study",
          "study");
      System.out.println("DBMS에 연결됨");

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  } // end of init
  
  private String[] promptCommand() {
    System.out.print("명령>");
    String[] token = scanner.nextLine().split(" ");
    return token;
  }
  
  public void menu() {

    loop:
      while (true) {
        try {
          String[] token = promptCommand();

          switch (token[0]) {
          case "add":
            System.out.println("add입니다.");
            doAdd();
            break;
          case "list":
            System.out.println("list입니다.");
            doList();
            break;
          case "update":
            System.out.println("update입니다.");
            break;
          case "delete":
            System.out.println("delete입니다.");
            doDelete(Integer.parseInt(token[1]));
            break;
          case "exit":
            break loop;
          default:
            System.out.println("잘못누름");
            break;
          }
        } catch (Exception e) {}
      }
  } // end of menu

  private void doList() {
    ResultSet rs;

    try {
      stmt = con.createStatement();
      rs = stmt.executeQuery(
          "SELECT P.PNO, P.PNAME, P.QTY, M.MKNAME FROM PRODUCTS P, MAKERS M" +
          "WHERE P.PNO = M.PNO");
      while (rs.next()) {
          System.out.printf("%-3d %-10s %3d %3d %3d\n", 
              rs.getString("P.PNO"),
              rs.getString("P.PNAME"),
              rs.getString("P.QTY"),
              rs.getString("M.MKNAME"));
        }
    } catch (Exception ex) {}
  } // end of doList

  private void doDelete(int index) {
    String scan;
    ResultSet rs;

    try {
      stmt = con.createStatement();
      rs = stmt.executeQuery("SELECT PNAME FROM PRODUCTS" +
          "WHERE PNO="+index+";");
      
      System.out.println(rs.getString("PNAME") + "를 삭제하시겠습니까?(y/n)");
      scan = scanner.nextLine();

      if (scan.equalsIgnoreCase("y")) {
        stmt.executeUpdate("DELETE FROM PRODUCTS" +
            " WHERE PNO IN(" + index + ")");
        System.out.println("삭제 완료하였습니다.");
        
      } else {
        System.out.println("삭제 취소하였습니다.");
      }

    } catch (Exception ex) {
      ex.printStackTrace();
    }

  }

  private void doAdd() {
    String pname;
    int qty;
    int mkno;
    String scan;
    
    try {
      System.out.println("제품명 :");
      pname = scanner.nextLine();
      
      System.out.println("수량 :");
      qty = scanner.nextInt();
      
      System.out.println("제조사 :");
      mkno = scanner.nextInt();
            
      System.out.println("저장하시겠습니까?(y/n)");
      scan = scanner.nextLine();
      
      if (scan.equalsIgnoreCase("y")) {
        stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO PRODUCTS(PNAME,QTY,MKNO)" +
            " VALUES('"+pname+"',"+qty+","+mkno+")");
      } else {
        System.out.println("저장 취소하였습니다.");
      }
      
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void destroy() {
    try {con.close();} catch (Exception ex) {}
    System.out.println("DBMS와 연결 끊음");
    try {scanner.close();} catch (Exception ex) {}

  } // end of destroy

}
