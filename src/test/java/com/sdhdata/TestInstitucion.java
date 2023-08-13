package com.sdhdata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.sdhdata.model.Institucion;
import com.sdhdata.repository.InstitucionRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TestInstitucion {
	
	@Autowired
	private InstitucionRepository repository;
	
	@Test
	@Rollback(false)
	@Order(1)
	public void TestGuardarInstitucion() {
		
		Institucion institucion = new Institucion("POLICIA NACIONAL");
		Institucion guardarinstitucion = repository.save(institucion);
		
		assertNotNull(guardarinstitucion);
	}
	
	@Test
	@Order(2)
	public void BuscarPornombre() {
		String nombre = "MIES";
		Institucion institucion = repository.findByNombre(nombre);
		
		assertThat(institucion.getNombre()).isEqualTo(nombre);
	}
	
	@Test
	@Order(3)
	public void BuscarPorNombreNoExistente() {
		String nombre = "MIES";
		Institucion institucion = repository.findByNombre(nombre);
		
		assertNull(institucion);
	}
	
	@Test 
	@Rollback(false)
	@Order(4)
	public void TestActualizarInstitucion() {
		long id = 1;
		String nombreinstitucion = "MIES 1";
		Institucion institucion = new Institucion(nombreinstitucion);
		institucion.setIdinstitucion(id);
		
		repository.save(institucion);
		
		Institucion institucionactualizada = repository.findByNombre(nombreinstitucion);
		
		assertThat(institucionactualizada.getNombre()).isEqualTo(nombreinstitucion);		
	}
	
	@Test
	@Order(5)
	public void TestListarInstitucion() {
		List<Institucion> instituciones = (List<Institucion>) repository.findAll();
		
		for(Institucion institucion: instituciones) {
			System.out.print(institucion);
		}
		
		assertThat(instituciones).size().isGreaterThan(0);
	}
	
	@Test 
	@Rollback(false)
	@Order(6)
	public void TestEliminarInstitucion() {
		long id = 38;
		boolean siExistenteAntesDeEliminar = repository.findById(id).isPresent();
		
		repository.deleteById(id);
		
		boolean noExisteDespuesDeEliminar = repository.findById(id).isPresent();
		
		assertTrue(siExistenteAntesDeEliminar);
		assertFalse(noExisteDespuesDeEliminar);
	}
}
