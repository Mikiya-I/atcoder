package logonSample;

import org.apache.struts.validator.ValidatorForm;

public class LogonForm extends ValidatorForm{
	private String user=null;
	private String password=null;


	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
