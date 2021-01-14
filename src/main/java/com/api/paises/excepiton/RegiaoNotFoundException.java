package com.api.paises.excepiton;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @see RuntimeException
 * @author Nelson Zaona Joao Albino
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RegiaoNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @exception RegiaoNotFOundException
	 * @param message que sera retornada ao usuario
	 */
	public RegiaoNotFoundException(String message) {
		super(message);
	}
}
