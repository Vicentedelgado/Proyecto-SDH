package com.sdhdata.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sdhdata.model.Users;


@Repository
public interface UsersRepository extends CrudRepository<Users, Long>{
	@Query("select e from Users e where e.username=:username")
	List<Users> filtrarporusuario(String username);
	
	public Users findByusername(String username);
	

}
