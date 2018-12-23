package br.com.lepsistemas.aicurriculumvitae.delivery;

import org.springframework.web.bind.annotation.RequestBody;

import br.com.lepsistemas.aicurriculumvitae.domain.Domain;
import br.com.lepsistemas.aicurriculumvitae.infrastructure.spring.RequestDto;
import br.com.lepsistemas.aicurriculumvitae.usecase.CurriculumServiceFactory;
import br.com.lepsistemas.aicurriculumvitae.usecase.PersonalInfoService;
import br.com.lepsistemas.aicurriculumvitae.usecase.ProfessionalGoalService;
import br.com.lepsistemas.aicurriculumvitae.usecase.ResumeService;

public class WebhookDeliveryApi {
	
	private ResumeService resumeService;
	private PersonalInfoService personalInfoService;
	private ProfessionalGoalService professionalGoalService;
	
	public WebhookDeliveryApi(ResumeService resumeService, PersonalInfoService personalInfoService, ProfessionalGoalService professionalGoalService) {
		this.resumeService = resumeService;
		this.personalInfoService = personalInfoService;
		this.professionalGoalService = professionalGoalService;
	}

	public Domain get(@RequestBody RequestDto request) {
		return new CurriculumServiceFactory(resumeService, personalInfoService, professionalGoalService).get(request.getResult().getAction()).fetch();
	}

}
