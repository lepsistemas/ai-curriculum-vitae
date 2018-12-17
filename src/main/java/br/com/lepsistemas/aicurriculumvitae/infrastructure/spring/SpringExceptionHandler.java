package br.com.lepsistemas.aicurriculumvitae.infrastructure.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.lepsistemas.aicurriculumvitae.usecase.exceptions.InvalidActionException;
import br.com.lepsistemas.aicurriculumvitae.usecase.exceptions.DateParseException;

@ControllerAdvice
public class SpringExceptionHandler {
	
	@ExceptionHandler(InvalidActionException.class)
	public ResponseEntity<StandardError> actionNotFound(InvalidActionException e, HttpServletRequest request) {
		StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(DateParseException.class)
	public ResponseEntity<StandardError> dateParse(DateParseException e, HttpServletRequest request) {
		StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}