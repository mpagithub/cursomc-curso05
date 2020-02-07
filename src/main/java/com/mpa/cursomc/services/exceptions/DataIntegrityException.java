package com.mpa.cursomc.services.exceptions;


public class DataIntegrityException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DataIntegrityException(String msg) {
		super(msg);
	}
	
	public DataIntegrityException(String msg, Throwable cause) {   // Sobrecarga do construtor, recebendo uma outra exceção, que seria a causa de um problema que aconteceu antes dessa exception.
		super(msg,cause);
	}
	
}
