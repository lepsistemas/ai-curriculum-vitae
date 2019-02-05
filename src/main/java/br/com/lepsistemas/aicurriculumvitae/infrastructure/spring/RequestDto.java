package br.com.lepsistemas.aicurriculumvitae.infrastructure.spring;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;

public class RequestDto {

	public static final String ALL = "curriculum.all";
	public static final String PERSONAL_INFO = "curriculum.personal.info";
	public static final String PROFESSIONAL_GOAL = "curriculum.professional.goal";
	public static final String LANGUAGES = "curriculum.languages";
	
	private ResultDto result;

	public RequestDto() {
	}

	public ResultDto getResult() {
		return result;
	}

	public void setResult(ResultDto result) {
		this.result = result;
	}

	public static class ResultDto {

		private String action;

		public ResultDto() {
		}

		public String getAction() {
			return action;
		}

		public void setAction(String action) {
			this.action = action;
		}
		
		@Override
		public boolean equals(Object obj) {
			return reflectionEquals(this, obj);
		}

	}
	
	@Override
	public boolean equals(Object obj) {
		return reflectionEquals(this, obj);
	}

}