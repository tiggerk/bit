/* 다형성(polymorphism): 오버로딩(overloading)
   - 파라미터 개수나 파라미터의 타입이 다르더라도 결국 동일한 기능을 수행할 경우
     메서드 이름을 같게 하는 것 => 프로그래밍의 일관성 유지
     즉, 같은 기능을 하는 메서드에 같은 이름을 부여하는 것!!!!
   - 규칙:
     1) 메서드 이름은 같아야 한다.
     2) 파라미터의 갯수가 다르거나, 데이터 형이 달라야 한다.
     3) 리턴 타입이 다른 것은 의미없다. 이유는 호출할 때 메서드를 결정해야 하는데
        리턴 타입으로는 어떤 메서드를 호출할지 결정할 수 없기 때문이다.
 */
package java01.test39;

// Score : 학생의 이름과 국어, 영어, 수학, 평균, 합계를 저장하는
//         메모리의 데이터 형이다.
public class Score {
	String name; // 용어: 인스턴스 변수, 속성(attribute)
	int kor;
	int eng;
	int math;
	int sum;
	float average;
	
	// 기본 생성자 : 파라미터가 없는 생성자
	// 생성자를 정의하지 않으면 컴파일러가 다음과 같이 자동으로 추가한다.
	public Score() {} {
		this.name = "홍길동";
	}
	
	/// 생성자 추가
	public Score(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
		compute();
	}
	
	// 연산자를 정의하는 문법 => 메서드
	// 다음 연산자는 국어, 영어, 수학 점수의 합계를 내는 기능을 수행한다.
	public void compute() {
		this.sum = this.kor + this.eng + this.math;
		this.average = this.sum / 3.0f;
	}

}
