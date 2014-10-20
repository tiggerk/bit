package java01.test44;

public class Tank extends Vehicle {
	int range;
	boolean siegeMode;
	
	@Override
	public void move(int direction) {
		if (siegeMode)
			return;
		
		int distance = 3;
		switch (direction) {
		case NORTH: y -= distance; break; // 북쪽
		case EAST: x += distance; break; // 동쪽
		case SOUTH: y += distance; break; // 남쪽
		case WEST: x -= distance; break; // 서쪽
		}
		
		System.out.println("Tank->끼리릭..철컥: " + x + "," + y);
	}
}
