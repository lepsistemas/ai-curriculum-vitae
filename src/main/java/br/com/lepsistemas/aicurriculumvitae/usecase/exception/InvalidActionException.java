package br.com.lepsistemas.aicurriculumvitae.usecase.exception;

public class InvalidActionException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InvalidActionException(String message) {
		super(message);
	}

}
