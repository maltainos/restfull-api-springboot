package com.api.paises.excepiton;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @see RuntimeException
 * @author Nelson Zaona Joao Albino
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class SubRegiaoNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @exception SubRegiaoNotOFundException
	 * @param message que sera retornado ao usuario
	 */
	public SubRegiaoNotFoundException(String message) {
		super(message);
	}
}
