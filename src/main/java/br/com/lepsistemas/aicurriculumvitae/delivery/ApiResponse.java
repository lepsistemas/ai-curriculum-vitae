package br.com.lepsistemas.aicurriculumvitae.delivery;

public class ApiResponse {

	private Object data;

	public ApiResponse(Object domain) {
		this.data = domain;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
