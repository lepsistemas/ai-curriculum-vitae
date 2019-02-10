package br.com.lepsistemas.aicurriculumvitae.delivery;

import br.com.lepsistemas.aicurriculumvitae.usecase.ProfessionalService;

public class ProfessionalDeliveryApi {

	private ProfessionalService service;

	public ProfessionalDeliveryApi(ProfessionalService service) {
		this.service = service;
	}

	public ApiResponse get() {
		return new ApiResponse(service.fetch());
	}

}
