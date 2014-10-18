package headFirstJava.p071;

public class MovieTestDrive {

	public static void main(String[] args) {
		Movie one = new Movie();
		one.title = "주식과 함께 사라지다";
		one.genre = "비극";
		one.rating = -2;
		
		
		Movie two = new Movie();
		two.title = "로스트 인 큐비클 스페이스";
		two.genre = "코미디";
		two.rating = 5;
		two.playIt();
		
		Movie three = new Movie();
		three.title = "바이트 클럽";
		three.genre = "기분이 좋아지는 비극";
		three.rating = 127;
		
		one.playIt();
		three.playIt();

	}

}
