package com.sdhdata.service;

import java.util.List;

import com.sdhdata.model.Roles;

public interface IRolesService {
	
	public List<Roles> listaroles();
	public void guardar(Roles Roles);
	public Roles buscarPorId(Long idrol);
	public void eliminar(Long idrol);

}
