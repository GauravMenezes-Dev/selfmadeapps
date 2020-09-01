package com.selfmadeapps.dailyneedsclone.shared;

public class UserDTO {
	private String username;
	private String password;
	private String encPass;
	private String role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEncPass() {
		return encPass;
	}

	public void setEncPass(String encPass) {
		this.encPass = encPass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
