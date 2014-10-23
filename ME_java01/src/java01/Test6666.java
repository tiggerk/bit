package java01;

import java.util.ArrayList;
import java.util.Iterator;

public class Test6666 {
	
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("dkdkdkdk");
		list.add("Hello");
		list.add(new String("Hello"));
		list.add(10);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("-------------------------------");
		for (Object value : list) {
			System.out.println(value);
		}
		
		System.out.println("-------------------------------");
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}

}
