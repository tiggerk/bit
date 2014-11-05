package headFirstJava.p072_74;

public class GuessGame {
	// GuessGame에는 Player 객체 세 개를 저장하기 위한
	// 인스턴스 변수 세 개가 있습니다.
	Player p1;
	Player p2;
	Player p3;
	
	public void startGame() {
		// Player객체 세 개를 생성하고 각각을
		// Player 인스턴스 변수 세개에 대입합니다.
		p1 = new Player();
		p2 = new Player();
		p3 = new Player();
		
		// Player 객체 세 개에서 찍은 숫자를
		// 저장하기 위해 변수 세 개를 선언합니다.
		int guessp1 = 0;
		int guessp2 = 0;
		int guessp3 = 0;
		
		// 세 선수가 찍은 숫자가 맞는지 여부를
		// 저장하기 위해 변수 세 개를 선언합니다.
		boolean p1isRight = false;
		boolean p2isRight = false;
		boolean p3isRight = false;
		
		// 선수들이 맞출 숫자를 만듭니다.
		int targetNumber = (int) (Math.random() * 10);
		System.out.println("0이상 9이하의 숫자를 맞춰보세요.");
		
		while(true) {
			System.out.println("맞춰야 할 숫자는 " + targetNumber + "입니다.");
			
			// 각 선수별로 guess() 메소드를 호출합니다.
			p1.guess();
			p2.guess();
			p3.guess();
			
			// 각 객체의 인스턴스 변수를 접근하여
			// 각 선수가 찍은 숫자(guess() 메소드를 실행시킨결과)를
			// 알아냅니다.
			guessp1 = p1.number;
			System.out.println("1번 선수가 찍은 숫자: " + guessp1);
			
			guessp2 = p2.number;
			System.out.println("2번 선수가 찍은 숫자: " + guessp2);
			
			guessp3 = p3.number;
			System.out.println("3번 선수가 찍은 숫자: " + guessp3);
			
			// 각 선수가 찍은 숫자 중에서 맞춘 숫자가 있는지를 확인합니다.
			// 맞춘 선수가 있으면 그 선수에 해당하는 변수를 참으로 설정합니다.
			// (기본값은 거짓(false)으로 설정했었죠?.)
			if (guessp1 == targetNumber) {
				p1isRight = true;
			}
			
			if (guessp2 == targetNumber) {
				p2isRight = true;
			}
			
			if (guessp3 == targetNumber) {
				p3isRight = true;
			}
			
			// 1번 선수 또는 2번 선수 또는 3번 선수가 맞았으면...
			// (||연산자는 또는(OR)을 의미합니다.)
			if (p1isRight || p2isRight || p3isRight) {
				System.out.println("맞춘 선수가 있습니다.");
				System.out.println("1번 선수: " + p1isRight);
				System.out.println("2번 선수: " + p2isRight);
				System.out.println("3번 선수: " + p3isRight);
				System.out.println("게임 끝!!");
				break;  // 게임이 끝났으므로 break문으로 순환문을 빠져나갑니다.
				
			// 그렇지 않으면 순환문을 계속 돌리면서 숫자를 다시 찍게 합니다.	
			} else {
				// 아직 아무도 못 맞췄기 때문에 계속 해야 합니다.
				System.out.println("다시 시도해야 합니다.");
			}  //if..else 부분 끝
		} // 순환문 끝
	} // 메소드 끝
} // 클래스 끝
