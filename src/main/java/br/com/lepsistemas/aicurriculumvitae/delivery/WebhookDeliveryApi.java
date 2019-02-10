package br.com.lepsistemas.aicurriculumvitae.delivery;

import org.springframework.web.bind.annotation.RequestBody;

import br.com.lepsistemas.aicurriculumvitae.domain.Domain;
import br.com.lepsistemas.aicurriculumvitae.infrastructure.spring.RequestDto;
import br.com.lepsistemas.aicurriculumvitae.usecase.ApiService;
import br.com.lepsistemas.aicurriculumvitae.usecase.CurriculumServiceFactory;
import br.com.lepsistemas.aicurriculumvitae.usecase.LanguagesService;
import br.com.lepsistemas.aicurriculumvitae.usecase.PersonalInfoService;
import br.com.lepsistemas.aicurriculumvitae.usecase.ProfessionalService;
import br.com.lepsistemas.aicurriculumvitae.usecase.ResumeService;
import br.com.lepsistemas.aicurriculumvitae.usecase.SkillsService;

public class WebhookDeliveryApi {
	
	private ResumeService resumeService;
	private PersonalInfoService personalInfoService;
	private SkillsService skillsService;
	private LanguagesService languagesService;
	private ProfessionalService professionalExperiencesService;
	
	public WebhookDeliveryApi(ResumeService resumeService, PersonalInfoService personalInfoService, SkillsService professionalGoalService, LanguagesService languagesService, ProfessionalService professionalExperiencesService) {
		this.resumeService = resumeService;
		this.personalInfoService = personalInfoService;
		this.skillsService = professionalGoalService;
		this.languagesService = languagesService;
		this.professionalExperiencesService = professionalExperiencesService;
	}

	public Domain get(@RequestBody RequestDto request) {
		CurriculumServiceFactory factory = new CurriculumServiceFactory(resumeService, personalInfoService, skillsService, languagesService, professionalExperiencesService);
		ApiService apiService = factory.get(request.getResult().getAction());
		return apiService.fetch();
	}

}
