package java01.test47;

public class ClassA {
	static int value = 10;
	
	static {
		System.out.println("ClassA: static 블록 실행");
		ClassB.value = 100; //ClassB.이 시점에 ClassB 호출 => 그 후 value값 대입
		System.out.println("ClassA: ClassB.value = " + ClassB.value);
		System.out.println("ClassA: value = " + value);
	}

}
