package com.accenture.technology.exceptions;

/**
 * Manejo de excepciones
 * @author nestrada
 *
 */
public class UsersException extends Exception {

	/**
	 * Excepción cuando el usuario no fue encontrado
	 * @param userId
	 */
	 public UsersException(String userId) {
	    super(String.format("El usuario no existe: ", userId));

	 }
	

}
