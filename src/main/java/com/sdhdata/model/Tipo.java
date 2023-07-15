package com.sdhdata.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo")
public class Tipo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//@Column(name = "idregistro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idtipo;
	private String nombre;
	private String descripcion;
	
	
	public Long getIdtipo() {
		return idtipo;
	}
	public void setIdtipo(Long idtipo) {
		this.idtipo = idtipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "Tipo [idtipo=" + idtipo + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	public Tipo() {
		super();
	}
	
	public Tipo(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public Tipo(Long idtipo, String nombre, String descripcion) {
		super();
		this.idtipo = idtipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	
	
	
	
	
	

}
