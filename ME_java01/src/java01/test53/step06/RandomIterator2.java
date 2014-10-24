package java01.test53.step06;

import java.util.ArrayList;
import java01.test53.step05.Iterator;

public class RandomIterator2 extends ArrayList implements java01.test53.step06.Iterator {
	
	public RandomIterator2() {}

	@Override
	public void setList(String[] list) {
		for (String value : list) {
			this.add(value);
		}
	}
	
	@Override
	public boolean hasNext() {
		if (this.size() > 0)
			return true;
		else 
			return false;
	}

	@Override
	public String next() {
		return (String)this.remove(
				(int)(Math.random() * this.size()));
	}
}










