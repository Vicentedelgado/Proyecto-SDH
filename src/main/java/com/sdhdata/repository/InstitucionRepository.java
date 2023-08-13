package com.sdhdata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sdhdata.model.Institucion;

@Repository
public interface InstitucionRepository extends CrudRepository<Institucion, Long> {
	@Query("SELECT u FROM Institucion u WHERE u.nombre=:nombre")
	List<Institucion> listainsnombre(String nombre);
	
	public Institucion findByNombre(String nombre);

}
