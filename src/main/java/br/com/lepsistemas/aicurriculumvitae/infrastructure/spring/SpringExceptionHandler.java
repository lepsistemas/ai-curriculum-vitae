package br.com.lepsistemas.aicurriculumvitae.infrastructure.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.lepsistemas.aicurriculumvitae.usecase.exception.DateParseException;
import br.com.lepsistemas.aicurriculumvitae.usecase.exception.InvalidActionException;

@ControllerAdvice
public class SpringExceptionHandler {
	
	@ExceptionHandler(InvalidActionException.class)
	public ResponseEntity<StandardError> actionNotFound(InvalidActionException e, HttpServletRequest request) {
		StandardError error = new StandardError(HttpStatus.UNPROCESSABLE_ENTITY.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(error);
	}
	
	@ExceptionHandler(DateParseException.class)
	public ResponseEntity<StandardError> dateParse(DateParseException e, HttpServletRequest request) {
		StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}