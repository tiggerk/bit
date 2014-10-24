package java01.test53;

import java01.test53.step05.Iterator;

public class TripleIterator extends Iterator {
	int cursor;

	@Override
	public boolean hasNext() {
		// 상속 받은 변수(list)에 접근할 수 없다? 왜?
		// list는 접근 범위가 default이기 때문이다.
		// default => 클래스 멤버, 패키지 멤버만 접근 가능!
		// 해결책! => 자식 클래스도 접근 가능하도록 접근 범위를 조정해야 한다.
		// 어떻게? protected로 선언하라!
		// 왜? protected => 클래스 멤버, 패키지 멤버, 자식 클래스 접근가능
		if (cursor < list.length - 1)
			return true;
		else
			return false;
	}

	@Override
	public String next() {
		String value = list[cursor];
		cursor += 3;
		return value;
	}



}
