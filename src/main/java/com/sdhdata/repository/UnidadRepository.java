package com.sdhdata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sdhdata.model.Unidad;

@Repository
public interface UnidadRepository extends CrudRepository<Unidad, Long>{
	@Query("SELECT u FROM Unidad u WHERE u.nombre=:nombre")
	List<Unidad> listauninombre(String nombre);

}
