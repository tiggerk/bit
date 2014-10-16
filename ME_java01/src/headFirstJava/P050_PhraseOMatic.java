package headFirstJava;

public class P050_PhraseOMatic {

	public static void main(String[] args) {
		
		// 세 종류의 단어 목록을 만든다.
		String[] wordListOne = {
				"24/7", "multi-Tier", "30,000 foot", "B-to-B",
				"win-win", "front-end", "web-based", "pervasive", "smart",
				"six-sigma", "critical-path", "dynamic"
		};
		
		String[] wordListTwo = {
			"empowered", "sticky", "valued-added", "oriented", "centric",
			"distributed", "clustered", "branded", "outside-the-box", "positioned",
			"networked", "focused", "leveraged", "aligned", "targeted", "shared",
			"cooperative", "accelerated"
		};
		
		String[] wordListThree = {
			"process", "tipping-point", "solution", "architecture", "core competency",
			"strategy", "mindshare", "portal", "space", "vision", "paradigm", "mission"
		};
		
		// 각 단어 목록에 단어가 몇 개씩 들어있는지 확인한다.
		int oneLength = wordListOne.length;
		int twoLength = wordListTwo.length;
		int threeLength = wordListThree.length;
		
		// 난수 세 개를 발생시킵니다.
		int rand1 = (int) (Math.random() * oneLength);
		//System.out.println(rand1);
		int rand2 = (int) (Math.random() * twoLength);
		int rand3 = (int) (Math.random() * threeLength);
		
		// 이제 구문을 만듭니다.
		String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3];
		
		// 구문을 출력합니다.
		System.out.println("What we need is a " + phrase);

	}

}
