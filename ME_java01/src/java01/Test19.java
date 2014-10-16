/* switch
   - 특정 값에 따라 명령어의 실행을 분기할 때 사용
   - 문법
     switch(4byte 이하 정수값. byte, short, int, char) {
       case 값:
          명령어...
         break;
       default: //else를 의미
          명령어...
     }
   - JDK 7부터는 switch 문에 문자열을 넣을 수 있다.
        
*/
package java01;

public class Test19 {

	public static void main(String[] args) {
		byte b = 10;	// OK
		short s = 10;	// OK
		char c = '가';	// OK
		int i = 10;	// OK
		long l = 10L;	// error
		float f = 10.0f;	// error
		double d = 10.0;	// error
		boolean bool = true;	// error
		String str = "okok";	// OK (1.7버젼 이상)
		
	    switch (str) {
	    	default: System.out.println("테스트"); break;   	
	    }
		
	}

}
