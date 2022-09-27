package com.alvimcode.cursomc.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpServerErrorException;

import com.alvimcode.cursomc.services.exceptions.ObjectNotFoundException;

public class ResourceExceptionHandler {
	
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServerErrorException request){
		
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

}
