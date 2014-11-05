package headFirstJava.p225;

public class Overloads {
	
	String uniqueID;
	
	public int addNums (int a, int b) {
		return a + b;
	}
	
	public double addNums (double a, double b) {
		return a + b;
	}
	
	public void setUniqueID (String theID) {
		// 여러 가지 검증 과정을 거치고 나서 다음을 실행
		uniqueID = theID;
	}

	public void setUniqueID(int ssNumber) {
		String numString = "" + ssNumber;
		setUniqueID(numString);
	}

}
