package com.mpa.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mpa.cursomc.services.exceptions.ObjectNotFoundException;


@ControllerAdvice
public class ResourceExceptionHandler {

	// Esta classe é um manipulador de exceptions do meu recurso

	
	@ExceptionHandler(ObjectNotFoundException.class)  // Pra indicar que é um tratador de exceções do tipo ObjectNotFoundException
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
		
	}

	@ExceptionHandler(DataIntegrityViolationException.class)  // Pra indicar que é um tratador de exceções do tipo DataIntegrityViolationException
	public ResponseEntity<StandardError> dataIntegrity(DataIntegrityViolationException e, HttpServletRequest request) {
		
		StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), "Não possível excluir uma categoria que possui produtos.", System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
		
	}
	
}


