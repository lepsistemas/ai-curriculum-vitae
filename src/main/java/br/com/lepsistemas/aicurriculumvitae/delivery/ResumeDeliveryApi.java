package br.com.lepsistemas.aicurriculumvitae.delivery;

import br.com.lepsistemas.aicurriculumvitae.usecase.ResumeService;

public class ResumeDeliveryApi {
	
	private ResumeService service;

	public ResumeDeliveryApi(ResumeService service) {
		this.service = service;
	}

	public ApiResponse get() {
		return new ApiResponse(service.fetch());
	}

}
