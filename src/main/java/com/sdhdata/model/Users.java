package com.sdhdata.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="users")
public class Users  implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "iduser")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iduser;
	@NotEmpty
	@Column(name= "username", nullable= false, length =45)
	private String username;
	@NotEmpty
	@Column(name= "password", nullable= false, length =45)
	private String password;
	@NotEmpty
	@Column(name= "enabled", nullable= false, length =2)
	private String enabled;
	@ManyToOne
	@JoinColumn(name="id_rol")
	private Roles id_rol;
	
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
	public Roles getId_rol() {
		return id_rol;
	}
	public void setId_rol(Roles id_rol) {
		this.id_rol = id_rol;
	}
	
	public Users() {
		super();
	}
	public Users(@NotEmpty String username, @NotEmpty String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Users(@NotEmpty String username, @NotEmpty String password, Roles id_rol) {
		super();
		this.username = username;
		this.password = password;
		this.id_rol = id_rol;
	}
	public Users(@NotEmpty String username) {
		super();
		this.username = username;
	}
	public Users(Long iduser, @NotEmpty String username, @NotEmpty String password, @NotEmpty String enabled,
			Roles id_rol) {
		super();
		this.iduser = iduser;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.id_rol = id_rol;
	}
	@Override
	public String toString() {
		return "Users [iduser=" + iduser + ", username=" + username + ", password=" + password + ", enabled=" + enabled
				+ ", id_rol=" + id_rol + "]";
	}
	
	
		
	

}
