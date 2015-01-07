package beautychu.domain;

import java.io.Serializable;

public class Style implements Serializable {

	private static final long serialVersionUID = 1L;

	protected int styleNumber;
	protected String people;
	protected String gender;
	protected String styleLength;
	protected String styleName;
	protected String styleIntro;
	protected int SkillTime;
	protected int price;
	protected String email;
	
	
	public int getStyleNumber() {
		return styleNumber;
	}
	public void setStyleNumber(int styleNumber) {
		this.styleNumber = styleNumber;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStyleLength() {
		return styleLength;
	}
	public void setStyleLength(String styleLength) {
		this.styleLength = styleLength;
	}
	public String getStyleName() {
		return styleName;
	}
	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}
	public String getStyleIntro() {
		return styleIntro;
	}
	public void setStyleIntro(String styleIntro) {
		this.styleIntro = styleIntro;
	}
	public int getSkillTime() {
		return SkillTime;
	}
	public void setSkillTime(int skillTime) {
		SkillTime = skillTime;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "Style [styleNumber=" + styleNumber + ", people=" + people
				+ ", gender=" + gender + ", styleLength=" + styleLength
				+ ", styleName=" + styleName + ", styleIntro=" + styleIntro
				+ ", SkillTime=" + SkillTime + ", price=" + price + ", email="
				+ email + "]";
	}
	
}
