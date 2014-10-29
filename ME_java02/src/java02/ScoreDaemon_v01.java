package java02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreDaemon_v01 {

	static final int HELP = 0;
	static final int LIST = 1;
	static final int VIEW = 2;
	static final int ADD = 3;
	static final int DELETE = 4;
	static final int UPDATE = 5;
	static final int EXIT = 6;

	public static void main(String[] args) throws Exception{

		ScoreM manager = new ScoreM();

		while(true){
			switch(manager.startDaemon()){
			case HELP:
				manager.displayHelp();
				break;
			case LIST:
				manager.displayList();
				break;
			case VIEW:
				manager.selectView(ScoreM.index);
				break;
			case ADD:
				manager.addScore();
				break;
			case DELETE:
				manager.deleteScore(ScoreM.index);
				break;
			case UPDATE:
				manager.updateScore(ScoreM.index);
				break;
			case EXIT:
				manager.exitDaemon();

				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
		}
	}

}

class ScoreM{

	// Score 클래스가 같은 패키지에 있어서 일단 내부에 넣었다.
	static class Score{
		String name;
		int kor;
		int eng;
		int math;
		int sum;
		float average;

		public Score(){}
		public Score(String name, int kor, int eng, int math){
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
			this.sum = kor + eng + math;
			this.average = sum / 3;
		}
	}

	static int index;

	ArrayList<Score> record = new ArrayList<Score>();
	Scanner scanner = new Scanner(System.in);
	Score score;

	int startDaemon(){
		System.out.print("명령> ");

		int menuNo = 0;

		String[] menu = scanner.nextLine().split(" ");

		if (menu.length == 5 && menu[0].equals("add")) {
			score = new Score(menu[1],
					Integer.parseInt(menu[2]),
					Integer.parseInt(menu[3]),
					Integer.parseInt(menu[4]));

		} else if (menu.length == 2) {
			index = Integer.parseInt(menu[1]);
			if (!(menu[0].equals("view") || menu[0].equals("delete") || menu[0].equals("update"))) {
				startDaemon();
			}

		} else if (menu.length == 1) {
			if(!(menu[0].equals("help") || menu[0].equals("list") || menu[0].equals("exit")))
				startDaemon();
		}

		switch(menu[0]){
		case "help":
			menuNo = 0;
			break;
		case "list":
			menuNo = 1;
			break;
		case "view":
			menuNo = 2;
			break;
		case "add":
			menuNo = 3;
			break;
		case "delete":
			menuNo = 4;
			break;
		case "update":
			menuNo = 5;
			break;
		case "exit":
			menuNo = 6;
			break;
		default:
			menuNo = 0;
		}

		return menuNo;
	}

	void displayHelp(){
		System.out.println("list");
		System.out.println("view 인덱스");
		System.out.println("add 이름 국어 영어 수학");
		System.out.println("delete 인덱스");
		System.out.println("update 인덱스");
		System.out.println("exit");		
	}

	void displayList(){
		for ( int i = 0; i < record.size(); i++){
			score = record.get(i);
			System.out.println( i + " " + score.name + " " + score.kor 
					+ " " + score.eng + " " + score.math);
		}

	}

	void selectView(int index){
		score = record.get(index);
		System.out.println("인덱스: " + index);
		System.out.println("이름: " + score.name);
		System.out.println("국어: " + score.kor);
		System.out.println("영어: " + score.eng);
		System.out.println("수학: " + score.math);
		System.out.println("합계: " + score.sum);
		System.out.println("평균: " + score.average);
	}

	void addScore(){
		record.add(score);
		/*while(true){ 인덱스입니다.
			//System.out.println("저장되었습니다.");



			try{
				String input = scanner.nextLine().trim();
				if(input.equalsIgnoreCase("add")){
					Scanner s2 = new Scanner(input); 
					record.add(new Score(s2.nextLine(), s2.nextInt(), s2.nextInt(), 
							s2.nextInt()));
				}
			}catch(Exception ex){ 
				System.out.println("입력오류 입니다. add 이름 국어 영어 수학 순으로 입력!");
			}

		}//end of while(true)
		 */	} //end of addScore()


	void deleteScore(int index){
		score = record.get(index);

		//record.remove()
		if ( record.size() < index ) {
			System.out.println("존재하지 않는 인덱스입니다.");
		} else {
			System.out.println(score.name +"님을 정말 삭제하시겠습니까? (y/n)");		
			if (scanner.nextLine().equalsIgnoreCase("y")) {
				record.remove(index);
				System.out.println("삭제하였습니다.");
			} else {
				System.out.println("삭제취소하였습니다.");
			}
		}

		/*while(true) {

			try {
				String input = scanner.nextLine().trim();
				if (input.equalsIgnoreCase("delete")) {
					Scanner s2 = new Scanner(input).useDelimiter(" ");

					int length = record.size();
					boolean found = false;

					for (int i = 0; i < length; i++) {
						Score score = (Score)record.get(i);
						if(input.equals(score.name)) {
							found = true;
							break;
						}
					}

					if(found) {
						System.out.println("삭제하였습니다.");
					} else {
						System.out.println("일치하는데이터엄슴");
					}
				} else {
					return;
				}
			} catch (Exception ex) {
				System.out.println("입력오류임 다시 입력하셈");
			}
		}*/
		/*명령> delete 1
		임꺽정의 성적을 삭제하시겠습니까?(y/n) y
		삭제하였습니다.*/


	}

	void updateScore(int index){

	}

	void exitDaemon() throws Exception{
		BufferedWriter out = new BufferedWriter(new FileWriter("score.dat"));
		BufferedReader in = new BufferedReader(new FileReader("score.dat"));



	}
}
