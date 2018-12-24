package br.com.lepsistemas.aicurriculumvitae.delivery;

import br.com.lepsistemas.aicurriculumvitae.usecase.PersonalInfoService;

public class PersonalInfoDeliveryApi {
	
	private PersonalInfoService service;

	public PersonalInfoDeliveryApi(PersonalInfoService service) {
		this.service = service;
	}

	public ApiResponse get() {
		return new ApiResponse(service.fetch());
	}

}
