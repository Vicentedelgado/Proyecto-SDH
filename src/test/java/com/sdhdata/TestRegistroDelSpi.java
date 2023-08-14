package com.sdhdata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

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

import com.sdhdata.model.Activo;
import com.sdhdata.model.Institucion;
import com.sdhdata.model.RegistrodelSpi;
import com.sdhdata.model.SpiDatos;
import com.sdhdata.model.Tipo;
import com.sdhdata.model.Zona;
import com.sdhdata.repository.RegistroDelSpiRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
public class TestRegistroDelSpi {
	
	@Autowired
	private RegistroDelSpiRepository repository;
	
	@Test
	@Rollback(false)
	@Order(1)
	public void testGuardarRegistrodelSpi() {
		long id = 2;
		short cantidad = 5;
		short cantidadR = 10;
		short cantidadH = 5;
		Tipo tipo = null;
		Date fecha = new Date();
		Zona zona = new Zona(id,"Zona 2");
		Institucion institucion = new Institucion(id,"POLICIA NACIONAL");
		Activo activo = new Activo(id,"Lapices",tipo,"Lapices de colores");
		SpiDatos spidatos = new SpiDatos(id,institucion,zona,"San Juan",
				"San Juan, San Lorenzo 2","San Juan Tena","0987456236",1,
				"SD","Ninguna",fecha,"vacio_sdh.pdf");
		RegistrodelSpi registrodelspi = new RegistrodelSpi(activo, spidatos, institucion, 
				"Bueno", cantidad,cantidadR,cantidadH, "Alta", "Ninguna", "2023", fecha, 
				"Vacio1.pdf", "Ninguna observación");
		RegistrodelSpi guardarregistrodelspi = repository.save(registrodelspi);
		
		assertNotNull(guardarregistrodelspi);
	}
	
	@Test
	@Order(2)
	public void buscarPorArchivo() {
		String archivo = "Vacio1.pdf";
		RegistrodelSpi registrodelspi = repository.findByArchivo(archivo);
		
		assertThat(registrodelspi.getArchivo()).isEqualTo(archivo);
	}
	
	@Test
	@Order(3)
	public void buscarPorArchivoNoExistente() {
		String archivo = "Vacio_sdh.jpg";
		RegistrodelSpi registrodelspi = repository.findByArchivo(archivo);
		
		assertNull(registrodelspi);
	}
	
	@Test
	@Rollback(false)
	@Order(4)
	public void testActualizarRegistrodelSpi() {
		long id = 44;
		long id0 = 2;
		short cantidad = 10;
		short cantidadR = 20;
		short cantidadH = 10;
		Tipo tipo = null;
		Date fecha = new Date();
		Zona zona = new Zona(id,"Zona 1");
		Institucion institucion = new Institucion(id0,"POLICIA NACIONAL");
		Activo activo = new Activo(id0,"Lapices",tipo,"Lapices de colores");
		SpiDatos spidatos = new SpiDatos(id0,institucion,zona,"San Andrés",
				"San Andres, San Lorenzo","San Andres Puyo","0987456236",1,
				"SD","Ninguna",fecha,"vacio_sdh.pdf");
		RegistrodelSpi registrodelspi = new RegistrodelSpi(activo, spidatos, institucion, 
				"Bueno", cantidad,cantidadR,cantidadH, "Alta", "Ninguna", "2023", fecha, 
				"vacio.jpg", "Ninguna observación");
		registrodelspi.setIdregistro(id);
		
		repository.save(registrodelspi);
		
		RegistrodelSpi actualizarregistrodelspi = repository.findByArchivo("vacio.jpg");
		
		assertThat(actualizarregistrodelspi.getArchivo()).isEqualTo("vacio.jpg");
	}
	
	@Test
	@Order(5)
	public void testListarRegisttrodelSpi() {
		List<RegistrodelSpi> registrosdelspi = (List<RegistrodelSpi>) repository.findAll();
		
		for (RegistrodelSpi registrodelspi: registrosdelspi) {
			System.out.print(registrodelspi);
		}
		assertThat(registrosdelspi).size().isGreaterThan(0);
	}

}
