package java01.test55;

public class GameCenter {

	public static void main(String[] args) throws Exception {
		Gamer gamerA = (Gamer)Class.forName(System.getProperty("a")).newInstance();
		Gamer gamerB = (Gamer)Class.forName(System.getProperty("b")).newInstance();
		
		String gamerAName = gamerA.who();
		String gamerBName = gamerB.who();

		gamerA.init();
		gamerB.init();
		
		int aScore = 0;
		int bScore = 0;
		int result = 0;
		
		for (int i = 0; i < 100; i++) {
			result = evaluate(gamerA.play(), gamerB.play());
			
			if (result == 1) {
				aScore++; bScore--;
				gamerA.sendResult(Gamer.WIN);
				gamerB.sendResult(Gamer.LOSE);
			} else if (result == -1) {
				aScore--; bScore++;
				gamerA.sendResult(Gamer.LOSE);
				gamerB.sendResult(Gamer.WIN);
			} else {
				gamerA.sendResult(Gamer.DRAW);
				gamerB.sendResult(Gamer.DRAW);
			}
		}
		
		System.out.printf("%s(%d) : %s(%d)", gamerAName, aScore, gamerBName, bScore);

	}

	private static int evaluate(String a, String b) {
		switch(a) {
		case Gamer.SCISSORS:
			if (b.equals(Gamer.PAPER)) return 1;
			else if (b.equals(Gamer.ROCK)) return -1;
			break;
		case Gamer.ROCK:
			if (b.equals(Gamer.SCISSORS)) return 1;
			else if (b.equals(Gamer.PAPER)) return -1;
			break;
		case Gamer.PAPER:
			if (b.equals(Gamer.ROCK)) return 1;
			else if (b.equals(Gamer.SCISSORS)) return -1;
			break;
		}
		return 0;
	}
}
