package java01.test55;

public interface Gamer {
	int WIN = 1;  /* public static final */
	int DRAW = 0;
	int LOSE = -1;
	
	String SCISSORS = "가위";
	String ROCK = "바위";
	String PAPER = "보";
	
	String who();	
	void init();
	String play();
	void sendResult(int result);
	
}
