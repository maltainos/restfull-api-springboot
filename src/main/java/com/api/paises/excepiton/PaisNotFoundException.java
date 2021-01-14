package com.api.paises.excepiton;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @see RuntimeException
 * @author Nelson Zaona Joao Albino
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PaisNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @exception PaisNotFoundException
	 * @param message que sera tornado ao usuario
	 */
	public PaisNotFoundException(String message) {
		super(message);
	}

}
