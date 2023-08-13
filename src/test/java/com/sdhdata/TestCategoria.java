package com.sdhdata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.sdhdata.model.Tipo;
import com.sdhdata.repository.TipoRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
public class TestCategoria {
	
	@Autowired
	private TipoRepository repository;
	
	@Test
	@Rollback(false)
	@Order(1)
	public void testGuardarCategoria() {
		
		Tipo tipo = new Tipo("Tecnologia1","Equipos de tecnologia");
		Tipo guardarcategoria = repository.save(tipo);
		
		assertNotNull(guardarcategoria);

	}
	
	@Test
	@Order(2)
	public void buscarPorNombre() {
		String nombre = "Instalaciones";
		Tipo tipo = repository.findByNombre(nombre);
		
		assertThat(tipo.getNombre()).isEqualTo(nombre);
		
	}
	
	@Test
	@Order(3)
	public void buscarpornombrenoexistente() {
		String nombre = "Instalaciones";
		Tipo tipo = repository.findByNombre(nombre);
		assertNull(tipo);
		
	}
	
	@Test 
	@Rollback(false)
	@Order(4)
	public void testActualizarCategoria() {
		long id = 1;
		String nombrecategoria = "Instalaciones";
		String descripcion = "Edificio construcción";
		Tipo tipo = new Tipo(nombrecategoria, descripcion);
		tipo.setIdtipo(id);
		
		repository.save(tipo);
		
		Tipo tipoactualizado = repository.findByNombre(nombrecategoria);
		
		assertThat(tipoactualizado.getNombre()).isEqualTo(nombrecategoria);
	}
	
	@Test
	@Order(5)
	public void testListarCategorias(){
		List<Tipo> tipos = (List<Tipo>) repository.findAll();
		
		for(Tipo tipo: tipos) {
			System.out.print(tipo);
		}
		assertThat(tipos).size().isGreaterThan(0);
	}
	
	@Test
	@Rollback(false)
	@Order(6)
	public void testEliminarCategoria() {
		
		long id = 1;
		boolean siExistenteAntesDeEliminar = repository.findById(id).isPresent();
		
		repository.deleteById(id);
		
		boolean noExisteDespuesDeEliminar = repository.findById(id).isPresent();
		
		assertTrue(siExistenteAntesDeEliminar);
		assertFalse(noExisteDespuesDeEliminar);
	}

}
