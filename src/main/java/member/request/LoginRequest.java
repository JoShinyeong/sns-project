package member.request;

public class LoginRequest {
	private String email;
	private String password;
	public LoginRequest() {}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email, String password) {
		this.email = email;
		this.password=password;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
