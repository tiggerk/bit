/* update 명령 처리
 */

package java02.test03;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Test11 {
	static Scanner scanner;
	static ArrayList<Score> list = new ArrayList<Score>();

	static class Score implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		String name;
		int kor;
		int eng;
		int math;
		int sum;
		float average;

		public Score() {
		}

		public Score(String name, int kor, int eng, int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
	}

	public static void main(String[] args) {

		scanner = new Scanner(System.in);

		loop: 
			while (true) {
			try {
				String[] token = promptCommand();

				switch (token[0]) {
				case "add":
					doAdd(token);
					break;
				case "list":
					doList();
					break;
				case "view":
					doView(Integer.parseInt(token[1]));
					break;
				case "delete":
					doDelete(Integer.parseInt(token[1]));
					break;
				case "update":
					doUpdate(Integer.parseInt(token[1]));
					break;
				case "help":
					doHelp();
					break;
				case "exit":
					System.out.println("파일에 저장하였습니다.");
					break loop;
				default:
					System.out.println("이 명령어를 지원하지 않는단 말야ㅡㅡ");
				}
			} catch (Exception e) {
				// e.printStackTrace(); //예외의 흐름 보기
				System.out.println("명령어 처리 중 오류 발생. 다시 시도해주세요.");
			}
		}
		scanner.close();
	} // end of main()

	private static void doUpdate(int index) {
		if (!isValid(index)) return;
		
		Score score = list.get(index);
		Score tempScore = new Score(
				score.name, score.kor, score.eng, score.math);
		
		String text = null;
		System.out.printf("이름(%s): ", score.name);
		text = scanner.nextLine();
		if (text.length() > 0)
			tempScore.name = text;
		
		System.out.printf("국어(%d): ", score.kor);
		text = scanner.nextLine();
		if (text.length() > 0)
			tempScore.kor = Integer.parseInt(text);
		
		System.out.printf("영어(%d): ", score.eng);
		text = scanner.nextLine();
		if (text.length() > 0)
			tempScore.eng = Integer.parseInt(text);
		
		System.out.printf("수학(%d): ", score.math);
		text = scanner.nextLine();
		if (text.length() > 0)
			tempScore.math = Integer.parseInt(text);
		
		System.out.println("정말로 변경하시겠습니까?(y/n) ");
		if (scanner.nextLine().equalsIgnoreCase("y")) {
			list.set(index, tempScore);
			System.out.println("변경하였습니다~!");
		} else {
			System.out.println("변경 취소하였습니다!!!!!!!");
		}
	} //end of doUpdate()

	private static boolean isValid (int index) {
		if (index < 0 || index >= list.size()) {
			System.out.println("존재하지 않는 인덱스입니다.");
			return false;
		} else {
			return true;
		}
	}
	
	private static void doView(int index) {
		if (!isValid(index)) {
			return;
		}
		
		Score score = list.get(index);
		
		System.out.println("인덱스: " + index);
	    System.out.println("이름: " + score.name);
	    System.out.println("국어: " + score.kor);
	    System.out.println("영어: " + score.eng);
	    System.out.println("수학: " + score.math);
	    System.out.println("총점: " + score.sum);
	    System.out.println("평균: " + score.average);
	} //end of doView()

	private static void doDelete(int index) {
		if (!isValid(index)) {
			return;
		}
		
		Score score = list.get(index);
		
		System.out.print(score.name + "의 성적을 삭제하시겠습니까?(y/n) ");
		if (scanner.nextLine().equalsIgnoreCase("y")) {
			list.remove(index);
			System.out.println("삭제하였습니다.");
		} else {
			System.out.println("삭제 취소하였습니다.");
		}
	} //end of doDelete()

	private static void doList() {
		int index = 0;
		for (Score score : list) {
			System.out.printf("%-3d %-10s %3d %3d %3d\n", index, score.name,
					score.kor, score.eng, score.math);
			index++;
		}
	} //end of doList()

	private static void doHelp() {
		System.out.println("list");
		System.out.println("view 인덱스");
		System.out.println("add 이름 국어 영어 수학");
		System.out.println("delete 인덱스");
		System.out.println("update 인덱스");
		System.out.println("exit");
	}

	private static void doAdd(String[] token) {
		Score score = new Score(token[1],
				Integer.parseInt(token[2]),
				Integer.parseInt(token[3]),
				Integer.parseInt(token[4]));
		
		list.add(score);
		System.out.println("저장하였습니다.");
	} //end of doAdd()

	private static String[] promptCommand() {
		System.out.print("명령 > ");
		String[] token = scanner.nextLine().split(" ");
		return token;
	}

}
