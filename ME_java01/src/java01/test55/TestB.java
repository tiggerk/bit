package java01.test55;

public class TestB implements Gamer {

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
			return Gamer.PAPER;
	}

	@Override
	public void sendResult(int result) {
	}
	
	

}




