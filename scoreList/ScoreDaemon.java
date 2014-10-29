package scoreList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreDaemon {
	public static void main(String[] args) throws Exception{

		ScoreManager man = new ScoreManager();

		while(true){
			switch(man.start()){
			case "help": man.help(); break;
			case "list": man.list(); break;
			case "view": man.view(ScoreManager.index); break;
			case "add": man.add(); break;
			case "delete": man.delete(ScoreManager.index); break;
			case "update": man.update(ScoreManager.index); break;
			case "exit": man.exit();
				System.exit(0);
				break;
			default:
			}
		}
	}
}

class Score{
	String name;
	int kor, eng, math, sum;
	float average;
	
	public Score(){}

	public Score(String n, int k, int e, int m){
		name = n;
		kor = k;
		eng = e;
		math = m;
		sum = k + e + m;
		average = sum / 3;
	}
}

class ScoreManager{
	
	static int index;

	ArrayList<Score> record = new ArrayList<Score>();
	Scanner s = new Scanner(System.in);
	Score score;
	
	public ScoreManager() throws Exception{
		BufferedReader in = new BufferedReader(new FileReader("score.dat"));
		
		String s;
		while(true){
			s = in.readLine();
			if ( s == null) break;
			String[] ss = s.split(",");
			record.add(new Score(
					ss[0], 
					Integer.parseInt(ss[1]), 
					Integer.parseInt(ss[2]), 
					Integer.parseInt(ss[3])));
		}
		in.close();
	}

	String start(){
		System.out.print("\n명령> ");
		String[] menu = s.nextLine().split(" ");

		if (menu.length == 5) {
			if (!menu[0].equals("add"))
				return "";
			score = new Score(menu[1], Integer.parseInt(menu[2]),
					Integer.parseInt(menu[3]), Integer.parseInt(menu[4]));

		} else if (menu.length == 2) {
			index = Integer.parseInt(menu[1]);
			if (!(menu[0].equals("view") || menu[0].equals("delete") 
					|| menu[0].equals("update")))
				return "";

		} else if (menu.length == 1) {
			if(!(menu[0].equals("help") || menu[0].equals("list") 
					|| menu[0].equals("exit")))
				return "";
		}	
		return menu[0];
	}

	void help(){
		System.out.println("list");
		System.out.println("view 인덱스");
		System.out.println("add 이름 국어 영어 수학");
		System.out.println("delete 인덱스");
		System.out.println("update 인덱스");
		System.out.println("exit");		
	}

	void list(){
		int i=0;
		for ( Score score : record){
			System.out.println( i++ + " " + score.name + " " + score.kor 
					+ " " + score.eng + " " + score.math);
		}
	}

	void view(int index){
		score = record.get(index);
		System.out.println("인덱스: " + index);
		System.out.println("이름: " + score.name);
		System.out.println("국어: " + score.kor);
		System.out.println("영어: " + score.eng);
		System.out.println("수학: " + score.math);
		System.out.println("합계: " + score.sum);
		System.out.println("평균: " + score.average);
	}

	void add(){
		record.add(score);
		System.out.println("저장되었습니다.");
	}

	void delete(int index){
		if ( record.size() < index + 1 ){
			System.out.println("존재하지 않는 인덱스입니다.");
			return;
		}
		
		score = record.get(index);

		System.out.print(score.name +"의 성적을 삭제하시겠습니까?(y/n) ");		
		
		if (s.nextLine().equalsIgnoreCase("y")) {
			record.remove(index);
			System.out.println("삭제하였습니다.");
		} else System.out.println("삭제 취소하였습니다.");
	}

	void update(int index){
		if ( record.size() < index + 1 ){
			System.out.println("존재하지 않는 인덱스입니다.");
			return;
		}
		score = record.get(index);
		Score buf = new Score(score.name, score.kor, score.eng, score.math);
		
		String in;
		
		System.out.print("이름(" + score.name+ ")? ");
		in = s.nextLine();
		if ( !(in.equals("")))
			buf.name = in;
		
		System.out.print("국어(" + (score.kor) + ")? ");
		in = s.nextLine();
		if ( !in.equals(""))
			buf.kor = Integer.parseInt(in);
		
		System.out.print("영어(" + (score.eng) + ")? ");
		in = s.nextLine();
		if ( !in.equals(""))
			buf.eng = Integer.parseInt(in);
		
		System.out.print("수학(" + (score.math) + ")? ");
		in = s.nextLine();
		if ( !in.equals(""))
			buf.math = Integer.parseInt(in);
		
		System.out.print("정말 변경하시겠습니까?(y/n) ");
		if (s.nextLine().equalsIgnoreCase("y")) {			
			record.set(index, buf);
			System.out.println("변경하였습니다.");
		} else System.out.println("변경 취소하였습니다.");
	}
	void exit() throws Exception{
		FileWriter o = new FileWriter("score.dat");
		
		BufferedWriter out = new BufferedWriter(o);
		
		for ( Score score : record){
			out.write(score.name + "," + score.kor + "," + score.eng + "," + score.math);
			out.newLine();
		}
		out.close();
		o.close();
	}
}

