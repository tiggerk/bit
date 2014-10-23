/* 5단계
   - Iterator 뿐만 아니라 EvenIterator, ReverseIterator도 사용할 수 있게 하기
   - 해결책:
     이들 클래스의 공통점을 뽑아 수퍼 클래스를 정의하라. => Generalization 수행!
     Iterator
        └-----> GeneralIterator
        └-----> EvenIterator
        └-----> ReverseIterator
        
 */

package java01.test53.step05;


public class Test05 {
	public static void main(String[] args) throws Exception {
		String iteratorClassName = System.getProperty("iterator");
		
		Class clazz = Class.forName(iteratorClassName);
		Iterator iterator = (Iterator)clazz.newInstance();
		iterator.setList(args);
		
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	
	}


}



