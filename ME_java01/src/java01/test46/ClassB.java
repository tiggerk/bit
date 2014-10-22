package java01.test46;

public class ClassB extends ClassA {
	int x = 10;
	{
		System.out.println("ClassB의 인스턴스 블록");
	}
	
	public ClassB() {
		System.out.println("ClassB의 생성자 호출...");
		x = 20;
	}

}
