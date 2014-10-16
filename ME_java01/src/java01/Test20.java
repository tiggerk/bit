/* 조건문 퀴즈
   - 프로그램 아규먼트로 나이를 입력 받아 청소년, 청년 등의
     여부를 출력하시오.
   - 참고 문법: 문자열을 숫자로 바꾸는 방법
     String s = "23";
     int i = Integer.parseInt(s);
     
   - java -classpath ./bin java01.Test17 34(엔터)
   
*/
package java01;

public class Test20 {

	public static void main(String[] args) {
		int age = Integer.parseInt(args[0]);
		 switch (age/10) {
	    	case 1: 
	    		System.out.println("당신은 10대 입니다."); break;
	    	case 2: 
	    		System.out.println("당신은 20대 입니다."); break;
	    	case 3: 
	    		System.out.println("당신은 30대 입니다."); break;
	    	case 4: 
	    		System.out.println("당신은 40대 입니다."); break;
	    	case 5: 
	    		System.out.println("당신은 50대 입니다."); break;	    	
	    	default: 
	    		System.out.println("살아있습니다."); break;  
		 }
	}
}
