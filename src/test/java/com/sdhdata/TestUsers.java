package com.sdhdata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

import com.sdhdata.model.Roles;
import com.sdhdata.model.Users;
import com.sdhdata.repository.UsersRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
public class TestUsers {
	
	@Autowired
	private UsersRepository repository;
	
	@Test
	@Rollback(false)
	@Order(1)
	public void testGuardarUsuario() {
		
		long id = 10;
		Roles rol = new Roles();
		Users user = new Users(id, "Edison","EdisonSD7", "1", rol);
		Users userguardado = repository.save(user);
		
		assertNotNull(userguardado);
		
	}
	
	@Test
	@Order(2)
	public void buscarPorNombre() {
		String nombre = "admin";
		Users user = repository.findByusername(nombre);
		
		assertThat(user.getUsername()).isEqualTo(nombre);
	}
	
	@Test
	@Order(3)
	public void buscarPorNombreNoExistente() {
		String nombre = "Admin2";
		Users user = repository.findByusername(nombre);
		assertNull(user);
	}
	
	@Test 
	@Rollback(false)
	@Order(4)
	public void testActualizarUser() {
		long id = 23;
		String username = "EdisonSDH";
		String password = "AdminSDH89";
		
		
		Users user = new Users(username, password);
		user.setIduser(id);
		
		repository.save(user);
		
		Users useractualizado = repository.findByusername(username);
		
		assertThat(useractualizado.getUsername()).isEqualTo(username);
	}
	
	@Test
	@Order(5)
	public void testListarUsuarios() {
		List<Users> users = (List<Users>) repository.findAll();
		
		for(Users user: users) {
			System.out.print(user);
		}
		
		assertThat(users).size().isGreaterThan(0);	
	}
	
	
	
	@Test 
	@Rollback(false)
	@Order(6)
	public void testEliminarUsuario() {
		long id = 23;
		boolean siExistenteAntesDeEliminar = repository.findById(id).isPresent();
		
		repository.deleteById(id);
		
		boolean noExisteDespuesDeEliminar = repository.findById(id).isPresent();
		
		assertTrue(siExistenteAntesDeEliminar);
		assertFalse(noExisteDespuesDeEliminar);
		
	}

}
