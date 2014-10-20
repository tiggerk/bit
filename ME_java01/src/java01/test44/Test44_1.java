package java01.test44;

public class Test44_1 {

	public static void main(String[] args) {
		// Unit u1 = new Unit(); 추상클래스라서 생성이 안됨.
		Tank t1 = new Tank();
		t1.move(Mover.NORTH);
		
		Vulture v1 = new Vulture();
		v1.move(Mover.SOUTH);
		
		Soldier s1 = new Soldier();
		s1.move(Mover.EAST);
		

	}

}
