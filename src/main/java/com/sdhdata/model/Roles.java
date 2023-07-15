package com.sdhdata.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="roles")
public class Roles  implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idrol")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idrol;
	@NotEmpty
	@Column(name= "rol", nullable= true, length =60)
	private String rol;
	
	public Long getIdrol() {
		return idrol;
	}
	public void setIdrol(Long idrol) {
		this.idrol = idrol;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	@Override
	public String toString() {
		return "Roles [idrol=" + idrol + ", rol=" + rol + "]";
	}
	public Roles() {
		super();
	}
	public Roles(@NotEmpty String rol) {
		super();
		this.rol = rol;
	}
	public Roles(Long idrol, @NotEmpty String rol) {
		super();
		this.idrol = idrol;
		this.rol = rol;
	}
	
	
	
	
	
	
	
	
}
