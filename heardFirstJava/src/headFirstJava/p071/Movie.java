package headFirstJava.p071;

public class Movie {

	String title;
	String genre;
	int rating;
	
	void playIt() {
		System.out.println("---------------------");
		System.out.println("영화를 상영합니다.");
		System.out.println(title);
		System.out.println(genre);
		System.out.println(rating);
	}

}
