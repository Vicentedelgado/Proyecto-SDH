package com.sdhdata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sdhdata.model.Users;
import com.sdhdata.repository.UsersRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
public class TestInicioDeSesion {
	
	@Autowired
	private UsersRepository repository;
	
	@Test
	@Order(1)
	public void InicioDeSesion() {
		String nombre = "admin";
		String contraseña= "$2a$10$C4ynSHX9PbzjnWSv8m0IheEq8obya43LpWihipQytaIOP4IJ35j1a";
		Users user = repository.findByusername(nombre);
		Users user1 = repository.findBypassword(contraseña);
		
		assertThat(user.getUsername()).isEqualTo(nombre);
		assertThat(user1.getPassword()).isEqualTo(contraseña);
	}
	
	@Test
	@Order(2)
	public void InicioDeSesionNoExistente() {
		String nombre = "Admin2";
		Users user = repository.findByusername(nombre);
		assertNull(user);
	}

}
