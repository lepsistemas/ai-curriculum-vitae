package br.com.lepsistemas.aicurriculumvitae.delivery;

import br.com.lepsistemas.aicurriculumvitae.domain.Resume;
import br.com.lepsistemas.aicurriculumvitae.usecase.ResumeService;

public class ResumeDeliveryApi {
	
	private ResumeService service;

	public ResumeDeliveryApi(ResumeService service) {
		this.service = service;
	}

	public Resume get() {
		return (Resume) service.fetch();
	}

}
