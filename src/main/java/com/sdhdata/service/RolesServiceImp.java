package com.sdhdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sdhdata.model.Roles;
import com.sdhdata.repository.RolesRepository;

@Service
@Transactional
public class RolesServiceImp implements IRolesService{
	
	@Autowired
	private RolesRepository RolesRepository;

	@Override
	public List<Roles> listaroles() {
		// TODO Auto-generated method stub
		return (List<Roles>) RolesRepository.findAll();
	}

	@Override
	public void guardar(Roles Roles) {
		// TODO Auto-generated method stub
		RolesRepository.save(Roles);
		
	}

	@Override
	public Roles buscarPorId(Long idrol) {	
		return RolesRepository.findById(idrol).orElse(null);
	}

	@Override
	public void eliminar(Long idrol) {
		// TODO Auto-generated method stub
		RolesRepository.deleteById(idrol);
	}

}
