package java01.test53.step06;

abstract public class AbstractIterator implements Iterator {
	protected String[] list;
	
	@Override
	public void setList(String[] list) {
		this.list = list;
		
	}
}
