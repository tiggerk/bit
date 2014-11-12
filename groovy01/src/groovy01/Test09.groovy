package groovy01

// 자바스크립트의 each() 흉내
scores = ["홍길동", 100, 80, 100]
// 메서드 호출할 때 괄호 생략 가능
scores.each {value -> println value}  // each()라는 메소드 호출
println "--------------------"
scores.each ({println "홍길동"})
scores.eachWithIndex {value, index -> println value + "," + index}

println "--------------------"

// 메서드 정의
def plus (x,y) {
  x + y // 맨 끝 문장의 실행 결과가 리턴된다.
}

int minus(int x, int y) {
  return x - y;
}

println(plus(10, 20)) // 메서드 호출 시 괄호 사용 => 고유 문법
println plus(100, 200) // 메서드 호출 시 괄호 생략 => 그루비 기본 문법
result = minus 100, 50 // 괄호 생략 예제
println result

println "--------------------"
multiple = {x, y ->
  println "이것이 클로저다!"
  println "오호라... 그렇군.."
   x * y
 }
// 자바스크립트로 위의 문장을 표현한다면,
/*
multiple = function(x, y) {
  console.log("이것이 클로저다!");
  console.log("오호라... 그렇군..");
   return x * y;
 }
*/
println multiple(14, 14)
