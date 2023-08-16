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

import com.sdhdata.model.Institucion;
import com.sdhdata.model.Modalidad;
import com.sdhdata.model.RRHH;
import com.sdhdata.model.SpiDatos;
import com.sdhdata.model.Unidad;
import com.sdhdata.model.Zona;
import com.sdhdata.repository.RRHHRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
public class TestRRHH {

	@Autowired
	private RRHHRepository repository;
	
	@Test
	@Rollback(false)
	@Order(1)
	public void testGuardarRRHH() {
		long id= 3;
		Date fecha = new Date();
		Zona zona = new Zona(id,"Zona 2");
		Institucion institucion = new Institucion(id,"POLICIA NACIONAL");
		SpiDatos spidatos = new SpiDatos(id,institucion,zona,"San Juan",
				"San Juan, San Lorenzo 2","San Juan Tena","0987456236",1,
				"SD","Ninguna",fecha,"vacio_sdh.pdf");
		Unidad unidad = new Unidad(id,"Enfermería");
		Modalidad modalidad = new Modalidad(id,"Nombramiento");
		RRHH rrhh = new RRHH(spidatos,zona,unidad,modalidad,"Doctor","Tommy Daniel",
		"Cemar Torres","0535218525","0986452124","tommy@gmail.com","Cuenca","Inactivo");
		
		RRHH guardarrrhh = repository.save(rrhh);
		
		assertNotNull(guardarrrhh);
	}
	
	@Test
	@Order(2)
	public void buscarPorCedula() {
		String cedula = "0539875412";
		RRHH rrhh = repository.findByCedula(cedula);
		
		assertThat(rrhh.getCedula()).isEqualTo(cedula);
	}
	
	@Test
	@Order(3)
	public void buscarporcedulanoexistente() {
		String cedula = "0539877712";
		RRHH rrhh = repository.findByCedula(cedula);
		
		assertNull(rrhh);
	}
	
	@Test
	@Rollback(false)
	@Order(4)
	public void testActualizarRRHH() {
		long id= 2;
		long id1 = 21;
		String cedula = "0539875412";
		Date fecha = new Date();
		Zona zona = new Zona(id,"Zona 2");
		Institucion institucion = new Institucion(id,"POLICIA NACIONAL");
		SpiDatos spidatos = new SpiDatos(id,institucion,zona,"San Juan",
				"San Juan, San Lorenzo 2","San Juan Tena","0987456236",1,
				"SD","Ninguna",fecha,"vacio_sdh.pdf");
		Unidad unidad = new Unidad(id,"Enfermería");
		Modalidad modalidad = new Modalidad(id,"Nombramiento");
		RRHH rrhh = new RRHH(spidatos,zona,unidad,modalidad,"Psicologo","Juan Carlos",
		"López Pérez",cedula,"0986476124","juan@gmail.com","Quito","Inactivo");
		rrhh.setIdusuario(id1);
		
		repository.save(rrhh);
		
		RRHH rrhhactualizado = repository.findByCedula(cedula);
		
		
		assertThat(rrhhactualizado.getCedula()).isEqualTo(cedula);
	}
	
	@Test
	@Order(5)
	public void testListarRRHH() {
		List<RRHH> rrhhs = (List<RRHH>) repository.findAll();
		
		for(RRHH rrhh: rrhhs) {
			System.out.print(rrhh);
		}
		assertThat(rrhhs).size().isGreaterThan(0);
	}
	
}
