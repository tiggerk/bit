package pro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Products {
	Connection con = null;
	Scanner scanner;
	Statement stmt = null;

	public String promptCommand(Scanner scanner) {
		System.out.print("명령 > ");

		String scan = scanner.nextLine();
		return scan;
	}
	
	/*
	private String[] promptCommand() {
	    System.out.print("명령>");
	    String[] token = scanner.nextLine().split(" ");
	    return token;
	  }
	  */

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

	public void menu() {
		scanner = new Scanner(System.in);

		loop:
			while (true) {
				try {
					String scan = promptCommand(scanner);

					switch (scan) {
					case "add":
						System.out.println("add입니다.");
						add();
						break;
					case "list":
						System.out.println("list입니다.");
						break;
					case "update":
						System.out.println("update입니다.");
						break;
					case "delete":
						System.out.println("delete입니다.");
						delete();
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

	private void delete() {
		String scan;

		try {
			System.out.println(아이폰6플러스 + "를 삭제하시겠습니까?(y/n)");
			scan = scanner.nextLine();

			if (scan.equalsIgnoreCase("y")) {
				stmt = con.createStatement();
				stmt.executeUpdate("DELETE FROM PRODUCTS" +
						" WHERE PNO IN("+아이폰6플러스번호+")");
			} else {
				System.out.println("저장 취소하였습니다.");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void add() {
		String pno;
		int qty;
		int mkno;
		String scan;

		try {
			System.out.println("제품명 :");
			pno = scanner.nextLine();

			System.out.println("수량 :");
			qty = scanner.nextInt();

			System.out.println("제조사 :");
			mkno = scanner.nextInt();

			System.out.println("저장하시겠습니까?(y/n)");
			scan = scanner.nextLine();

			if (scan.equalsIgnoreCase("y")) {
				stmt = con.createStatement();
				stmt.executeUpdate("INSERT INTO PRODUCTS(PNO,QTY,MKNO)" +
						" VALUES('"+pno+"',"+qty+","+mkno+")");
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
