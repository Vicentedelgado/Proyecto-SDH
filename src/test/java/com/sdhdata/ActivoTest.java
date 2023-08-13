package com.sdhdata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

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
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ActivoTest {
	
	@Autowired
	private ActivoRepository repository;
	
	@Test
	@Rollback(false)
	public void testGuardarActivo() {
		
		Long id = (long) 10;
		Activo idtipo = new Activo();
		Activo activo = new Activo("Teclado",idtipo.getIdtipo(),"teclado gaming");
		Activo activoguardado = repository.save(activo);
		
		assertNotNull(activoguardado);
	}
	
	
   @Test 
   public void buscarpornombre() { 
	   String nombre = "Papelera"; 
	   Activo activo = repository.findByNombre(nombre);
	   assertThat(activo.getNombre()).isEqualTo(nombre);
   }
   
   @Test 
   public void buscarpornombrenoexistente() { 
	   String nombre = "moneda"; 
	   Activo activo = repository.findByNombre(nombre);
	   assertNull(activo);
   }
   
   @Test
   @Rollback(false)
   public void testActualizarActivo() {
	   String nombreActivo = "Teclado ASUS";
	   Tipo tipo = new Tipo();
	   Long id = (long) 10;
	   Activo activo = new Activo(nombreActivo,tipo,"teclado gaming");
	   activo.setIdactivo(id);
	   Activo activoactualizado = repository.findByNombre(nombreActivo);
		
		assertThat(activoactualizado.getNombre()).isEqualTo(nombreActivo);
	}
	 
}
