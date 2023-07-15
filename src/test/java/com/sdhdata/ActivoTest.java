package com.sdhdata;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.sdhdata.model.Activo;
import com.sdhdata.model.Tipo;
import com.sdhdata.repository.ActivoRepository;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ActivoTest {
	
	@Autowired
	private ActivoRepository repository;
	
	@Test
	@Rollback(false)
	public void testGuardarActivo() {
		
		Tipo tipo = new Tipo();
		Activo activo = new Activo("Teclado",tipo,"teclado gaming");
		Activo activoguardado = repository.save(activo);
		
		assertNotNull(activoguardado);
	}
	
	/*
	 * @Test public void buscarporid() { Tipo tipo = new Tipo(); long Idtipo =
	 * tipo.getIdtipo(); Activo activo = repository.Buscarportipo(Idtipo);
	 * asserThat(activo.getIdactivo()).isEqualTo(idactivo);
	 * 
	 * 
	 * }
	 */
}
