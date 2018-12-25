package br.com.lepsistemas.aicurriculumvitae.delivery;

import br.com.lepsistemas.aicurriculumvitae.usecase.SkillsService;

public class SkillsDeliveryApi {
	
	private SkillsService service;

	public SkillsDeliveryApi(SkillsService service) {
		this.service = service;
	}

	public ApiResponse get() {
		return new ApiResponse(service.fetch());
	}

}
