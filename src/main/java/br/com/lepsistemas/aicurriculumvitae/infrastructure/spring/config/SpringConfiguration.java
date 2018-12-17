package br.com.lepsistemas.aicurriculumvitae.infrastructure.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.lepsistemas.aicurriculumvitae.delivery.ResumeDeliveryApi;
import br.com.lepsistemas.aicurriculumvitae.delivery.WebhookDeliveryApi;
import br.com.lepsistemas.aicurriculumvitae.usecase.PersonalInfoService;
import br.com.lepsistemas.aicurriculumvitae.usecase.ProfessionalGoalService;
import br.com.lepsistemas.aicurriculumvitae.usecase.ResumeService;

@Configuration
public class SpringConfiguration {
	
	@Bean
	public ResumeDeliveryApi resumeDeliveryApi() {
		return new ResumeDeliveryApi(resumeService());
	}
	
	@Bean
	public WebhookDeliveryApi webhookDeliveryApi() {
		return new WebhookDeliveryApi(resumeService(), personalInfoService(), professionalGoalService());
	}

	@Bean
	public ResumeService resumeService() {
		return new ResumeService(personalInfoService());
	}

	@Bean
	public PersonalInfoService personalInfoService() {
		return new PersonalInfoService();
	}
	
	@Bean
	public ProfessionalGoalService professionalGoalService() {
		return new ProfessionalGoalService();
	}

}
