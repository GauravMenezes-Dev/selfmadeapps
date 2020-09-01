package com.selfmadeapps.dailyneedsclone.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UserEntity {

	@Id
	private String username;
	private String encPass;
	private String role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	@Override
	public String toString() {
		return "UserEntity [username=" + username + ", encPass=" + encPass + ", role=" + role + "]";
	}

}
