package beautychu.domain;

import java.io.Serializable;

public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	protected String    email;
	protected int		 memberNumber;
	protected String    phone;
	protected String    address;
	protected String    name;
	protected String    password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Member [email=" + email + ", memberNumber=" + memberNumber
				+ ", phone=" + phone + ", address=" + address + ", name=" + name
				+ ", password=" + password + "]";
	}


}











