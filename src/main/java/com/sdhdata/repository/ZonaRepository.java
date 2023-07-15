package com.sdhdata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sdhdata.model.Zona;

@Repository
public interface ZonaRepository extends CrudRepository<Zona, Long> {
	
	@Query("SELECT u FROM Zona u WHERE u.nombre=:nombre")
	List<Zona> listazonanombre(String nombre);

}
