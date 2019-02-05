package br.com.lepsistemas.aicurriculumvitae.delivery;

import org.springframework.web.bind.annotation.RequestBody;

import br.com.lepsistemas.aicurriculumvitae.domain.Domain;
import br.com.lepsistemas.aicurriculumvitae.infrastructure.spring.RequestDto;
import br.com.lepsistemas.aicurriculumvitae.usecase.CurriculumServiceFactory;
import br.com.lepsistemas.aicurriculumvitae.usecase.LanguagesService;
import br.com.lepsistemas.aicurriculumvitae.usecase.PersonalInfoService;
import br.com.lepsistemas.aicurriculumvitae.usecase.ResumeService;
import br.com.lepsistemas.aicurriculumvitae.usecase.SkillsService;

public class WebhookDeliveryApi {
	
	private ResumeService resumeService;
	private PersonalInfoService personalInfoService;
	private SkillsService professionalGoalService;
	private LanguagesService languagesService;
	
	public WebhookDeliveryApi(ResumeService resumeService, PersonalInfoService personalInfoService, SkillsService professionalGoalService, LanguagesService languagesService) {
		this.resumeService = resumeService;
		this.personalInfoService = personalInfoService;
		this.professionalGoalService = professionalGoalService;
		this.languagesService = languagesService;
	}

	public Domain get(@RequestBody RequestDto request) {
		return new CurriculumServiceFactory(resumeService, personalInfoService, professionalGoalService, languagesService).get(request.getResult().getAction()).fetch();
	}

}
