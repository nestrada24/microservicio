package com.accenture.technology;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.technology.doc.User;
import com.accenture.technology.exceptions.UsersException;
import com.accenture.technology.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApplicationTests {
	
	@Autowired
	UserService userService;
	
	/**
	 * Inserta un usuario
	 */
	@Test
	public void createUser() {
		User user = new User();
		user.setId("1");
		user.setName("Roberto");
		user.setId("2");
		user.setName("Maria");
		userService.saveUser(user);
	}
	
	/**
	 * Consulta toda los usuarios almacenados en BD
	 */
	@Test
	public void findAll() {
		List<User> list =userService.findAll();
		System.out.println("Consulta todo los usuarios");
		for (User user : list) {
			System.out.println(user.toString());
		}
		
	}
	
	/**
	 * Consulta por el Id del usuario
	 */
	@Test
	public void findbyUserId() {
		User user = new User();
		try {
			user = userService.findByUserId("1");
		} catch (UsersException e) {
			e.printStackTrace();
		}
		System.out.println("Consulta por el id del usuario>>> "+user.toString());
		
	}
	
	/**
	 * Elimina el usuario por el Id
	 */
	@Test
	public void deleteUser() {
		User user = new User();
		try {
			user = userService.findByUserId("1");
		} catch (UsersException e) {
			e.printStackTrace();
		}
		userService.deleteUser(user.getId());;
		System.out.println("Se elimina el usuario con el id 1");
	}
	
	/**
	 * Actualiza el usuario por Id
	 */
	@Test
	public void updateUser() {
		User user;
		try {
			user = userService.findByUserId("2");
			if (user!=null) {
				//cambio los datos de lo que hay en la base de datos
				user.setName("Alejandro");
				userService.saveUser(user);
			}
			
			System.out.println("Registro actualizado");
		} catch (UsersException e) {
			e.printStackTrace();
		}
		
	}


	@Test
	public void contextLoads() {
	}

}
