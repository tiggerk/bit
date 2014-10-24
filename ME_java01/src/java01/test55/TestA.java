package java01.test55;

public class TestA implements Gamer {

	int count;

	@Override
	public String who() {
		return "강다혀니현~~~~~@.@";
	}

	@Override
	public void init() {}

	@Override
	public String play() {
		count++;
		if (count == 1 || count == 11 || count == 88)
			return Gamer.PAPER;
		else if (count == 50 || count == 70)
			return Gamer.ROCK;
		else
			return Gamer.SCISSORS;
	}

	@Override
	public void sendResult(int result) {
		if (result == 1)
			System.out.println("오예~ 이겼따 멜롱멜롱~~ ^.^v");
		else if (result == -1)
			System.out.println("루우우우우우우~~~~~~즈...ㅠㅠ");
		else
			System.out.println("비겼다. 다시해");
		
	}
	
	

}




