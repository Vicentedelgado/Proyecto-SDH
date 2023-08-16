package com.sdhdata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.sdhdata.model.Institucion;
import com.sdhdata.model.SpiDatos;
import com.sdhdata.model.Zona;
import com.sdhdata.repository.SpiDatosRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
public class TestSpiDatos {
	
	@Autowired
	private SpiDatosRepository repository;
	
	@Test
	@Rollback(false)
	@Order(1)
	public void testGuardarSpiDato() {
		long id = 2;
		Date fecha = new Date();
		Zona zona = new Zona(id,"Zona 2");
		Institucion institucion = new Institucion(id,"POLICIA NACIONAL");
		SpiDatos spidatos = new SpiDatos(id,institucion,zona,"San Vicente",
				"San Vicente, San Jorge 3","San Vicente Morona","0977452631",1,
				"SD","Ninguna",fecha,"vacio_sdh.pdf");
		SpiDatos guardarspidatos = repository.save(spidatos);
		
		assertNotNull(guardarspidatos);
		
	}
	
	
	@Test
	@Order(2)
	public void buscarPorNombre() {
		String nombre = "San Edison";
		SpiDatos spidatos = repository.findByNombre(nombre);
		
		assertThat(spidatos.getNombre()).isEqualTo(nombre);
	}
	
	@Test
	@Order(3)
	public void buscarpornombrenoexistente() {
		String nombre = "Morona";
		SpiDatos spidatos = repository.findByNombre(nombre);
		assertNull(spidatos);
		
	}
	
	@Test
	@Rollback(false)
	@Order(1)
	public void testActualizarSpiDato() {
		long id = 2;
		long id0 = 2;
		Date fecha = new Date();
		Zona zona = new Zona(id,"Zona 2");
		Institucion institucion = new Institucion(id,"POLICIA NACIONAL");
		SpiDatos spidatos = new SpiDatos(id,institucion,zona,"San Edison",
				"San Edison 1, San Martín 3","San Edison Zamora1","0987452631",1,
				"SD","Por entregar",fecha,"vacio_sdh.pdf");
		spidatos.setIdspi(id0);
		
		repository.save(spidatos);
		
		SpiDatos actualizarspidatos = repository.findByNombre("San Edison");
		
		assertThat(actualizarspidatos.getNombre()).isEqualTo("San Edison");
		
	}
	
	@Test
	@Order(5)
	public void testListarSpiDatos() {
		List<SpiDatos> spidatoss =(List<SpiDatos>) repository.findAll();
		
		for(SpiDatos spidatos: spidatoss) {
			System.out.print(spidatos);
		}
		assertThat(spidatoss).size().isGreaterThan(0);
	}
	
	@Test
	@Rollback(false)
	@Order(6)
	public void testEliminarSpiDatos() {
		
		long id = 12;
		boolean siExistenteAntesDeEliminar = repository.findById(id).isPresent();
		
		repository.deleteById(id);
		
		boolean noExisteDespuesDeEliminar = repository.findById(id).isPresent();
		
		assertTrue(siExistenteAntesDeEliminar);
		assertFalse(noExisteDespuesDeEliminar);
	}
}
