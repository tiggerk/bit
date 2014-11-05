package headFirstJava.p096;

public class Dog {
	String name;
	public static void main(String[] args) {
		// Dog 객체를 만들고 접근합니다.
		Dog dog1 = new Dog();
		dog1.bark();
		dog1.name = "Bart";
		
		// 이번에는 Dog 배열을 만듭니다.
		Dog[] myDogs = new Dog[3];
		// 그리고 개를 몇 마리 집어넣습니다.
		myDogs[0] = new Dog();
		myDogs[1] = new Dog();
		myDogs[2] = dog1;
		
		// 배열 레퍼런스를 써서 Dog 객체에
		// 접근합니다.
		myDogs[0].name = "Fred";
		myDogs[1].name = "marge";
		
		// myDogs[2]의 이름이 뭐였지?
		System.out.println("마지막 개의 이름: ");
		System.out.println(myDogs[2].name);
		
		// 이제 순환문을 써서 배열에 들어있는
		// 모든 개가 짖도록 합시다.
		int x = 0;		
		// 배열에는 'length'라는 변수가 있어서 그 변수를 통해
		// 배열에 들어있는 원소의 개수를 알아낼 수 있습니다.
		while (x < myDogs.length) {  
			myDogs[x].bark();
			x = x + 1;
		}
	}

	public void bark() {
		System.out.println(name + "가 왈!하고 짖습니다.");
	}
	public void eat() {
		
	}
	public void chaseCat() {
		
	}
}

