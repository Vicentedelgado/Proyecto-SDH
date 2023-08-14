package com.sdhdata.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sdhdata.model.Tipo;

@Repository
public interface TipoRepository extends CrudRepository<Tipo, Long> {
	
	@Query("SELECT u FROM Tipo u WHERE u.nombre=:nombre")
	List<Tipo> listapornombre(String nombre);
	
	public Tipo findByNombre(String nombre);
		

}
