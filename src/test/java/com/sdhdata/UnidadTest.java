package com.sdhdata;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.sdhdata.model.Unidad;
import com.sdhdata.repository.UnidadRepository;

@DataJpaTest
public class UnidadTest {
	
	@Autowired
	private UnidadRepository repository;
	
	@Test
	@Rollback(false)
	public void testguardarunidad() {
		Unidad unidad = new Unidad("Pediatria");
		Unidad unidadguardadaUnidad =repository.save(unidad);
		assertNotNull(unidadguardadaUnidad);
	}
	
	

}
