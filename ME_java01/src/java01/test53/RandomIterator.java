package java01.test53;

import java.util.ArrayList;
import java01.test53.step05.Iterator;

public class RandomIterator extends Iterator {
	ArrayList<String> randomList = new ArrayList<String>();
	int cursor;

	public RandomIterator() {}

	@Override
	public void setList(String[] list) {
		super.setList(list);
		for (String value : list) {
			randomList.add(value);
		}
	}
	public boolean hasNext() {
		if (randomList.size() > 0)
			return true;
		else 
			return false;
	}

	public String next() {
		return randomList.remove((int)(Math.random() * randomList.size()));
		/* 위에 코드 줄이기 전이얌
		  int index = (int)(Math.random() * randomList.size());
		  return randomList.remove(index);
		
		 */
	}
}










