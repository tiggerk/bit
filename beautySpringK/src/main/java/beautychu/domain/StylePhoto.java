package beautychu.domain;

import java.io.Serializable;

public class StylePhoto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected int stylePhotoNumber;
	protected int styleNumber;
	protected String stylePhoto;
	
	public int getStylePhotoNumber() {
		return stylePhotoNumber;
	}
	public void setStylePhotoNumber(int stylePhotoNumber) {
		this.stylePhotoNumber = stylePhotoNumber;
	}
	public int getStyleNumber() {
		return styleNumber;
	}
	public void setStyleNumber(int styleNumber) {
		this.styleNumber = styleNumber;
	}
	public String getStylePhoto() {
		return stylePhoto;
	}
	public void setStylePhoto(String stylePhoto) {
		this.stylePhoto = stylePhoto;
	}
	@Override
	public String toString() {
		return "StylePhoto [stylePhotoNumber=" + stylePhotoNumber
				+ ", styleNumber=" + styleNumber + ", stylePhoto=" + stylePhoto
				+ "]";
	}
	
	
	
}
