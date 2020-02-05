package com.mpa.cursomc.services.exceptions;


public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	public ObjectNotFoundException(String msg, Throwable cause) {   // Sobrecarga do construtor, recebendo uma outra exceção, que seria a causa de um problema que aconteceu antes dessa exception.
		super(msg,cause);
	}
	
}
