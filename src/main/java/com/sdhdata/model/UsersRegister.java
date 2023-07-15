package com.sdhdata.model;


public class UsersRegister {
	
	
	private Long iduser;
	private String username;
	private String password;
	private String enabled;
	
	public Long getIduser() {
		return iduser;
	}
	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}
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
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public UsersRegister(Long iduser, String username, String password, String enabled) {
		super();
		this.iduser = iduser;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}
	public UsersRegister(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public UsersRegister(String username) {
		super();
		this.username = username;
	}
	public UsersRegister() {
		super();
	}
	
	

}
