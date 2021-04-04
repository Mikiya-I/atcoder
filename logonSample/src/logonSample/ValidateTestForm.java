package logonSample;

import org.apache.struts.validator.ValidatorForm;

public class ValidateTestForm extends ValidatorForm {
	private String user;
	private String phoneNumber;
	private String email;


	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


}
