package java01.test41;

public class Car {
	String maker;
	String model;
	int cc = 800;  // 초기화 문장
	boolean diesel;
	java.util.Date releaseDate;
	int capacity = 5;  // 초기화 문장
	
	public Car(String maker, String model, int cc) {
		this.maker = maker;
		this.model = model;
		this.cc = cc;
	}

}
