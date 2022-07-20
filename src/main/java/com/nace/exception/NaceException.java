package com.nace.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

public class NaceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter
	private final String message;
	
	@Getter
	private final HttpStatus status;
	
	public NaceException(String message, HttpStatus status) {
		this.message = message;
		this.status = status;
	}

}
