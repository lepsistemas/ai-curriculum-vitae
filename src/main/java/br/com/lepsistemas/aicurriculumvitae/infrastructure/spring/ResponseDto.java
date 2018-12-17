package br.com.lepsistemas.aicurriculumvitae.infrastructure.spring;

public class ResponseDto {

	String speech;
	String displayText;

	public ResponseDto(String message) {
		this.speech = message;
		this.displayText = message;
	}

	public String getSpeech() {
		return speech;
	}

	public String getDisplayText() {
		return displayText;
	}

}
