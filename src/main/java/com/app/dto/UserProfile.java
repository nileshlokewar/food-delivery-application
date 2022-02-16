package com.app.dto;

public class UserProfile {
	private String name;
	private long mobile;
	private String email;
	private String msg;
	private String role;
	private boolean flag;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public UserProfile(String name, long mobile, String email, String msg, String role, boolean flag) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.msg = msg;
		this.role = role;
		this.flag = flag;
	}

	public UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserProfile [name=" + name + ", mobile=" + mobile + ", email=" + email + ", msg=" + msg + ", role="
				+ role + ", flag=" + flag + "]";
	}

}
