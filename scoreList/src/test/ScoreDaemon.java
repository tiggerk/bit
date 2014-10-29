package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import test.ScoreManager.Score;

public class ScoreDaemon {
	
	public static void main(String[] args) throws Exception{
		
		FileInputStream in = new FileInputStream("score.dat");
		ObjectInputStream in2 = new ObjectInputStream(in);
		
		ScoreManager.record = (ArrayList<Score>) in2.readObject();
		
		
		/*
		FileReader fr = new FileReader("score.dat");
		BufferedReader br = new BufferedReader(fr);
		
		String s = null;
		
		while((s=br.readLine()) != null) {
			
		}
		*/
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
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
			break;
			default:
			}
		}
	}
}

class ScoreManager{
	
	static class Score implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		String name;
		int kor, eng, math, sum;
		float average;

		public Score(String n, int k, int e, int m){
			name = n;
			kor = k;
			eng = e;
			math = m;
			sum = k + e + m;
			average = sum / 3;
		}
	}

	static int index;

	static ArrayList<Score> record = new ArrayList<Score>();
	Scanner s = new Scanner(System.in);
	Score score;

	String start(){
		System.out.print("명령> ");
		String[] menu = s.nextLine().split(" ");

		if (menu.length == 5) {
			if (!menu[0].equals("add"))
				return "";
			score = new Score(menu[1], Integer.parseInt(menu[2]),
					Integer.parseInt(menu[3]), Integer.parseInt(menu[4]));

		} else if (menu.length == 2) {
			index = Integer.parseInt(menu[1]);
			if (!(menu[0].equals("view") || menu[0].equals("delete") || menu[0].equals("update"))) {
				return "";
			}

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

	} //end of add()


	void delete(int index){
		score = record.get(index);

		if ( record.size() < index ) {
			System.out.println("존재하지 않는 인덱스입니다.");
		} else {
			System.out.println(score.name +"님을 정말 삭제하시겠습니까? (y/n)");		
			if (s.nextLine().equalsIgnoreCase("y")) {
				record.remove(index);
				System.out.println("삭제하였습니다.");
			} else {
				System.out.println("삭제취소하였습니다.");
			}
		}

	}

	void update(int index) throws Exception{
		score = record.get(index);
		Scanner s = new Scanner(System.in);
		String name;
		int kor;
		int eng;
		int math;
		
		
		System.out.println("이름(" + score.name+ ")? ");
		if ((name = s.nextLine()).equals(""))
			name = score.name;
		else;
	
		System.out.println("국어(" + score.kor + ")? ");
		String sss = s.nextLine();
		if ( sss.equals("") ){
			kor = score.kor;
		}else{ 
			kor = Integer.parseInt(sss);
		}
		
		System.out.println("영어(" + score.eng + ")? ");
		String sss2 = s.nextLine();
		
		if ( sss2.equals("") ){
			eng = score.eng;
		} else {
			eng = Integer.parseInt(sss2);
		}
		
		System.out.println("수학(" + score.math + ")? ");
		String sss3 = s.nextLine();
		if ( sss3.equals("") ) {
			math = score.math;
		} else {
			math = Integer.parseInt(sss3);
		}
		
		System.out.println("정말 변경하시겠습니까?(y/n)");
		if (s.nextLine().equalsIgnoreCase("y")) {
			score.name = name;
			score.kor = kor;
			score.eng = eng;
			score.math = math;
		} else {
			System.out.println("변경 취소 되었습니다.");
		}

		//record.set(index, score);
	}

	
	void exit() throws Exception{
		
		FileOutputStream out = new FileOutputStream("score.dat");
		ObjectOutputStream out2 = new ObjectOutputStream(out);
		
		out2.writeObject(record);
		/*
		for (int i = 0; i < record.size(); i++) {
			Score score = record.get(i);
			out2.writeUTF(score.name);
			out2.writeInt(score.kor);
			out2.writeInt(score.eng);
			out2.writeInt(score.math);
		}
		*/
		out2.close();
		out.close();
		
		
		/*
		BufferedWriter out = new BufferedWriter(new FileWriter("score.dat"));
		BufferedReader in = new BufferedReader(new FileReader("score.dat"));
		
		for (int i = 0; i < record.size(); i++) {
			Score score = record.get(i);
		*/	
		}
	}
