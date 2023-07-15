package com.sdhdata.service;

import java.util.List;

import com.sdhdata.model.Users;

public interface IUsersService {
	
	public List<Users> listausuarios();
	public void guardar(Users Users);
	public Users buscarPorId(Long iduser);
	public void eliminar(Long iduser);
	public List<Users> filtrarporusuario(String username);

}
