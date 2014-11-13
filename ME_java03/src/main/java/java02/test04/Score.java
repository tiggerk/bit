package java02.test04;

import java.io.Serializable;

public class Score implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private float average;

	public Score() {
	}

	public Score(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		compute();
	}

	public Score(String csv) {
		String[] token = csv.split(",");
		this.name = token[0];
		this.kor = Integer.parseInt(token[1]);
		this.eng = Integer.parseInt(token[2]);
		this.math = Integer.parseInt(token[3]);
		compute();
	}

	@Override
	public Score clone() throws CloneNotSupportedException {
		return (Score) super.clone();
	}

	private void compute() {
		this.sum = kor + eng + math;
		this.average = sum / 3.0f;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
		compute();
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
		compute();
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
		compute();
	}

	public int getSum() {
		return sum;
	}

	public float getAverage() {
		return average;
	}

}