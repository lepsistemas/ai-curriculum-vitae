package br.com.lepsistemas.aicurriculumvitae.delivery;

import br.com.lepsistemas.aicurriculumvitae.usecase.LanguagesService;

public class LanguagesDeliveryApi {
	
	private LanguagesService service;

	public LanguagesDeliveryApi(LanguagesService service) {
		this.service = service;
	}

	public ApiResponse get() {
		return new ApiResponse(service.fetch());
	}

}
