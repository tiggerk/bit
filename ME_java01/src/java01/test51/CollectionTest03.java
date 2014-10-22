package java01.test51;

class MyArray2 {
	Object[] list = new Object[10];
	int cursor;

	public int add(Object instance) {
		if (cursor < list.length) {
			list[cursor++] = instance;
			return 0;
		} else {
			return -1;
		}
	}

	public int size() {
		return this.cursor;
	}

	public Object get(int pos) {
		return list[pos];
	}

	public int remove(int pos) {
		if (pos >= 0 && pos < this.cursor) {
			for (int i = pos; i < this.cursor; i++) {
				if (i == (this.cursor - 1)) {
					list[i] = null;
					this.cursor--;
				} else {
					list[i] = list[i + 1];
				} // if
			} // for
			return 0;
		} else {
			return -1;
		} // if
	}

	public int insert(int pos, String value) {
		if (pos >= 0 && pos < list.length) {
			for (int i = this.cursor; i > pos; i--) {
				list[i] = list[i - 1];
			}
			list[pos] = value;
			this.cursor++;

			if (pos >= this.cursor) {
				this.cursor = pos + 1;
			}
			return 0;
		} else {
			System.out.println("정상 범위가 아님");
			return -1;
		}
	}
}

public class CollectionTest03 {

	public static void main(String[] args) {
		MyArray2 arr = new MyArray2();
		System.out.println(arr.add("0000"));
		System.out.println(arr.add("1111"));
		System.out.println(arr.add("2222"));
		System.out.println(arr.add("3333"));
		System.out.println(arr.add("4444"));
		System.out.println(arr.add("5555"));
		System.out.println(arr.add("6666"));
		System.out.println(arr.add("7777"));

		System.out.println("---------list----------");
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		} // for


		arr.remove(3); System.out.println("---------reomove----------");
		for (int i = 0; i < arr.size(); i++) { 
			System.out.println(arr.get(i)); 
		} // for

		System.out.println("----insert------");
		arr.insert(-30, "xxxx");
		//arr.insert(8, "xxxx");
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(i + ": " + arr.get(i));
		} // for
	}

}
