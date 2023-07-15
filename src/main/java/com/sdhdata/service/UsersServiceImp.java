package com.sdhdata.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sdhdata.model.Users;
import com.sdhdata.repository.UsersRepository;

@Service
@Transactional
public class UsersServiceImp implements IUsersService{

	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	@Autowired
	private UsersRepository UsersRepository;
	
	@Override
	public List<Users> listausuarios() {
		// TODO Auto-generated method stub
		return (List<Users>) UsersRepository.findAll();
	}

	@Override
	public void guardar(Users Users) {
		//TODO Auto-generated method stub
		Users user = new Users(Users.getIduser(),Users.getUsername(),passEncoder.encode(Users.getPassword()),Users.getEnabled(),Users.getId_rol());
		UsersRepository.save(user);
		
	}

	@Override
	public Users buscarPorId(Long iduser) {
		// TODO Auto-generated method stub
		Optional<Users> option = UsersRepository.findById(iduser);
		return option.isPresent() ? option.get(): new Users();
	}

	@Override
	public void eliminar(Long iduser) {
		// TODO Auto-generated method stub
		UsersRepository.deleteById(iduser);
	}

	@Override
	public List<Users> filtrarporusuario(String username) {
		// TODO Auto-generated method stub
		return UsersRepository.filtrarporusuario(username);
	}

}
