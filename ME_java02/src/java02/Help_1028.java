package java02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Help_1028 {
	static ArrayList<Student2> list = new ArrayList<Student2>();
	static Scanner s = new Scanner(System.in);
	String keyword = s.nextLine();
	public static void main(String[] args) {
		while(true){
			switch(){
			case 1 :
				inputRecord();
				break;
			case 2 :
				deleteRecord();
				break;
			case 3 :
				//sortRecord();
				break;
			/*case "exit" :
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);*/
			}
		} 

	}

/*	
	static int displayMenu() { 
		
	}
*/
	
	//menu를 보여주는 메서드
	static int displayHelp(){
		System.out.println("list");
		System.out.println("view 인덱스");
		System.out.println("add 이름 국어 영어 수학");
		System.out.println("delete 인덱스");
		System.out.println("update 인덱스");
		System.out.println("exit");
		System.out.println("원하는 메뉴를 선택하세요.(1~4)  : ");
		int menu = 0;

		do{
			try {
				menu = Integer.parseInt(s.nextLine().trim());

				if(menu >= 1 && menu <= 4){
					break;
				} else {
					throw new Exception();
				}
			} catch(Exception e){
				System.out.println("메뉴를 잘못 선택하셨습니다. 다시 입력해주세요.");
				System.out.print("원하는 메뉴를 선택하세요 . (1~4) : ");
			}
		} while(true);

		return menu;
	} // public static int displayMenu()
	
	
	//데이터를 입력받는 메서드
	static void inputRecord() {
		System.out.println(" 1. 주소록 입력하기 ");
		System.out.println("이름,주소 ,전화번호,생일,나이의 순서로 공백없이 입력하세요.");
		System.out.println("입력을 마치려면 q를 입력하세요. 메인화면으로 돌아갑니다.");

		while(true){
			System.out.print("명령>");

			try{
				String input = s.nextLine().trim();

				if(!input.equalsIgnoreCase("q")){
					Scanner s2 = new Scanner(input).useDelimiter(",");

					list.add(new Student2(s2.next(), s2.next(), s2.next(), 
							s2.next(), s2.nextInt()));
					System.out.println("잘입력되었습니다. 입력을 마치려면 q를 입력하세요.");

				} else {
					return;
				}
			}catch(Exception e){ 
				System.out.println("입력오류 입니다. 이름,주소 ,전화번호,생일,나이의 순서로 공백없이 입력하세요.");
			}

		}//end of while(true)
	} // public static void inputRecord() {
	//데이터를 삭제하는 메서드
	static void deleteRecord() {
		while(true){
			displayRecord();

			System.out.println(" 2. 주소록 삭제하기(q:메인화면)");
			System.out.println(">>");

			try{
				String input = s.nextLine().trim();

				if(!input.equalsIgnoreCase("q")) {
					int length = list.size();
					boolean found = false;

					for(int i=0; i < length; i++){
						Student2 student = (Student2)list.get(i);
						if(input.equals(student.address)){
							found = true;
							list.remove(i);
							break;
						}
					}//for(int i=0;i<length;i+++){

					if(found) {
						System.out.println("삭제되었습니다.");
					} else {
						System.out.println("일치하는 데이터가 없습니다.");
					}

				} else {
					return;
				}

			}catch(Exception e){
				System.out.println("입력오류입니다. 다시 입력해 주세요.");
			}

		}//end of while(true)
	}//public static void deleteRecord() {

	
	//데이터 목록을 보여주는 메서드
	static void displayRecord(){

		String tel = null;
		String birth = null;
		String age = null;

		System.out.println();
		System.out.println("이름        주소        전화번호       생일       나이");
		System.out.println("==================================");


		int length = list.size();

		if(length > 0) {
			for(int i = 0; i < length ; i++){
				Student2 student = (Student2)list.get(i);
				System.out.println(student);
			}
		}else{
			System.out.println();
			System.out.println("데이터가 없습니다.");
			System.out.println();
		}


		System.out.println("======================================");
		/*System.out.println(
				+Student2.format(tel+"",11,Student2.RIGHT)
				+Student2.format(birth+"",6,Student2.RIGHT)
				+Student2.format(age+"",6,Student2.RIGHT)
				);*/
		System.out.println();
	}//static void displayRecord() {
} // end of class

class Student2 implements Comparable<Object> {
	final static int LEFT = 0;
	final static int CENTER = 1;
	final static int RIGHT = 2;

	String name = "";
	String address = "";
	String tel = "";
	String birth = "";
	int age = 0;


	Student2(String name, String address, String tel, String birth, int age){

		this.name = name;
		this.address = address;
		this.tel = tel;
		this.birth = birth;
		this.age = age;

	}

	
	public String toString() {
		return format(name , 4, LEFT)
				+format(address, 4, RIGHT)
				+format(""+tel,6,RIGHT)
				+format(""+birth,6,RIGHT)
				+format(""+age,6,RIGHT);

	}

	static String format(String str,int length, int alignment) {
		int diff = length - str.length();
		if(diff < 0) return str.substring(0,length);

		char [] source = str.toCharArray();
		char [] result = new char[length];


		for(int i=0; i < result.length; i++)
			result[i] = ' ' ;

		switch(alignment){
		case CENTER :
			System.arraycopy(source, 0, result, diff/2, source.length);
			break;
		case RIGHT :
			System.arraycopy(source, 0, result, diff, source.length);
			break;
		case LEFT :
		default :
			System.arraycopy(source, 0, result, 0, source.length);
		}
		return new String(result);
	}
	public int compareTo(Object obj) {
		int result = -1;
		if(obj instanceof Student2){
			Student2 tmp = (Student2)obj;
			result = (this.name).compareTo(tmp.name);
		}
		return result;
	}
}//class Student2 implements Comparable{