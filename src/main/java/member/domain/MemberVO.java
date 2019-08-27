package member.domain;

import java.sql.Timestamp;

public class MemberVO {
	private String name;
	private String email;
	private String profile;
	private String password;
	private Timestamp regDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public MemberVO() {
	}

	public MemberVO(String name, String password, String email, Timestamp regdate) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.regDate = regdate;
	}

}
