package com.sdhdata;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.sdhdata.model.Tipo;
import com.sdhdata.repository.TipoRepository;

@DataJpaTest
public class TipoTest {
	
	@Autowired
	private TipoRepository repository;
	
	@Test
	@Rollback(false)
	public void testGuardarCategoria() {
		
		Tipo tipo = new Tipo("Tecnologia","Equipos de tecnologia");
		Tipo guardarcategoria = repository.save(tipo);
		
		assertNotNull(guardarcategoria);

	}

}
