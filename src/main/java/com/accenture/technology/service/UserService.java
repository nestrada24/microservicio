package com.accenture.technology.service;

import java.util.List;

import com.accenture.technology.doc.User;
import com.accenture.technology.exceptions.UsersException;

/**
 * /**
 * Servicio transaccional para manejar Usuario
 * @author nestrada
 *
 */
public interface UserService {

	/**
	 * Consulta la lista de todos los usuarios
	 * @return
	 */
	public List<User> findAll();

	/**
	 * Realiza la búsqueda por el Id del usuario
	 * @param userId
	 * @return
	 */
	public User findByUserId(String userId) throws UsersException;

	/**
	 * Guarda en la base de datos la entidad
	 * @param user
	 * @return
	 */
	public User saveUser(User user);

	/**
	 * Actualiza los usuarios
	 * @param user
	 */
	public void updateUser(User user);

	/**
	 * Borra el registro de usuario
	 * @param userId
	 */
	public void deleteUser(String userId);
	  
}
